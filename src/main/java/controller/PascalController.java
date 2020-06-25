
package controller;

import java.util.ArrayList;
import model.*;

/**
 * Controller to access backend Pascal triangle functionality
 * 
 * @author Luis Mariano Ramírez Segura
 */
public class PascalController {
    
    int[][] pascalTriangle;
    PascalPatternDB infoDB;
    
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
        ArrayList<PascalPositions> positions;
        switch(pattern) {
            
            case "first":
                positions = new OnesPattern().getPattern(pascalTriangle);
                break;
            
            case "second":
                positions = new ConsecutivePattern().getPattern(pascalTriangle);
                break;
                
            case "third":
                positions = new TriangularPattern().getPattern(pascalTriangle);
                break; 
                
            default:
                positions = new ArrayList<>();
                
        }
        return positions;
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
    
}
