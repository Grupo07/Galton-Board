/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Consecutive Pattern unit tests
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
