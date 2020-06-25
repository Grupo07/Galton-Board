
package model;

import java.awt.Color;

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
    public PascalPositions[] getPattern(int[][] pascalTriangle) {
        if (pascalTriangle.length < 3)
            return new PascalPositions[0];
        PascalPositions[] pascalPositions = new PascalPositions[1];
        Position[] positions = new Position[pascalTriangle.length - 2];
        for (int row = 0; row < positions.length; row++)
            positions[row] = new Position(row + 2, 2);
        pascalPositions[0] = new PascalPositions(positions, new Color(204, 175, 175));
        return pascalPositions;
    }
    
}
