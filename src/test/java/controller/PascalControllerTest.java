/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.PascalRectangle;
import model.Position;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author luism
 */
public class PascalControllerTest {

    /**
     * Test of getPascalRectangles method, of class PascalController.
     */
    @Test
    public void testGetPascalRectangles() {
        System.out.println("getPascalRectangles");
        
        PascalController instance = new PascalController(4);
        
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
        
        ArrayList<PascalRectangle> result = instance.getPascalRectangles();
        
        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i).getBinomialCoefficient(), result.get(i).getBinomialCoefficient());
        }
    }

    /**
     * Test of getPascalPattern method, of class PascalController.
     */
    @Test
    public void testGetPascalPattern() {
        System.out.println("getPascalPattern");
        
        PascalController instance = new PascalController(4);
        
        ArrayList<Position>  expResult = new ArrayList<>();
        expResult.add(new Position(2, 2));
        expResult.add(new Position(3, 2));
        
        String pattern = "third";
        ArrayList<Position> result = instance.getPascalPattern(pattern).get(0).getPositions();
        
        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i).getRow(), result.get(i).getRow());
            assertEquals(expResult.get(i).getColumn(), result.get(i).getColumn());
        }
    }

    /**
     * Test of getPatternInfo method, of class PascalController.
     */
    @Test
    public void testGetPatternInfo() {
        System.out.println("getPatternInfo");
        
        PascalController instance = new PascalController(4);

        assertEquals("The first diagonal contains exclusively the number one", instance.getPatternInfo("first"));
        assertEquals("Summing the rows gives the powers of two", instance.getPatternInfo("powers"));
        assertEquals("", instance.getPatternInfo("aaaa"));
    }

    /**
     * Test of updateTriangleHeight method, of class PascalController.
     */
    @Test
    public void testUpdateTriangleHeight() {
        System.out.println("updateTriangleHeight");
        
        PascalController instance = new PascalController(3);
        
        int expResult = 5;
        instance.updateTriangleHeight(expResult);
        
        int result = instance.getPascalPattern("first").get(0).getPositions().size();
        
        assertEquals(expResult, result);
    }
    
}
