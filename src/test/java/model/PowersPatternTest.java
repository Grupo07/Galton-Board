
package model;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luis Mariano Ramírez Segura
 */
public class PowersPatternTest {

    /**
     * Test of getPattern method, of class PowersPattern.
     */
    @Test
    public void testGetPattern() {
        System.out.println("getPattern");
        int[][] pascalTriangle = PascalTriangleGenerator.getPascalTriangle(4);
        
        int[][][] expResult = {{{0,0}},
                               {{1,0}, {1,1}},
                               {{2,0}, {2,1}, {2,2}},
                               {{3,0}, {3,1}, {3,2}, {3,3}}};
        
        PowersPattern instance = new PowersPattern();
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
     * Test of getDetails method, of class PowersPattern.
     */
    @Test
    public void testGetDetails() {
        System.out.println("getDetails");
        
        int[][] pascalTriangle = PascalTriangleGenerator.getPascalTriangle(5);
        
        ArrayList<String[]> expResults = new ArrayList<>();
        expResults.add(new String[]{"1", "1"});
        expResults.add(new String[]{"2", "1+1"});
        expResults.add(new String[]{"4", "1+2+1"});
        expResults.add(new String[]{"8", "1+3+3+1"});
        expResults.add(new String[]{"16", "1+4+6+4+1"});
        
        PowersPattern instance = new PowersPattern();
        ArrayList<String[]> results = instance.getDetails(pascalTriangle);
        
        for (int i = 0; i < results.size(); i++) {
            String[] expResult = expResults.get(i);
            String[] result = results.get(i);
            assertEquals(expResult[0], result[0]);
            assertEquals(expResult[1], result[1]);
        }
    }
    
}
