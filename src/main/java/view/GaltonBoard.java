
package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
/**
 *
 * @author Esteban Guzmán Ramírez
 */
public class GaltonBoard extends JPanel{
    
     private int rows;

    public GaltonBoard(int rows) {
        this.rows = rows;
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        drawDots(g);
        
    }
    private void drawDots(Graphics g) {
        int y = 30;
        int remainingRows = rows;
        int currentRow = 1;
        int count = 0;
        int distance = 30;
        int x = (distance / 2) * (rows + 1 - currentRow);
        int first = (distance / 2) * (rows + 1 - currentRow);
        for (int row = 1; row < rows + 1; row++) {
            for (int celd = 0; celd < row; celd++) {
                g.drawOval(x, y, 5, 5);
                if (celd == row-1) {
                    x -= ((distance) * row) - (distance / 2);
                    y += distance;
                } else {
                    x += distance;
                }
            }

        }

    }
}
