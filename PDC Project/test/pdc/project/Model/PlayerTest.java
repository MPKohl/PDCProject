/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdc.project.Model;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MPKohl
 */
public class PlayerTest {
    
    public PlayerTest() {
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
     * Test of findClass method, of class Player.
     */
    @Test
    public void testFindClass() {
        System.out.println("findClass");
        Player instance = new PlayerImpl();
        PlayerClass expResult = null;
        PlayerClass result = instance.findClass();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equipItem method, of class Player.
     */
    @Test
    public void testEquipItem() {
        System.out.println("equipItem");
        int invSlot = 0;
        boolean gameIsCUIVersion = false;
        Player instance = new PlayerImpl();
        instance.equipItem(invSlot, gameIsCUIVersion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isLvlUp method, of class Player.
     */
    @Test
    public void testIsLvlUp() {
        System.out.println("isLvlUp");
        Player instance = new PlayerImpl();
        instance.isLvlUp();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of giveExp method, of class Player.
     */
    @Test
    public void testGiveExp() {
        System.out.println("giveExp");
        int exp = 0;
        Player instance = new PlayerImpl();
        instance.giveExp(exp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bossReward method, of class Player.
     */
    @Test
    public void testBossReward() {
        System.out.println("bossReward");
        Player instance = new PlayerImpl();
        instance.bossReward();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of timerReward method, of class Player.
     */
    @Test
    public void testTimerReward() {
        System.out.println("timerReward");
        int[] startTime = null;
        Player instance = new PlayerImpl();
        instance.timerReward(startTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enemyReward method, of class Player.
     */
    @Test
    public void testEnemyReward() {
        System.out.println("enemyReward");
        Player instance = new PlayerImpl();
        Item expResult = null;
        Item result = instance.enemyReward();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of challengeReward method, of class Player.
     */
    @Test
    public void testChallengeReward() {
        System.out.println("challengeReward");
        Player instance = new PlayerImpl();
        instance.challengeReward();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDamage method, of class Player.
     */
    @Test
    public void testGetDamage() {
        System.out.println("getDamage");
        Player instance = new PlayerImpl();
        int expResult = 0;
        int result = instance.getDamage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDamage method, of class Player.
     */
    @Test
    public void testSetDamage() {
        System.out.println("setDamage");
        int damage = 0;
        Player instance = new PlayerImpl();
        instance.setDamage(damage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInventory method, of class Player.
     */
    @Test
    public void testGetInventory() {
        System.out.println("getInventory");
        Player instance = new PlayerImpl();
        ArrayList<Item> expResult = null;
        ArrayList<Item> result = instance.getInventory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInventory method, of class Player.
     */
    @Test
    public void testSetInventory() {
        System.out.println("setInventory");
        ArrayList<Item> inventory = null;
        Player instance = new PlayerImpl();
        instance.setInventory(inventory);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDefensive method, of class Player.
     */
    @Test
    public void testGetDefensive() {
        System.out.println("getDefensive");
        Player instance = new PlayerImpl();
        boolean expResult = false;
        boolean result = instance.getDefensive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDefensive method, of class Player.
     */
    @Test
    public void testSetDefensive() {
        System.out.println("setDefensive");
        boolean defensive = false;
        Player instance = new PlayerImpl();
        instance.setDefensive(defensive);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDot method, of class Player.
     */
    @Test
    public void testGetDot() {
        System.out.println("getDot");
        Player instance = new PlayerImpl();
        boolean expResult = false;
        boolean result = instance.getDot();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDot method, of class Player.
     */
    @Test
    public void testSetDot() {
        System.out.println("setDot");
        boolean dot = false;
        Player instance = new PlayerImpl();
        instance.setDot(dot);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Player.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Player instance = new PlayerImpl();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Player.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Player instance = new PlayerImpl();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHealth method, of class Player.
     */
    @Test
    public void testGetHealth() {
        System.out.println("getHealth");
        Player instance = new PlayerImpl();
        int expResult = 0;
        int result = instance.getHealth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHealth method, of class Player.
     */
    @Test
    public void testSetHealth() {
        System.out.println("setHealth");
        int health = 0;
        Player instance = new PlayerImpl();
        instance.setHealth(health);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExp method, of class Player.
     */
    @Test
    public void testGetExp() {
        System.out.println("getExp");
        Player instance = new PlayerImpl();
        int expResult = 0;
        int result = instance.getExp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExp method, of class Player.
     */
    @Test
    public void testSetExp() {
        System.out.println("setExp");
        int exp = 0;
        Player instance = new PlayerImpl();
        instance.setExp(exp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScore method, of class Player.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        Player instance = new PlayerImpl();
        double expResult = 0.0;
        double result = instance.getScore();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setScore method, of class Player.
     */
    @Test
    public void testSetScore() {
        System.out.println("setScore");
        double score = 0.0;
        Player instance = new PlayerImpl();
        instance.setScore(score);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEquipped method, of class Player.
     */
    @Test
    public void testGetEquipped() {
        System.out.println("getEquipped");
        Player instance = new PlayerImpl();
        HashMap<ItemSlot, Item> expResult = null;
        HashMap<ItemSlot, Item> result = instance.getEquipped();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEquipped method, of class Player.
     */
    @Test
    public void testSetEquipped() {
        System.out.println("setEquipped");
        HashMap<ItemSlot, Item> equipped = null;
        Player instance = new PlayerImpl();
        instance.setEquipped(equipped);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHitChance method, of class Player.
     */
    @Test
    public void testGetHitChance() {
        System.out.println("getHitChance");
        Player instance = new PlayerImpl();
        double expResult = 0.0;
        double result = instance.getHitChance();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHitChance method, of class Player.
     */
    @Test
    public void testSetHitChance() {
        System.out.println("setHitChance");
        double hitChance = 0.0;
        Player instance = new PlayerImpl();
        instance.setHitChance(hitChance);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCritChance method, of class Player.
     */
    @Test
    public void testGetCritChance() {
        System.out.println("getCritChance");
        Player instance = new PlayerImpl();
        double expResult = 0.0;
        double result = instance.getCritChance();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCritChance method, of class Player.
     */
    @Test
    public void testSetCritChance() {
        System.out.println("setCritChance");
        double critChance = 0.0;
        Player instance = new PlayerImpl();
        instance.setCritChance(critChance);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDodgeChance method, of class Player.
     */
    @Test
    public void testGetDodgeChance() {
        System.out.println("getDodgeChance");
        Player instance = new PlayerImpl();
        double expResult = 0.0;
        double result = instance.getDodgeChance();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDodgeChance method, of class Player.
     */
    @Test
    public void testSetDodgeChance() {
        System.out.println("setDodgeChance");
        double dodgeChance = 0.0;
        Player instance = new PlayerImpl();
        instance.setDodgeChance(dodgeChance);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLvl method, of class Player.
     */
    @Test
    public void testGetLvl() {
        System.out.println("getLvl");
        Player instance = new PlayerImpl();
        int expResult = 0;
        int result = instance.getLvl();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLvl method, of class Player.
     */
    @Test
    public void testSetLvl() {
        System.out.println("setLvl");
        int lvl = 0;
        Player instance = new PlayerImpl();
        instance.setLvl(lvl);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isDefensive method, of class Player.
     */
    @Test
    public void testIsDefensive() {
        System.out.println("isDefensive");
        Player instance = new PlayerImpl();
        boolean expResult = false;
        boolean result = instance.isDefensive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isDot method, of class Player.
     */
    @Test
    public void testIsDot() {
        System.out.println("isDot");
        Player instance = new PlayerImpl();
        boolean expResult = false;
        boolean result = instance.isDot();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class PlayerImpl extends Player {
    }
    
}
