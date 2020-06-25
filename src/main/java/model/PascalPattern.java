
package model;

import java.util.ArrayList;

/**
 * Pattern hidden in the Pascal triangle 
 * 
 * @author Luis Mariano Ramírez Segura
 */
public interface PascalPattern {
    public ArrayList<PascalPositions> getPattern(int[][] pascalTriangle);
}
