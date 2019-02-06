package LineDrawing;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        button.addActionListener((ActionEvent e) -> {
            if (button.getText().equals("draw")) {
                button.setText("stop");
                application.add(panel);
                panel.start();
            } else if (button.getText().equals("stop") && !panel.isPause()) {
                button.setText("resume");
                panel.setPause(true);
                synchronized (panel.getThread()) {
                    panel.getThread().notify();
                }
            } else if (button.getText().equals("resume") && panel.isPause()) {
                button.setText("stop");
                panel.setPause(false);
                panel.setCurrentLines(panel.getCurrentLines()-1);
                synchronized (panel.getThread()) {
                    panel.getThread().notify();
                }
            }
        });
    }
}