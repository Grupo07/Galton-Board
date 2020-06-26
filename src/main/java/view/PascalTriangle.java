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
    public PascalTriangle(ArrayList<PascalRectangle> list, int rows){
        this.list = list;
        this.rows = rows;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).getDrawable().getBounds2D().getX()
            +":"+list.get(i).getDrawable().getBounds2D().getY()+"/"
            +":"+list.get(i).getDrawable().getBounds2D().getWidth()
            +":"+list.get(i).getDrawable().getBounds2D().getHeight()
            +":"+list.get(i).getColor()+"\n");
            list.get(i).setDimensions(100, 100, 50, 50);
            g2.draw(list.get(i).getDrawable().getBounds2D());
            g.drawString(list.get(i).getBinomialCoefficient()+"", 
                (int) list.get(i).getDrawable().getBounds2D().getCenterX()-10, 
                (int) list.get(i).getDrawable().getBounds2D().getCenterY());
        }
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
    
    
}
