
package model;

import java.awt.geom.Rectangle2D;

/**
 * Rectangle of the Pascal Triangle that contains it's number
 * 
 * @author Luis Mariano Ramírez Segura
 */
public class PascalRectangle extends BasicShape {
    
    int binomialCoefficient;
    
    public PascalRectangle(int binomialCoefficient) {
        super(new Rectangle2D.Double());
        this.binomialCoefficient = binomialCoefficient;
    }
    
    /**
     * Sets the rectangle dimensions
     * 
     * @param x rectangle's x position
     * @param y rectangle's y position
     * @param height rectangle's height
     * @param width rectangle's width
     */
    @Override
    public void setDimensions(double x, double y, double height, double width) {
        super.shape = new Rectangle2D.Double(x, y, width, height);
    }
    
    /**
     * Sets the rectangle x and y position
     * 
     * @param x new rectangle's x position
     * @param y new rectangle's y position
     */
    @Override
    public void setPosition(double x, double y) {
        Rectangle2D.Double rectangle = (Rectangle2D.Double) super.shape;
        rectangle.x = x;
        rectangle.y = y;
        super.shape = rectangle;
    }

    public int getBinomialCoefficient() {
        return binomialCoefficient;
    }

    public void setBinomialCoefficient(int binomialCoefficient) {
        this.binomialCoefficient = binomialCoefficient;
    }

    
    
}
