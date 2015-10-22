package pdc.project.Model;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests Warrior, Archer and Wizard. 
 * These are all the subclasses of the abstract class Player.
 */
public class PlayerTest {
    
    Warrior warrior;
    Archer archer;
    Wizard wizard;
    
    public PlayerTest() {
    }
    
    /**
     * Instantiates a new Warrior, Archer and Wizard before each test.
     */
    @Before
    public void setUp() {
        warrior = new Warrior(30, "test", 100, 0, new ArrayList<Item>(), 0.0, new HashMap<ItemSlot, Item>(), 90.0, 20.0, 5.0, false, false);
        archer = new Archer(20, "test", 100, 0, new ArrayList<Item>(), 0.0, new HashMap<ItemSlot, Item>(), 80.0, 10.0, 30.0, false, false);
        wizard = new Wizard(30, "test", 100, 0, new ArrayList<Item>(), 0.0, new HashMap<ItemSlot, Item>(), 90.0, 20.0, 5.0, false, false);
    }

    /**
     * Test of findClass method, of class Player.
     */
    @Test
    public void testFindClass() {
        PlayerClass expResult = PlayerClass.WARRIOR;
        PlayerClass result = warrior.findClass();
        assertEquals(expResult, result);
        
        
        expResult = PlayerClass.ARCHER;
        result = archer.findClass();
        assertEquals(expResult, result);
        
        
        expResult = PlayerClass.WIZARD;
        result = wizard.findClass();
        assertEquals(expResult, result);
    }

    /**
     * Test of equipItem method, of class Player.
     */
    @Test
    public void testEquipItem() {
        //Tests for Wizard
        wizard.getInventory().add(new Item(ItemType.CLOTHARMOUR));
        wizard.getInventory().add(new Item(ItemType.LEATHERARMOUR));
        
        //Attempt to equip the cloth armour. Should be possible.
        wizard.equipItem(1, true);
        
        Assert.assertTrue("Equipped armour is not a CLOTHARMOUR.", wizard.getEquipped().get(ItemSlot.CHEST).getItemType() == ItemType.CLOTHARMOUR);
        
        //Attempt to equip the leather armour. Should not be possible.
        wizard.equipItem(1, true);
        
        Assert.assertFalse("The LEATHERARMOUR was equipped.", wizard.getEquipped().get(ItemSlot.CHEST).getItemType() == ItemType.LEATHERARMOUR);
        
        
        //Tests for Archer
        archer.getInventory().add(new Item(ItemType.LEATHERARMOUR));
        archer.getInventory().add(new Item(ItemType.BOW));
        archer.getInventory().add(new Item(ItemType.PLATEARMOUR));
        archer.getInventory().add(new Item(ItemType.CLOTHARMOUR));
        
        //Attempt to equip the leather armour and bow. Should be possible.
        archer.equipItem(1, true);
        archer.equipItem(1, true);
        
        Assert.assertTrue("Equipped armour is not a LEATHERARMOUR.", archer.getEquipped().get(ItemSlot.CHEST).getItemType() == ItemType.LEATHERARMOUR);
        Assert.assertTrue("Equipped weapon is not a BOW.", archer.getEquipped().get(ItemSlot.MAINHAND).getItemType() == ItemType.BOW);
               
        //Attempt to equip the plate armour. Should not be possible.
        archer.equipItem(1, true);
        
        Assert.assertFalse("The PLATEARMOUR was equipped.", archer.getEquipped().get(ItemSlot.CHEST).getItemType() == ItemType.PLATEARMOUR);
        
        //Attempt to equip the cloth armour. Should replace leather armour in equipment. Leather armour should be moved to inventory.
        archer.equipItem(2, true);
        
        Assert.assertTrue("Equipped armour is not a CLOTHARMOUR.", archer.getEquipped().get(ItemSlot.CHEST).getItemType() == ItemType.CLOTHARMOUR);
        Assert.assertTrue("Leather armour not moved to inventory.", archer.getInventory().get(1).getItemType() == ItemType.LEATHERARMOUR);
        
        
        //Tests for Warrior
        warrior.getInventory().add(new Item(ItemType.ONEHANDEDWEAPON));
        warrior.getInventory().add(new Item(ItemType.SHIELD));
        warrior.getInventory().add(new Item(ItemType.PLATEARMOUR));
        warrior.getInventory().add(new Item(ItemType.TWOHANDEDWEAPON));
        
        //Attempt to equip the one handed weapon, sheild and plate armour. Should be possible.
        warrior.equipItem(1, true);
        warrior.equipItem(1, true);
        warrior.equipItem(1, true);
        
        Assert.assertTrue("Equipped weapon not a ONEHANDEDWEAPON.", warrior.getEquipped().get(ItemSlot.MAINHAND).getItemType() == ItemType.ONEHANDEDWEAPON);
        Assert.assertTrue("No SHIELD equipped.", warrior.getEquipped().get(ItemSlot.OFFHAND).getItemType() == ItemType.SHIELD);
        Assert.assertTrue("Equipped armour not a PLATEARMOUR.", warrior.getEquipped().get(ItemSlot.CHEST).getItemType() == ItemType.PLATEARMOUR);
        
        //Attempt to equip the two handed weapon. Should replace shield and one handed weapon in equipment. Those two items should be moved to inventory.
        warrior.equipItem(1, true);
        
        Assert.assertTrue("Equipped weapon not a TWOHANDEDWEAPON.", warrior.getEquipped().get(ItemSlot.MAINHAND).getItemType() == ItemType.TWOHANDEDWEAPON);
        Assert.assertTrue("SHIELD not moved to inventory.", warrior.getInventory().get(0).getItemType() == ItemType.SHIELD);
        Assert.assertTrue("ONEHANDEDWEAPON not moved to inventory.", warrior.getInventory().get(1).getItemType() == ItemType.ONEHANDEDWEAPON);
    }



    /**
     * Test of giveExp method, of class Player.
     */
    @Test
    public void testGiveExp() {
        warrior.giveExp(99);
        
        Assert.assertEquals("Player is not level 1.", 1, warrior.getLvl());
        Assert.assertEquals("Player does not have 99 exp.", 99, warrior.getExp());
        
        warrior.giveExp(1);
        
        Assert.assertEquals("Player is not level 2.", 2, warrior.getLvl());
        Assert.assertEquals("Player does not have 0 exp after leveling up.", 0, warrior.getExp());
        
        warrior.giveExp(100);
        
        Assert.assertEquals("Player is not level 3.", 3, warrior.getLvl());
        Assert.assertEquals("Player does not have 0 exp after leveling up.", 0, warrior.getExp());
        
        warrior.giveExp(150);
        
        Assert.assertEquals("Player is not level 4.", 4, warrior.getLvl());
        Assert.assertEquals("Player does not have 50 exp after leveling up.", 50, warrior.getExp());
    }

    /**
     * Test of bossReward method, of class Player.
     */
    @Test
    public void testBossReward() {
        warrior.bossReward();
        
        Assert.assertEquals("Player's experience is not 50.", 50, warrior.getExp());
        
        Assert.assertEquals("Player's score is not 100.", 100, warrior.getScore(), 0);
    }

    /**
     * Test of enemyReward method, of class Player.
     */
    @Test
    public void testEnemyReward() {
        warrior.enemyReward();
        
        Assert.assertTrue("No item added to inventory.", warrior.getInventory().size() == 1);
        
        Assert.assertEquals("Player's experience is not 15.", 15, warrior.getExp());
        
        Assert.assertEquals("Player's score is not 20.", 20, warrior.getScore(), 0);
    }

    /**
     * Test of challengeReward method, of class Player.
     */
    @Test
    public void testChallengeReward() {
        warrior.setHealth(50);
        
        warrior.challengeReward();
        
        Assert.assertEquals("Player's health is not 100.", 100, warrior.getHealth());
        
        Assert.assertEquals("Player's experience is not 15.", 15, warrior.getExp());
        
        Assert.assertEquals("Player's score is not 20.", 20, warrior.getScore(), 0);
    }
    
}
