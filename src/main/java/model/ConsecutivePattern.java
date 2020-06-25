
package model;

import java.awt.Color;

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
    public PascalPositions[] getPattern(int[][] pascalTriangle) {
        if (pascalTriangle.length < 2)
            return new PascalPositions[0];
        PascalPositions[] pascalPositions = new PascalPositions[1];
        Position[] positions = new Position[pascalTriangle.length - 1];
        for (int row = 0; row < positions.length; row++)
            positions[row] = new Position(row + 1, 1);
        pascalPositions[0] = new PascalPositions(positions, new Color(243, 129, 129));
        return pascalPositions;
    }
    
}
