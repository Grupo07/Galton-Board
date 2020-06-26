
package model;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Pattern of Fibonacci numbers by summing the diagonals in the Pascal triangle.
 * 
 * @author Luis Mariano Ramírez Segura
 */
public class FibonacciPattern implements PascalPattern {
    
    /**
     * Returns the Fibonacci sequence in the Pascal triangle
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
        

        for (int i = 0; i < pascalTriangle.length; i++) {
            ArrayList<Position> positions = new ArrayList<>();
            
            int row = i;
            for (int column = 0; column < pascalTriangle[row].length; column++) {
                
                
                positions.add(new Position(row, column));
                
                row -= 1;
                if (row < 0)
                    break;
            }
            
            pascalPositions.add(new PascalPositions(positions, colors[i]));
        }
        
        return pascalPositions;
    }
    
    /**
     * Return the a list with the Fibonacci values and it's respective sums out of a Pascal triangle
     * 
     * @param pascalTriangle triangle as nested arrays of integers
     * @return list with the Fibonacci values and it's respective sums to display
     */
    public ArrayList<String[]> getDetails(int[][] pascalTriangle) {
        ArrayList<String[]> details = new ArrayList<>();
        
        for (int i = 0; i < pascalTriangle.length; i++) {
            ArrayList<Position> positions = new ArrayList<>();
            
            int fibonacciNumber = 0;
            String fibonacciSum = "";
            int row = i;
            for (int column = 0; column < pascalTriangle[row].length; column++) {
                
                fibonacciNumber += pascalTriangle[row][column];
                
                if(!fibonacciSum.equals(""))
                    fibonacciSum += "+";
                fibonacciSum += String.valueOf(pascalTriangle[row][column]);
                
                
                row -= 1;
                if (row < 0)
                    break;
            }
            String[] detail = new String[]{String.valueOf(fibonacciNumber), fibonacciSum};
            details.add(detail);
        }
        
        return details;
    }
    
    /**
     * Return the number in position n in the Fibonacci
     * @param n
     * @return 
     */
    private int getFibonacciNumber(int n) {
        if (n < 2)
            return n;
        else
            return getFibonacciNumber(n - 1) + getFibonacciNumber(n - 2);
    }
    
}
