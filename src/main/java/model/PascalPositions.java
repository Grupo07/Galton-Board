
package model;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Indicates a set of positions with a related color
 * 
 * @author Luis Mariano Ramírez Segura
 */
public class PascalPositions {
    
    private ArrayList<Position> positions;
    private Color color;

    public PascalPositions(ArrayList<Position> positions, Color color) {
        this.positions = positions;
        this.color = color;
    }

    public ArrayList<Position> getPositions() {
        return positions;
    }

    public void setPositions(ArrayList<Position> positions) {
        this.positions = positions;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
}
