package pdc.project.Model;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Tests the Item class.
 */
public class ItemTest {
    
    public ItemTest() {
    }

    /**
     * Test of constructor and thereby giveRandomName method, of class Item.
     */
    @Test
    public void testConstructor() {
        Item instance = new Item(ItemType.CLOTHARMOUR);
        Assert.assertTrue("Instance of CLOTHARMOUR should contain the word 'Robe'.", instance.getName().contains("Robe"));
        Assert.assertEquals("Wrong item slot for CLOTHARMOUR.", instance.getItemSlot(), ItemSlot.CHEST);
        Assert.assertTrue("Damage reduction of CLOTHARMOUR should be between 1 and 10", instance.getDmgReduction() >= 1 &&  instance.getDmgReduction() <= 10);
        
        instance = new Item(ItemType.PLATEARMOUR);
        Assert.assertTrue("Instance of PLATEARMOUR should contain the words 'Plate armour'.", instance.getName().contains("Plate armour"));
        Assert.assertEquals("Wrong item slot for PLATEARMOUR.", instance.getItemSlot(), ItemSlot.CHEST);
        Assert.assertTrue("Damage reduction of PLATEARMOUR should be between 20 and 30", instance.getDmgReduction() >= 20 &&  instance.getDmgReduction() <= 30);
        
        instance = new Item(ItemType.BOW);
        Assert.assertTrue("Instance of BOW should contain the word 'bow'.", instance.getName().contains("bow"));
        Assert.assertEquals("Wrong item slot for BOW.", instance.getItemSlot(), ItemSlot.MAINHAND);
        Assert.assertTrue("Damage increase of BOW should be between 4 and 15", instance.getDmg() >= 4 &&  instance.getDmg() <= 15);
    }
}
