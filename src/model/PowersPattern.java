
package model;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Pattern of powers of two in the Pascal triangle.
 * 
 * @author Luis Mariano Ramírez Segura
 */
public class PowersPattern implements PascalPattern {

    /**
     * Returns the powers of two in the Pascal triangle
     * 
     * @param pascalTriangle triangle as nested arrays of integers
     * @return set of positions with a color to highlight the pattern in a Pascal triangle
     */
    @Override
    public ArrayList<PascalPositions> getPattern(int[][] pascalTriangle) {
        Color[] colors = new Color[]{new Color(241, 227, 203), new Color(61, 132, 168), 
                                     new Color(99, 183, 175), new Color(171, 240, 233), 
                                     new Color(212, 243, 239), new Color(238, 133, 114),
                                     new Color(249, 179, 132), new Color(202, 81, 22), 
                                     new Color(157, 51, 21), new Color(226, 62, 87)};
        
        ArrayList<PascalPositions> pascalPositions = new ArrayList<>();
        

        for (int row = 0; row < pascalTriangle.length; row++) {
            ArrayList<Position> positions = new ArrayList<>();
            
            
            for (int column = 0; column < pascalTriangle[row].length; column++)
                positions.add(new Position(row, column));
                
            pascalPositions.add(new PascalPositions(positions, colors[row]));
        }
        
        return pascalPositions;
    }
    
    /**
     * Return the a list with the powers of two values and it's respective sums out of a Pascal triangle
     * 
     * @param pascalTriangle triangle as nested arrays of integers
     * @return list with the powers of two values and it's respective sums to display
     */
    public ArrayList<String[]> getDetails(int[][] pascalTriangle) {
        ArrayList<String[]> details = new ArrayList<>();
        
        for (int row = 0; row < pascalTriangle.length; row++) {
            
            String sum = "";
            for (int column = 0; column < pascalTriangle[row].length; column++) {
                
                if(!sum.equals(""))
                    sum += "+";
                sum += String.valueOf(pascalTriangle[row][column]);
            }
            
            String[] detail = new String[]{String.valueOf((int) Math.pow(2, row)), sum};
            details.add(detail);
        }
        
        return details;
    }
    
}
