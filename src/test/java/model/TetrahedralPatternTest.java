/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class TetrahedralPatternTest {


    /**
     * Test of getPattern method, of class TetrahedralPattern.
     */
    @Test
    public void testGetPattern() {
        System.out.println("getPattern");
        
        int[][] pascalTriangle = {{1}, 
                                {1, 1}, 
                              {1, 2, 1}, 
                            {1, 3, 3, 1}, 
                          {1, 4, 6, 4, 1},
                       {1, 5, 10, 10, 5, 1}};
        
        
        ArrayList<Position>  expResult = new ArrayList<>();
        expResult.add(new Position(3, 3));
        expResult.add(new Position(4, 3));
        expResult.add(new Position(5, 3));

        PascalPattern instance = new TetrahedralPattern();
        ArrayList<Position> result = instance.getPattern(pascalTriangle).get(0).getPositions();
        
        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i).getRow(), result.get(i).getRow());
            assertEquals(expResult.get(i).getColumn(), result.get(i).getColumn());
        }
    }
    
}
