/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdc.project.Controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pdc.project.Model.Enemy;
import pdc.project.Model.Player;

/**
 *
 * @author MPKohl
 */
public class CombatTest {
    
    public CombatTest() {
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

//    /**
//     * Test of combatStart method, of class Combat.
//     */
//    @Test
//    public void testCombatStart() {
//        System.out.println("combatStart");
//        Enemy enemy = null;
//        Player player = null;
//        Combat.combatStart(enemy, player);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of selectClassCombat method, of class Combat.
//     */
//    @Test
//    public void testSelectClassCombat() {
//        System.out.println("selectClassCombat");
//        Enemy enemy = null;
//        Player player = null;
//        int defensiveCount = 0;
//        int dotCount = 0;
//        Combat.selectClassCombat(enemy, player, defensiveCount, dotCount);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of warriorAttackPhase method, of class Combat.
     */
    @Test
    public void testWarriorAttackPhase() {
        System.out.println("warriorAttackPhase");
        Enemy enemy = null;
        Player player = null;
        int defensiveCount = 0;
        int dotCount = 0;
        Combat.warriorAttackPhase(enemy, player, defensiveCount, dotCount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of archerAttackPhase method, of class Combat.
     */
    @Test
    public void testArcherAttackPhase() {
        System.out.println("archerAttackPhase");
        Enemy enemy = null;
        Player player = null;
        int defensiveCount = 0;
        int dotCount = 0;
        Combat.archerAttackPhase(enemy, player, defensiveCount, dotCount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of wizardAttackPhase method, of class Combat.
     */
    @Test
    public void testWizardAttackPhase() {
        System.out.println("wizardAttackPhase");
        Enemy enemy = null;
        Player player = null;
        int defensiveCount = 0;
        int dotCount = 0;
        Combat.wizardAttackPhase(enemy, player, defensiveCount, dotCount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of warriorCalcution method, of class Combat.
     */
    @Test
    public void testWarriorCalcution() {
        System.out.println("warriorCalcution");
        Enemy enemy = null;
        Player player = null;
        int defensiveCount = 0;
        int dotCount = 0;
        Combat.warriorCalcution(enemy, player, defensiveCount, dotCount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of archerCalculation method, of class Combat.
     */
    @Test
    public void testArcherCalculation() {
        System.out.println("archerCalculation");
        Enemy enemy = null;
        Player player = null;
        int defensiveCount = 0;
        int dotCount = 0;
        Combat.archerCalculation(enemy, player, defensiveCount, dotCount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of wizardCalculation method, of class Combat.
     */
    @Test
    public void testWizardCalculation() {
        System.out.println("wizardCalculation");
        Enemy enemy = null;
        Player player = null;
        int defensiveCount = 0;
        int dotCount = 0;
        Combat.wizardCalculation(enemy, player, defensiveCount, dotCount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dotUpdate method, of class Combat.
     */
    @Test
    public void testDotUpdate() {
        System.out.println("dotUpdate");
        Player player = null;
        int dotCount = 0;
        Combat.dotUpdate(player, dotCount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of defenseUpdate method, of class Combat.
     */
    @Test
    public void testDefenseUpdate() {
        System.out.println("defenseUpdate");
        Player player = null;
        int defenseCount = 0;
        Combat.defenseUpdate(player, defenseCount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bleedCalc method, of class Combat.
     */
    @Test
    public void testBleedCalc() {
        System.out.println("bleedCalc");
        Enemy enemy = null;
        int expResult = 0;
        int result = Combat.bleedCalc(enemy);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of soulLeechCalc method, of class Combat.
     */
    @Test
    public void testSoulLeechCalc() {
        System.out.println("soulLeechCalc");
        Enemy enemy = null;
        Player player = null;
        int expResult = 0;
        int result = Combat.soulLeechCalc(enemy, player);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of poisonShotCalc method, of class Combat.
     */
    @Test
    public void testPoisonShotCalc() {
        System.out.println("poisonShotCalc");
        Enemy enemy = null;
        Player player = null;
        int expResult = 0;
        int result = Combat.poisonShotCalc(enemy, player);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enemyAttackPhase method, of class Combat.
     */
    @Test
    public void testEnemyAttackPhase() {
        System.out.println("enemyAttackPhase");
        Enemy enemy = null;
        Player player = null;
        int defensiveCount = 0;
        int dotCount = 0;
        Combat.enemyAttackPhase(enemy, player, defensiveCount, dotCount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playerDamageCalc method, of class Combat.
     */
    @Test
    public void testPlayerDamageCalc() {
        System.out.println("playerDamageCalc");
        Enemy enemy = null;
        Player player = null;
        Combat.playerDamageCalc(enemy, player);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enemyDamageCalc method, of class Combat.
     */
    @Test
    public void testEnemyDamageCalc() {
        System.out.println("enemyDamageCalc");
        Enemy enemy = null;
        Player player = null;
        Combat.enemyDamageCalc(enemy, player);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enemyHealthReduction method, of class Combat.
     */
    @Test
    public void testEnemyHealthReduction() {
        System.out.println("enemyHealthReduction");
        Enemy enemy = null;
        int totalDamage = 0;
        Enemy expResult = null;
        Enemy result = Combat.enemyHealthReduction(enemy, totalDamage);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playerHealthReduction method, of class Combat.
     */
    @Test
    public void testPlayerHealthReduction() {
        System.out.println("playerHealthReduction");
        Player player = null;
        int totalDamage = 0;
        Player expResult = null;
        Player result = Combat.playerHealthReduction(player, totalDamage);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playerDodgeCalc method, of class Combat.
     */
    @Test
    public void testPlayerDodgeCalc() {
        System.out.println("playerDodgeCalc");
        Player player = null;
        boolean expResult = false;
        boolean result = Combat.playerDodgeCalc(player);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playerCritCalc method, of class Combat.
     */
    @Test
    public void testPlayerCritCalc() {
        System.out.println("playerCritCalc");
        Player player = null;
        boolean expResult = false;
        boolean result = Combat.playerCritCalc(player);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playerHitCalc method, of class Combat.
     */
    @Test
    public void testPlayerHitCalc() {
        System.out.println("playerHitCalc");
        Player player = null;
        boolean expResult = false;
        boolean result = Combat.playerHitCalc(player);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enemyDodgeCalc method, of class Combat.
     */
    @Test
    public void testEnemyDodgeCalc() {
        System.out.println("enemyDodgeCalc");
        Enemy enemy = null;
        boolean expResult = false;
        boolean result = Combat.enemyDodgeCalc(enemy);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enemyCritCalc method, of class Combat.
     */
    @Test
    public void testEnemyCritCalc() {
        System.out.println("enemyCritCalc");
        Enemy enemy = null;
        boolean expResult = false;
        boolean result = Combat.enemyCritCalc(enemy);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enemyHitCalc method, of class Combat.
     */
    @Test
    public void testEnemyHitCalc() {
        System.out.println("enemyHitCalc");
        Enemy enemy = null;
        boolean expResult = false;
        boolean result = Combat.enemyHitCalc(enemy);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of quit method, of class Combat.
     */
    @Test
    public void testQuit() {
        System.out.println("quit");
        Combat.quit();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
