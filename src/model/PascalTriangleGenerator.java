package model;

import java.util.ArrayList;


/**
 * Offers useful math utilities to work with the Pascal triangle.
 * 
 * @author Luis Mariano Ramírez Segura
 */
public class PascalTriangleGenerator {
    
    /**
     * Returns the factorial of a number
     * @param number number to calculate factorial
     * @return factorial of a number
     */
    public static int getFactorial(int number) {
        if (number <= 1)
            return 1;
        else
            return number * getFactorial(number - 1);
    }
    
    /**
     * Returns the binomial coefficient of a given position in the Pascal Triangle
     * @param row triangle's row
     * @param column triangle's column
     * @return position coefficient calculated
     */
    public static int getBinomialCoefficient(int row, int column) {
        return getFactorial(row) / ( getFactorial(row-column) * getFactorial(column) );
    }
    
    /**
     * Returns a Pascal Triangle row 
     * @param row row in the triangle
     * @return a list with the corresponding binomial coefficients in the triangle
     */
    public static int[] getPascalTriangleRow(int row) {
        int[] triangleRow = new int[row + 1];
        for (int column = 0; column < triangleRow.length; column++) {
            triangleRow[column] = getBinomialCoefficient(row, column);
        }
        return triangleRow;
    }
    
    /**
     * Returns the Pascal Triangle as a nested array of integers
     * @param rows triangle height 
     * @return array of arrays with the corresponding values in the triangle
     */
    public static int[][] getPascalTriangle(int rows) {
        int[][] pascalTriangle = new int[rows][];
        for (int row = 0; row < rows; row++) {
            pascalTriangle[row] = getPascalTriangleRow(row);
        }
        return pascalTriangle;
    }
    
    /**
     * Returns the Pascal rectangles out of a given Pascal triangle to display
     * 
     * @param pascalTriangle Pascal Triangle as a nested array of integers
     * @return list of Pascal rectangles to display
     */
    public static ArrayList<PascalRectangle> getPascalRectangles(int[][] pascalTriangle) {
        ArrayList<PascalRectangle> pascalRectangles = new ArrayList<>();
        for (int[] row : pascalTriangle) {
            for (int coefficient : row) {
                pascalRectangles.add(new PascalRectangle(coefficient));
            }
        }
        return pascalRectangles;
    }
    
}
