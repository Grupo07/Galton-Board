
package model;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luis Mariano Ramírez Segura
 */
public class OnesPatternTest {

    /**
     * Test of getPattern method, of class OnesPattern.
     */
    @Test
    public void testGetPattern() {
        System.out.println("getPattern");
        
        int[][] pascalTriangle = {{1}, {1, 1}, {1, 2, 1}, {1, 3, 3, 1}};
        
        ArrayList<Position>  expResult = new ArrayList<>();
        expResult.add(new Position(0, 0));
        expResult.add(new Position(1, 0));
        expResult.add(new Position(2, 0));
        expResult.add(new Position(3, 0));

        OnesPattern instance = new OnesPattern();
        ArrayList<Position> result = instance.getPattern(pascalTriangle).get(0).getPositions();
        
        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i).getRow(), result.get(i).getRow());
            assertEquals(expResult.get(i).getColumn(), result.get(i).getColumn());
        }
    }
    
}
