/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.GaltonCircle;
import model.GaltonPathGenerator;
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
    
}
