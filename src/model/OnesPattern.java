
package model;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Pattern of only number one in the first diagonal of the Pascal triangle.
 * 
 * @author Luis Mariano Ramírez Segura
 */
public class OnesPattern implements PascalPattern {

    /**
     * Returns the first diagonal in the Pascal triangle
     * 
     * @param pascalTriangle triangle as nested arrays of integers
     * @return set of positions with a color to highlight the pattern in a Pascal triangle
     */
    @Override
    public ArrayList<PascalPositions> getPattern(int[][] pascalTriangle) {
        
        ArrayList<PascalPositions> pascalPositions = new ArrayList<>();
        ArrayList<Position> positions = new ArrayList<>();
        
        for (int row = 0; row < pascalTriangle.length; row++)
            positions.add(new Position(row, 0));
        
        pascalPositions.add(new PascalPositions(positions, new Color(207,235,223)));
        
        return pascalPositions;
    }
    
}
