package LineDrawing;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LineDrawingTest {

    public static void main(String[] args) {

        JFrame application = new JFrame();
        JButton b = new JButton("resume");
        LiningPanel panel = new LiningPanel();
        panel.add(b); 

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(300, 300);
        application.setTitle("Lining Art");
        application.setVisible(true);   
    }
}
