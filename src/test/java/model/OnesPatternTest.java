
package model;

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
        Position[] expResult = new Position[]{new Position(0, 0), 
                                              new Position(1, 0),
                                              new Position(2, 0),
                                              new Position(3, 0)};
        OnesPattern instance = new OnesPattern();
        Position[] result = instance.getPattern(pascalTriangle)[0].getPositions();
        for (int i = 0; i < result.length; i++) {
            assertEquals(expResult[i].getRow(), result[i].getRow());
            assertEquals(expResult[i].getColumn(), result[i].getColumn());
        }
    }
    
}
