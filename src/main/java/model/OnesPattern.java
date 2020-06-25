
package model;

import java.awt.Color;

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
    public PascalPositions[] getPattern(int[][] pascalTriangle) {
        PascalPositions[] pascalPositions = new PascalPositions[1];
        Position[] positions = new Position[pascalTriangle.length];
        for (int row = 0; row < positions.length; row++)
            positions[row] = new Position(row, 0);
        pascalPositions[0] = new PascalPositions(positions, new Color(149, 225, 211));
        return pascalPositions;
    }
    
}
