
package model;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Pattern of consecutive numbers in the second diagonal of the Pascal triangle.
 * 
 * @author Luis Mariano Ramírez Segura
 */
public class ConsecutivePattern implements PascalPattern {

    /**
     * Returns the second diagonal in the Pascal triangle
     * 
     * @param pascalTriangle triangle as nested arrays of integers
     * @return set of positions with a color to highlight the pattern in a Pascal triangle
     */
    @Override
    public ArrayList<PascalPositions> getPattern(int[][] pascalTriangle) {
        if (pascalTriangle.length < 2)
            return new ArrayList<>();
        
        ArrayList<PascalPositions> pascalPositions = new ArrayList<>();
        ArrayList<Position> positions = new ArrayList<>();
        
        for (int row = 1; row < pascalTriangle.length; row++)
            positions.add(new Position(row, 1));
        
        pascalPositions.add(new PascalPositions(positions, new Color(29,40,79)));
        return pascalPositions;
        
    }
    
}
