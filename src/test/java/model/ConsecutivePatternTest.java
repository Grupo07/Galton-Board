
package model;

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
    
    public ConsecutivePatternTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPattern method, of class ConsecutivePattern.
     */
    @Test
    public void testGetPattern() {
        System.out.println("getPattern");
        int[][] pascalTriangle = {{1}, {1, 1}, {1, 2, 1}, {1, 3, 3, 1}};
        Position[] expResult = new Position[]{new Position(1, 1), 
                                              new Position(2, 1),
                                              new Position(3, 1)};
        ConsecutivePattern instance = new ConsecutivePattern();
        Position[] result = instance.getPattern(pascalTriangle)[0].getPositions();
        for (int i = 0; i < result.length; i++) {
            assertEquals(expResult[i].getRow(), result[i].getRow());
            assertEquals(expResult[i].getColumn(), result[i].getColumn());
        }
    }
    
}
