package LineDrawing;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class LineDrawingTest {

    public static void main(String[] args) {

        //set components
        JFrame application = new JFrame();
        JButton button = new JButton("draw");
        LiningPanel panel = new LiningPanel();
        BoxLayout box = new BoxLayout(application.getContentPane(), BoxLayout.PAGE_AXIS); //set up layout

        //configuration of Jfram
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.getContentPane().setLayout(box);
        //configuration of button
        application.add(button);
        button.setSize(new Dimension(100, 20));
        button.setAlignmentX(JButton.CENTER_ALIGNMENT);

        application.setSize(300, 320);
        application.setTitle("Lining Art");
        application.setVisible(true);
        
        //button listerner for three funtions: draw, stop, resume
        button.addActionListener((ActionEvent e) -> {
            //click draw, button text changes to stop, and add panel, start run
            if (button.getText().equals("draw")) { 
                button.setText("stop");
                application.add(panel);
                panel.start(); //thread start
            } 
            //click stop, button text changes to resume, panel status -> pause, synchronize thread
            else if (button.getText().equals("stop") && !panel.isPause()) {
                button.setText("resume");
                panel.setPause(true);
                synchronized (panel.getThread()) {
                    panel.getThread().notify();
                }
            } 
            //click resume, button text changes to stop, panel status -> not pause, 
            else if (button.getText().equals("resume") && panel.isPause()) {
                button.setText("stop");
                panel.setPause(false);
                panel.setCurrentLines(panel.getCurrentLines()-1);//correct currentLines
                synchronized (panel.getThread()) { //synchronize thread
                    panel.getThread().notify();
                }
            }
        });
    }
}