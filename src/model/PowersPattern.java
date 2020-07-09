
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
        Color[] colors = new Color[]{new Color(67,103,88), new Color(61, 132, 168), 
                                     new Color(99, 183, 175), new Color(171, 240, 233), 
                                     new Color(40,56,81), new Color(17, 24, 47),
                                     new Color(207,235,223), new Color(46,72,61), 
                                     new Color(64,70,88), new Color(104,133,121)};
        
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
