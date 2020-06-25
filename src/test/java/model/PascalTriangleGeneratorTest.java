
package model;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Luis Mariano Ramírez Segura
 */
public class PascalTriangleGeneratorTest {

    /**
     * Test of getFactorial method, of class PascalTriangleGenerator.
     */
    @Test
    public void testGetFactorial() {
        System.out.println("getFactorial");
        
        int number = 5;
        int expResult = 120;
        
        int result = PascalTriangleGenerator.getFactorial(number);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getBinomialCoefficient method, of class PascalTriangleGenerator.
     */
    @Test
    public void testGetBinomialCoefficient() {
        System.out.println("getBinomialCoefficient");
        
        int row = 5;
        int column = 2;
        int expResult = 10;
        
        int result = PascalTriangleGenerator.getBinomialCoefficient(row, column);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getPascalTriangleRow method, of class PascalTriangleGenerator.
     */
    @Test
    public void testGetPascalTriangleRow() {
        System.out.println("getPascalTriangleRow");

        int[] expResult = new int[]{1, 5, 10, 10, 5, 1};
        
        int row = 5;
        int[] result = PascalTriangleGenerator.getPascalTriangleRow(row);
        
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getPascalTriangle method, of class PascalTriangleGenerator.
     */
    @Test
    public void testGetPascalTriangle() {
        System.out.println("getPascalTriangle");
       
        int[][] expResult = {{1}, {1, 1}, {1, 2, 1}, {1, 3, 3, 1}};
        
        int rows = 4;
        int[][] result = PascalTriangleGenerator.getPascalTriangle(rows);
        
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getPascalRectangles method, of class PascalTriangleGenerator.
     */
    @Test
    public void testGetPascalRectangles() {
        System.out.println("getPascalRectangles");
        
        int[][] pascalTriangle = {{1}, {1, 1}, {1, 2, 1}, {1, 3, 3, 1}};
        
        ArrayList<PascalRectangle> expResult = new ArrayList<>();
        expResult.add(new PascalRectangle(1));
        expResult.add(new PascalRectangle(1));
        expResult.add(new PascalRectangle(1));
        expResult.add(new PascalRectangle(1));
        expResult.add(new PascalRectangle(2));
        expResult.add(new PascalRectangle(1));
        expResult.add(new PascalRectangle(1));
        expResult.add(new PascalRectangle(3));
        expResult.add(new PascalRectangle(3));
        expResult.add(new PascalRectangle(1));
        
        ArrayList<PascalRectangle> result = PascalTriangleGenerator.getPascalRectangles(pascalTriangle);
        
        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i).binomialCoefficient, result.get(i).binomialCoefficient);
        }
        
    }
    
}
