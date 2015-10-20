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
public class ItemTest {
    
    public ItemTest() {
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
     * Test of giveRandomName method, of class Item.
     */
    @Test
    public void testGiveRandomName() {
        System.out.println("giveRandomName");
        Item instance = new Item(ItemType.PLATEARMOUR);
        Assert.assertTrue(instance.getName().contains("Plate armour"));
        
        instance = new Item(ItemType.LEATHERARMOUR);
        Assert.assertTrue(instance.getName().contains("Leather armour"));

        instance = new Item(ItemType.CLOTHARMOUR);
        Assert.assertTrue(instance.getName().contains("Robe"));
        
    }

    
}
