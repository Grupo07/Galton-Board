
package model;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Pattern of triangular numbers in the third diagonal of the Pascal triangle.
 * 
 * @author Luis Mariano Ramírez Segura
 */
public class TriangularPattern implements PascalPattern {

    /**
     * Returns the third diagonal in the Pascal triangle
     * 
     * @param pascalTriangle triangle as nested arrays of integers
     * @return set of positions with a color to highlight the pattern in a Pascal triangle
     */
    @Override
    public ArrayList<PascalPositions> getPattern(int[][] pascalTriangle) {
        if (pascalTriangle.length < 3)
            return new ArrayList<>();
        
        ArrayList<PascalPositions> pascalPositions = new ArrayList<>();
        ArrayList<Position> positions = new ArrayList<>();
        
        for (int row = 2; row < pascalTriangle.length; row++)
            positions.add(new Position(row, 2));
        
        pascalPositions.add(new PascalPositions(positions, new Color(204, 175, 175)));
        return pascalPositions;
    }
    
}
