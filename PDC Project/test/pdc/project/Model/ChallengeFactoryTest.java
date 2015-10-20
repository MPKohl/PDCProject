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
public class ChallengeFactoryTest {
    
    public ChallengeFactoryTest() {
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
     * Test of getRandomChallenge method, of class ChallengeFactory.
     */
    @Test
    public void testGetRandomChallenge() {
        System.out.println("getRandomChallenge");
        ChallengeFactory instance = new ChallengeFactory();
        Challenge result = instance.getRandomChallenge();
        Assert.assertTrue(instance.getDoneChallenges().contains(result));
    }

    
}
