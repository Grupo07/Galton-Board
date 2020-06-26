
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
public class OddEvenPatternTest {

    /**
     * Test of getPattern method, of class OddEvenPattern.
     */
    @Test
    public void testGetPattern() {
        System.out.println("getPattern");
        
        ArrayList<Position>  expResult = new ArrayList<>();
        expResult.add(new Position(0, 0));
        expResult.add(new Position(1, 0));
        expResult.add(new Position(1, 1));
        expResult.add(new Position(2, 0));
        expResult.add(new Position(2, 2));
        expResult.add(new Position(3, 0));
        expResult.add(new Position(3, 1));
        expResult.add(new Position(3, 2));
        expResult.add(new Position(3, 3));
        
        int[][] pascalTriangle = PascalTriangleGenerator.getPascalTriangle(4);
        
        OddEvenPattern instance = new OddEvenPattern();
        ArrayList<Position> result = instance.getPattern(pascalTriangle).get(0).getPositions();
        
        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i).getRow(), result.get(i).getRow());
            assertEquals(expResult.get(i).getColumn(), result.get(i).getColumn());
        }
    }
    
}
