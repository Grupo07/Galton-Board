
package model;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luis Mariano Ramírez Segura
 */
public class ConsecutivePatternTest {

    /**
     * Test of getPattern method, of class ConsecutivePattern.
     */
    @Test
    public void testGetPattern() {
        System.out.println("getPattern");
        
        int[][] pascalTriangle = {{1}, {1, 1}, {1, 2, 1}, {1, 3, 3, 1}};
        
        ArrayList<Position>  expResult = new ArrayList<>();
        expResult.add(new Position(1, 1));
        expResult.add(new Position(2, 1));
        expResult.add(new Position(3, 1));
        
        ConsecutivePattern instance = new ConsecutivePattern();
        ArrayList<Position> result = instance.getPattern(pascalTriangle).get(0).getPositions();
        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i).getRow(), result.get(i).getRow());
            assertEquals(expResult.get(i).getColumn(), result.get(i).getColumn());
        }
    }
    
}
