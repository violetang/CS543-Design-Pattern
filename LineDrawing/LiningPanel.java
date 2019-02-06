package LineDrawing;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * LiningPanel class to draw multiple lines in graph
 *
 * @version 1.1 modified for Dr.Fan's version
 * @author RunXu & Jiali Tang
 */
public class LiningPanel extends javax.swing.JPanel {

    //variable field

    private double currentLines = -1; // the total lines in current time
    private final double lines = 15.0; // maximum total lines
    private int w = 0; // width of the graphics g
    private int h = 0; // height of the graphics g
    private int w2, h2, w3, h3; // new w or h for a point at edges
    private Thread p = null; // thread to achieve animation
    private boolean pause = false; // signal to pause or notify a thread

    //default constructor
    public LiningPanel() {
        //do nothing
    }

    @Override
    /**
     * Override paintComponent to draw the graphics g
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //System.out.println(p.getName() + " " + currentLines + "w2 " + w2);
        w = getWidth(); // get the wigth of g
        h = getHeight(); // get the height of g
        //using for loop to draw the graphs with multiple lines
        for (int i = 0; i <= currentLines; i++) {
            w2 = (int) ((i / lines) * w); // from 0 to w
            h2 = (int) ((i / lines) * h); // from 0 to h
            w3 = (int) (((lines - i) / lines) * w); // from w to 0
            h3 = (int) (((lines - i) / lines) * h); // from h to 0
            setNewColor(g);
            g.drawLine(0, h2, w2, h); // left side to bottom side
            g.drawLine(0, h2, w3, 0); // up side to left side
            g.drawLine(w2, h, w, h3); // bottom side to right side
            g.drawLine(w3, 0, w, h3); // right side to up side
        }
    }

    /**
     * start method to start the thread p to achieve animation
     */
    public void start() {
        //define thread p
        p = new Thread(() -> {
            //while currentLines < lines, continue run the thread
            while (currentLines < lines) {
                // if the signal pause is true(user clicks "stop" button)
                if (pause) {
                    // try to pause thread p and wait for the signal 
                    synchronized (p) {
                        try {
                            p.wait(); //let p in the waiting queue
                        } catch (Exception ex) {
                            ex.getStackTrace();
                        }
                    }
                }
                // update currentLines(do the graph in infinite loop unless
                // user stops it)
                currentLines = (currentLines + 1) % lines;
                // let p sleep for a certain time 
                try {
                    Thread.sleep(1000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                //repaint the component of this panel
                repaint();
            }
        });
        p.start(); // start thread p
    }

    //Setters and Getters
    /**
     * setNewColor to set random color for next lines
     *
     * @param g - the graphics we use
     */
    public void setNewColor(Graphics g) {
        //random get the R,G,B values
        Random rand = new Random();
        int R = rand.nextInt(255);
        int G = rand.nextInt(255);
        int B = rand.nextInt(255);
        Color c = new Color(R, G, B); // create a new color
        g.setColor(c); // set color to g
    }
    
    /**
     * setCurrentLines to set the current total lines
     * @param line -- the number of total lines
     */
    public void setCurrentLines(double line) {
        this.currentLines = line;
    }

    /**
     * setPause to change the value of signal pause
     * @param pause - the new value 
     */
    public void setPause(boolean pause) {
        this.pause = pause;
    }

    /**
     * getCurrentLines to get the total number of lines
     * @return currentLines
     */
    public double getCurrentLines() {
        return this.currentLines;
    }

    /**
     * getThread to get the thread for animation
     * @return p
     */
    public Thread getThread() {
        return this.p;
    }

    /**
     * isPause to boolean if a thread in LiningPanel is paused
     * @return pause
     */
    public boolean isPause() {
        return pause;
    }

}