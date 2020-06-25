
package model;

import java.awt.Color;

/**
 * Indicates a set of positions with a related color
 * 
 * @author Luis Mariano Ramírez Segura
 */
public class PascalPositions {
    
    private Position[] positions;
    private Color color;

    public PascalPositions(Position[] positions, Color color) {
        this.positions = positions;
        this.color = color;
    }

    public Position[] getPositions() {
        return positions;
    }

    public void setPositions(Position[] positions) {
        this.positions = positions;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
}
