
package model;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luis Mariano Ramírez Segura
 */
public class FibonacciPatternTest {

    /**
     * Test of getPattern method, of class FibonacciPattern.
     */
    @Test
    public void testGetPattern() {
        System.out.println("getPattern");
        int[][] pascalTriangle = PascalTriangleGenerator.getPascalTriangle(5);
        
        int[][][] expResult = {{{0,0}},
                               {{1,0}},
                               {{2,0}, {1,1}},
                               {{3,0}, {2,1}},
                               {{4,0}, {3,1}, {2,2}}};
        
        
        FibonacciPattern instance = new FibonacciPattern();
        ArrayList<PascalPositions> result = instance.getPattern(pascalTriangle);
        
        for (int i = 0; i < result.size(); i++) {
            ArrayList<Position> positions = result.get(i).getPositions();
            for (int j = 0; j < positions.size(); j++) {
                assertEquals(positions.get(j).getRow(), expResult[i][j][0]);
                assertEquals(positions.get(j).getColumn(), expResult[i][j][1]);
            }
        }
    }

    /**
     * Test of getDetails method, of class FibonacciPattern.
     */
    @Test
    public void testGetDetails() {
        System.out.println("getDetails");
        
        int[][] pascalTriangle = PascalTriangleGenerator.getPascalTriangle(5);
        
        ArrayList<String[]> expResults = new ArrayList<>();
        expResults.add(new String[]{"1", "1"});
        expResults.add(new String[]{"1", "1"});
        expResults.add(new String[]{"2", "1+1"});
        expResults.add(new String[]{"3", "1+2"});
        expResults.add(new String[]{"5", "1+3+1"});
        
        FibonacciPattern instance = new FibonacciPattern();
        ArrayList<String[]> results = instance.getDetails(pascalTriangle);
        
        for (int i = 0; i < results.size(); i++) {
            String[] expResult = expResults.get(i);
            String[] result = results.get(i);
            assertEquals(expResult[0], result[0]);
            assertEquals(expResult[1], result[1]);
        }
        
    }
    
}
