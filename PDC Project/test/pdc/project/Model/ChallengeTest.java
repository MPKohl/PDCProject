/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdc.project.Model;

import java.util.ArrayList;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Brendon
 */
public class ChallengeTest {
    
    public ChallengeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getChallenge method, of class Challenge.
     */
    @Test
    public void testGetChallenge() {
        System.out.println("getChallenge");
        ChallengeFactory factory = new ChallengeFactory();
        Challenge instance = factory.getRandomChallenge();
        TextOutput[] result = instance.getChallenge();
        Assert.assertNotNull(result);

    }
}
