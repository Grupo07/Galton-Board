/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.GaltonCircle;
import model.GaltonPathGenerator;
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
public class GaltonControllerTest {

    /**
     * Test of generateCircle method, of class GaltonController.
     */
    @Test
    public void testGenerateCircle() {
        System.out.println("generateCircle");
        
        GaltonCircle expResult = new GaltonCircle(GaltonPathGenerator.getPath(3, 0.5f));
        
        GaltonController instance = new GaltonController(3);
        GaltonCircle result = instance.generateCircle();
        
        assertEquals(expResult.getDrawable(), result.getDrawable());
    }

    /**
     * Test of updateRightProbability method, of class GaltonController.
     */
    @Test
    public void testUpdateRightProbability() {
        System.out.println("updateRightProbability");
        
        String[] expResult = {"right", "right", "right"};
        
        GaltonController instance = new GaltonController(3);
        float rightProbability = 1.0f;
        instance.updateRightProbability(rightProbability);
        String[] result = instance.generateCircle().getPath();
        
        assertArrayEquals(expResult, result);
    }
    
}
