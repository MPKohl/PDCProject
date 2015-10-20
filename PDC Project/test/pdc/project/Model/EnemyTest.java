package pdc.project.Model;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Enemy class.
 */
public class EnemyTest {
    Enemy instance;
    
    public EnemyTest() {
    }
    
    @Before
    public void setUp() {
        instance = new Enemy();
    }

    /**
     * Test of chooseStats method, of class Enemy.
     */
    @Test
    public void testChooseStats() {
        System.out.println("chooseStats");
        instance.chooseStats("easy");
        Assert.assertTrue("Damage not in concordance with an easy Enemy.", instance.getDamageHigh() >= 1 && instance.getDamageHigh() <= 15);
        Assert.assertTrue("Chance to hit is not 70%.", instance.getChanceToHit() == 70);
        Assert.assertTrue("Chance to dodge is not 10%.", instance.getChanceToDodge() == 10);
        Assert.assertTrue("Chance to crit is not 10%.", instance.getChanceToCrit() == 10);
        Assert.assertTrue("Health is not 100.", instance.getEnemyHealth() == 100);
        
        instance.chooseStats("medium");
        Assert.assertTrue("Damage not in concordance with a medium Enemy.", instance.getDamageHigh() >= 1 && instance.getDamageHigh() <= 20);
        
        instance.chooseStats("hard");
        Assert.assertTrue("Damage not in concordance with a hard Enemy.", instance.getDamageHigh() >= 1 && instance.getDamageHigh() <= 25);
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
        Assert.assertTrue("Damage not in concordance with a hard Enemy.", instance.getDamageHigh() >= 1 && instance.getDamageHigh() <= 25);
       
        instance.chooseDifficulty(4, gameBoardSize); // medium
        instance.chooseStats(instance.getDifficulty());
        Assert.assertTrue("Damage not in concordance with a medium Enemy.", instance.getDamageHigh() >= 1 && instance.getDamageHigh() <= 20);
        
        instance.chooseDifficulty(9, gameBoardSize); // easy
        instance.chooseStats(instance.getDifficulty());
        Assert.assertTrue("Damage not in concordance with an easy Enemy.", instance.getDamageHigh() >= 1 && instance.getDamageHigh() <= 15);
    }

    /**
     * Test of randomizeName method, of class Enemy.
     */
    @Test
    public void testRandomizeName() {
        System.out.println("randomizeName");
        instance.randomizeName();
        Assert.assertNotNull("Name not instantiated.", instance.getEnemyName());
    }

}
