package LineDrawing;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class LineDrawingTest {

    public static void main(String[] args) {

        JFrame application = new JFrame();
        JButton button = new JButton("draw");
        LiningPanel panel = new LiningPanel();
        BoxLayout box = new BoxLayout(application.getContentPane(), BoxLayout.PAGE_AXIS);

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.getContentPane().setLayout(box);
        application.add(button);
        button.setSize(new Dimension(100, 20));
        button.setAlignmentX(JButton.CENTER_ALIGNMENT);

        application.setSize(300, 320);
        application.setTitle("Lining Art");
        application.setVisible(true);
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(button.getText().equals("draw")){
                    button.setText("pause");
                    application.add(panel);
                    panel.start();
                }                         
                //                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(button.getText().equals("pause")){
                    button.setText("resume");
                    try {
                        panel.stop();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(LineDrawingTest.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }                         
                //                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(button.getText().equals("resume")){
                    panel.start();
                    button.setText("pause");
                    //panel.stop();
                    //
                }                         
                //                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
    
    }
}