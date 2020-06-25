/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author luism
 */
public class PascalPatternDBTest {

    /**
     * Test of getPatternInfo method, of class PascalPatternDB.
     */
    @Test
    public void testGetPatternInfo() {
        System.out.println("getPatternInfo");

        PascalPatternDB instance = new PascalPatternDB();

        assertEquals("The first diagonal contains exclusively the number one", instance.getPatternInfo("first"));
        assertEquals("Summing the rows gives the powers of two", instance.getPatternInfo("powers"));
        assertEquals("", instance.getPatternInfo("aaaa"));

    }
    
}
