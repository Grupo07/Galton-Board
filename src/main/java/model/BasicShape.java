
package model;

import java.awt.Color;
import java.awt.Shape;

/**
 * Basic representation of a shape with color
 * 
 * @author Luis Mariano Ramírez Segura
 */
public abstract class BasicShape {
    
    protected Shape shape;
    private Color color;

    public BasicShape(Shape shape) {
        this.shape = shape;
        this.color = Color.RED;
    }
    
    public abstract void setDimensions(double x, double y, double width, double height);
    
    public abstract void setPosition(double x, double y);

    public Shape getDrawable() {
        return shape;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
}
