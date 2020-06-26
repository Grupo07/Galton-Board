package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import model.PascalRectangle;

/**
 *
 * @author Esteban Guzmán Ramírez
 */
public class PascalTriangle extends JPanel{
    private ArrayList<PascalRectangle> list;
    private int rows;
    private int triangleWidth = 40; 
    public PascalTriangle(ArrayList<PascalRectangle> list, int rows){
        this.list = list;
        this.rows = rows;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        setCoordinates();
        for (int i = 0; i < list.size(); i++) {
            g2.draw(list.get(i).getDrawable().getBounds2D());
            if (list.get(i).getBinomialCoefficient() > 99) {
                g.drawString(list.get(i).getBinomialCoefficient() + "",
                    (int) list.get(i).getDrawable().getBounds2D().getCenterX() - 10,
                    (int) list.get(i).getDrawable().getBounds2D().getCenterY() + 2);
            } else if (list.get(i).getBinomialCoefficient() > 9 ) {
                g.drawString(list.get(i).getBinomialCoefficient() + "",
                    (int) list.get(i).getDrawable().getBounds2D().getCenterX() - 6,
                    (int) list.get(i).getDrawable().getBounds2D().getCenterY() + 2);
            } else {
                g.drawString(list.get(i).getBinomialCoefficient() + "",
                        (int) list.get(i).getDrawable().getBounds2D().getCenterX() - 2,
                        (int) list.get(i).getDrawable().getBounds2D().getCenterY() + 2);
            }
        }
    }
    
    private void setCoordinates(){
        int y = 30;
        int remainingRows = rows;
        int currentRow = 1;
        int count = 0;
        int x = (triangleWidth/2)*(rows+1-currentRow);
        int first = (triangleWidth/2)*(rows+1-currentRow);
        for(int i = 0; i < list.size(); i++){
            list.get(i).setDimensions(x, y, triangleWidth, triangleWidth);
            count++;
            if(count == currentRow){
              remainingRows += -1;
              remainingRows--;
              count = 0;
              x -= ((triangleWidth)*currentRow)-(triangleWidth/2);
              currentRow++;
              y += triangleWidth;
              
            } else{
              x += triangleWidth;
            }
        }
    }
    
    
    
}
