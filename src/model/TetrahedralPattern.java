
package model;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Pattern of consecutive numbers in the fourth diagonal of the Pascal triangle.
 * 
 * @author Luis Mariano Ramírez Segura
 */
public class TetrahedralPattern implements PascalPattern {

    /**
     * Returns the fourth diagonal in the Pascal triangle
     * 
     * @param pascalTriangle triangle as nested arrays of integers
     * @return set of positions with a color to highlight the pattern in a Pascal triangle
     */
    @Override
    public ArrayList<PascalPositions> getPattern(int[][] pascalTriangle) {
        if (pascalTriangle.length < 4)
            return new ArrayList<>();
        
        ArrayList<PascalPositions> pascalPositions = new ArrayList<>();
        ArrayList<Position> positions = new ArrayList<>();
        
        for (int row = 3; row < pascalTriangle.length; row++)
            positions.add(new Position(row, 3));
        
        pascalPositions.add(new PascalPositions(positions, new Color(60,106,109)));
        return pascalPositions;
    }
    
}
