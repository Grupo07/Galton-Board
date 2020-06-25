
package model;

import java.awt.geom.Ellipse2D;

/**
 * Circle of the Galton board that contains it's falling path
 * 
 * @author Luis Mariano Ramírez Segura
 */
public class GaltonCircle extends BasicShape {
    
    private String[] path;

    public GaltonCircle(String[] path) {
        super(new Ellipse2D.Double());
        this.path = path;
    }

    /**
     * Sets the circle dimensions
     * 
     * @param x circle's x position
     * @param y circle's y position
     * @param height circle's height
     * @param width circle's width
     */
    @Override
    public void setDimensions(double x, double y, double width, double height) {
        super.shape = new Ellipse2D.Double(x, y, width, height);
    }

    /**
     * Sets the circle x and y position
     * 
     * @param x new circle's x position
     * @param y new circle's y position
     */
    @Override
    public void setPosition(double x, double y) {
        Ellipse2D.Double circle = (Ellipse2D.Double) super.shape;
        circle.x = x;
        circle.y = y;
        super.shape = circle;
    }

    public String[] getPath() {
        return path;
    }

    public void setPath(String[] path) {
        this.path = path;
    }
    
}
