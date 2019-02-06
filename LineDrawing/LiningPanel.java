package LineDrawing;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class LiningPanel extends javax.swing.JPanel{// implements Runnable {
    //private Thread update;

    double j = -1;
    double lines = 15.0;
    int w = 0;
    int h = 0;
    int w2, h2, w3, h3;
    // Thread thread = null;
    private Graphics G;
    Thread p = null;
    boolean run = false;
    
    public LiningPanel() {

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        System.out.println(j + "w2 " + w2);
        w = getWidth();
        h = getHeight();
       
        for (int i = 0; i <= j; i++) {
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

   /* @Override
    public void run() {
        while (j < lines) {
            j++;
            try {
                Thread.sleep(500);
            } catch (Exception ex) {
                ex.getStackTrace();
            }
            repaint();
        }

    }*/

    public void stop() throws InterruptedException {
       p.stop();
    }
    
    public void resume(){
        p.start();
    }
    
    public void update(Graphics g){
        paintComponent(g);
    }
    public void start() {
        p = new Thread(new Runnable() {
            @Override
            public void run() {
                while (j < lines) {
                    j = (j+1)%lines;
                    try {
                        Thread.sleep(1000);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    repaint();
                }
            }
        });
        p.start();
    }

    //Method to set random new color for next lines

    public void setNewColor(Graphics g) {
        Random rand = new Random();
        int R = rand.nextInt(255);
        int G = rand.nextInt(255);
        int B = rand.nextInt(255);
        Color c = new Color(R, G, B);
        g.setColor(c);
    }

}