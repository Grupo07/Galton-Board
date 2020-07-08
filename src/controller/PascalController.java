
package controller;

import java.util.ArrayList;
import model.*;

/**
 * Controller to access backend Pascal triangle functionality
 * 
 * @author Luis Mariano Ramírez Segura
 */
public class PascalController {
    
    private int[][] pascalTriangle;
    private PascalPatternDB infoDB;
    
    public PascalController(int pascalTriangleHeight) {
        this.pascalTriangle = PascalTriangleGenerator.getPascalTriangle(pascalTriangleHeight);
        this.infoDB = new PascalPatternDB();
    }
    
    /**
     * Returns the Pascal rectangles to display out of the current Pascal triangle
     * @return List of Pascal rectangles
     */
    public ArrayList<PascalRectangle> getPascalRectangles() {
        return PascalTriangleGenerator.getPascalRectangles(pascalTriangle);
    }
    
    /**
     * Returns the correspondent highlight positions to a pattern
     * 
     * @param pattern Pascal triangle pattern name
     * @return list of Pascal positions to highlight the triangle
     */
    public ArrayList<PascalPositions> getPascalPattern(String pattern) {
        switch(pattern) {
            
            case "first":
                return new OnesPattern().getPattern(pascalTriangle);
            
            case "second":
                return new ConsecutivePattern().getPattern(pascalTriangle);
                
            case "third":
                return new TriangularPattern().getPattern(pascalTriangle);
            
            case "fourth":
                return new TetrahedralPattern().getPattern(pascalTriangle);
            
            case "fibonacci":
                return new FibonacciPattern().getPattern(pascalTriangle); 
            
            case "oddeven":
                return new OddEvenPattern().getPattern(pascalTriangle); 
            
            case "powers":
                return new PowersPattern().getPattern(pascalTriangle); 
                
            default:
                return new ArrayList<>();
        }
    }
    
    /**
     * Returns the information related to a Pascal triangle pattern
     * 
     * @param pattern name of the Pascal triangle pattern
     * @return pattern information related to the pattern
     */
    public String getPatternInfo(String pattern) {
        return infoDB.getPatternInfo(pattern);
    }
    
    /**
     * Updates the Pascal triangle height
     * 
     * @param height new Pascal triangle height
     */
    public void updateTriangleHeight(int height) {
        this.pascalTriangle = PascalTriangleGenerator.getPascalTriangle(height);
    }
    
    /**
     * Returns display details for Pascal triangle patterns
     * 
     * @param pattern name of the Pascal triangle pattern
     * @return list of string arrays that contains a pattern value and value sums
     */
    public ArrayList<String[]> getPatternDisplayDetails(String pattern) {
        switch (pattern) {
            
            case "fibonacci":
                return new FibonacciPattern().getDetails(pascalTriangle);
            
            case "oddeven":
                return new PowersPattern().getDetails(pascalTriangle);
                
            default:
                return new ArrayList<>(); 
        }
    }
    
}
