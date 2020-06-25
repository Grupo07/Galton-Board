
package model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luis Mariano Ramírez Segura
 */
public class GaltonPathGeneratorTest {

    /**
     * Test of getPath method, of class GaltonPathGenerator.
     */
    @Test
    public void testGetPath() {
        System.out.println("getPath");
        int galtonBoardHeight = 3;
        float rightProbability = 0.0F;
        String[] expResult = new String[]{"left", "left", "left"};
        String[] result = GaltonPathGenerator.getPath(galtonBoardHeight, rightProbability);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getLeftOrRight method, of class GaltonPathGenerator.
     */
    @Test
    public void testGetLeftOrRight() {
        System.out.println("getLeftOrRight");
        float rightProbability = 1.0F;
        String expResult = "right";
        String result = GaltonPathGenerator.getLeftOrRight(rightProbability);
        assertEquals(expResult, result);
    }
    
}
