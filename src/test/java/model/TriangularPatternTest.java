/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
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
        
        
        ArrayList<Position>  expResult = new ArrayList<>();
        expResult.add(new Position(2, 2));
        expResult.add(new Position(3, 2));

        TriangularPattern instance = new TriangularPattern();
        ArrayList<Position> result = instance.getPattern(pascalTriangle).get(0).getPositions();
        
        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i).getRow(), result.get(i).getRow());
            assertEquals(expResult.get(i).getColumn(), result.get(i).getColumn());
        }
    }
    
}
