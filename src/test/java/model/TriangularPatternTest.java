/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Luis Mariano Ramírez Segura
 */
public class TriangularPatternTest {

    /**
     * Test of getPattern method, of class TriangularPattern.
     */
    @Test
    public void testGetPattern() {
        System.out.println("getPattern");
        int[][] pascalTriangle = {{1}, {1, 1}, {1, 2, 1}, {1, 3, 3, 1}};
        Position[] expResult = new Position[]{new Position(2, 2), 
                                              new Position(3, 2)};
        TriangularPattern instance = new TriangularPattern();
        Position[] result = instance.getPattern(pascalTriangle)[0].getPositions();
        for (int i = 0; i < result.length; i++) {
            assertEquals(expResult[i].getRow(), result[i].getRow());
            assertEquals(expResult[i].getColumn(), result[i].getColumn());
        }
    }
    
}
