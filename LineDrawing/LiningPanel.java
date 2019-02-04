package LineDrawing;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class LiningPanel extends javax.swing.JPanel {

    public LiningPanel() { }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        
        double lines = 15.0;
        

        for(int i = 0; i < lines; i++)
        {
            int w2 = (int)((i/lines)*w); 
            int h2 = (int)((i/lines)*h); 

            Random rand = new Random();
            float red = rand.nextFloat();
            float green = rand.nextFloat();
            float yellow = rand.nextFloat();

            Color myColor = new Color(red,green,yellow);

            //左下角
            g.drawLine(0,  h2, w2, h);
            g.setColor(myColor);

            //右上角
            g.drawLine(w,  h2, w2, 0);

            //右下角
            g.drawLine(w, h-h2, w2, h);
           
            //左上角
            g.drawLine(0, h-h2, w2, 0);
    
        }
        
    }
    
}
