/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdc.project.Model;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Brendon
 */
public class EnemyTest {
    Enemy instance;
    
    public EnemyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Enemy();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of chooseStats method, of class Enemy.
     */
    @Test
    public void testChooseStats() {
        System.out.println("chooseStats");
        instance.chooseStats("easy");
        Assert.assertTrue(instance.getDamageHigh() > 1 && instance.getDamageHigh() < 16);
        Assert.assertTrue(instance.getChanceToHit() == 70);
        Assert.assertTrue(instance.getChanceToDodge() == 10);
        Assert.assertTrue(instance.getChanceToCrit() == 10);
        Assert.assertTrue(instance.getExpYield() == 35);
        Assert.assertTrue(instance.getEnemyHealth() == 100);
        
        instance.chooseStats("medium");
        Assert.assertTrue(instance.getDamageHigh() > 1 && instance.getDamageHigh() < 21);
        
        instance.chooseStats("hard");
        Assert.assertTrue(instance.getDamageHigh() > 1 && instance.getDamageHigh() < 26);
    }

    /**
     * Test of chooseDifficulty method, of class Enemy.
     */
    @Test
    public void testChooseDifficulty() {
        System.out.println("chooseDifficulty");
        int gameBoardSize = 12;
        
        instance.chooseDifficulty(1, gameBoardSize); // hard
        instance.chooseStats(instance.getDifficulty());
        Assert.assertTrue(instance.getDamageHigh() > 1 && instance.getDamageHigh() < 26);
       
        instance.chooseDifficulty(4, gameBoardSize); // medium
        instance.chooseStats(instance.getDifficulty());
        Assert.assertTrue(instance.getDamageHigh() > 1 && instance.getDamageHigh() < 21);
        
        instance.chooseDifficulty(9, gameBoardSize); // easy
        instance.chooseStats(instance.getDifficulty());
        Assert.assertTrue(instance.getDamageHigh() > 1 && instance.getDamageHigh() < 16);
    }

    /**
     * Test of randomizeName method, of class Enemy.
     */
    @Test
    public void testRandomizeName() {
        System.out.println("randomizeName");
        instance.randomizeName();
        Assert.assertNotNull(instance.getEnemyName());
    }

}
