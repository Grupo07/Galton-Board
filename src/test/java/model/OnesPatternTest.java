
package model;

import java.awt.Color;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Ones Pattern unit tests
 * 
 * @author Luis Mariano Ramírez Segura
 */
public class OnesPatternTest {

    /**
     * Test of getPattern method, of class onesPattern.
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
