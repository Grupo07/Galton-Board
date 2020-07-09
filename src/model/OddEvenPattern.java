
package model;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Pattern of odd and even numbers in the Pascal triangle
 * 
 * @author Luis Mariano Ramírez Segura
 */
public class OddEvenPattern implements PascalPattern {

    /**
     * Returns the odd numbers positions in the Pascal triangle
     * 
     * @param pascalTriangle triangle as nested arrays of integers
     * @return set of positions with a color to highlight the pattern in a Pascal triangle
     */
    @Override
    public ArrayList<PascalPositions> getPattern(int[][] pascalTriangle) {
        
        ArrayList<PascalPositions> pascalPositions = new ArrayList<>();
        
        ArrayList<Position> positions = new ArrayList<>();
        
        for (int row = 0; row < pascalTriangle.length; row++) {
           
            for (int column = 0; column < pascalTriangle[row].length; column++) {
                boolean oddNumber = (pascalTriangle[row][column] % 2 != 0);
                if (oddNumber)
                    positions.add(new Position(row, column));
            }
            
        }
        
        pascalPositions.add(new PascalPositions(positions, new Color(29,40,79)));
        
        return pascalPositions;
    }
    
}
