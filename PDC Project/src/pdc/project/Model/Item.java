package pdc.project.Model;

import java.util.Random;

/**
 * Super class for all items.
 */
public abstract class Item {
    private String name;
    private int pointValue;
    private ItemType itemType;
    private ItemSlot itemSlot;
    
    private int random(int a){
        Random random = new Random();
        return random.nextInt(a);
    }
    
    /**
     * Generates a random prefix for a one handed weapon. 
     * Can be: Short sword, Axe, Mace, Long sword and Club.
     * @return String Prefix for one handed weapons.
     */
    private String randomOneHandedWeaponPrefix(){
        int randomNumber = random(5);
        String prefix = "";
        switch (randomNumber){
            case 0: prefix = "Short sword"; break;
            case 1: prefix = "Axe"; break;
            case 2: prefix = "Mace"; break;
            case 3: prefix = "Long sword"; break;
            case 4: prefix = "Club"; break;
        }
        return prefix;
    }
    
    /**
     * Generates a random prefix for a two handed weapon. 
     * Can be: Two handed sword, Two handed axe, Maul, Halberd and Spear.
     * @return String Prefix for two handed weapons.
     */
    private String randomTwoHandedWeaponPrefix(){
        int randomNumber = random(5);
        String prefix = "";
        switch (randomNumber){
            case 0: prefix = "Two handed sword"; break;
            case 1: prefix = "Two handed axe"; break;
            case 2: prefix = "Maul"; break;
            case 3: prefix = "Halberd"; break;
            case 4: prefix = "Spear"; break;
        }
        return prefix;
    }
    
    /**
     * Generates a random prefix for a shield. 
     * Can be: Buckler, Shield and Tower.
     * @return String Prefix for shields.
     */
    private String randomShieldPrefix(){
        int randomNumber = random(3);
        String prefix = "";
        switch (randomNumber){
            case 0: prefix = "Buckler"; break;
            case 1: prefix = "Shield"; break;
            case 2: prefix = "Tower"; break;
        }
        return prefix;
    }
    
    /**
     * Generates a random prefix for a bow. 
     * Can be: Longbow, Shortbow and Crossbow.
     * @return String Prefix for bows.
     */
    private String randomBowPrefix(){
        int randomNumber = random(3);
        String prefix = "";
        switch (randomNumber){
            case 0: prefix = "Longbow"; break;
            case 1: prefix = "Shortbow"; break;
            case 2: prefix = "Crossbow"; break;
        }
        return prefix;
    }
    
    /**
     * Gives the weapon a randomly generated name based on item type.
     */
    public void giveRandomName(){
        String[] suffixes = new String[8];
        suffixes[0] = "of the Fallen";
        suffixes[1] = "of Dragonslaying";
        suffixes[2] = "of a Thousand Truths";
        suffixes[3] = "of Mister Pickles";
        suffixes[4] = "of Great Scott";
        suffixes[5] = "of the Frozen Lake";
        suffixes[6] = "of Jellybeans";
        suffixes[7] = "of the Eternal";        
        
        String prefix;
        String suffix;
        
        switch (itemType){
            case PLATEARMOUR: prefix = "Plate armour"; break;
            case LEATHERARMOUR: prefix = "Leather armour"; break;
            case CLOTHARMOUR: prefix = "Robe"; break;
            case ONEHANDEDWEAPON: prefix = randomOneHandedWeaponPrefix(); break;
            case TWOHANDEDWEAPON: prefix = randomTwoHandedWeaponPrefix(); break;
            case SHIELD: prefix = randomShieldPrefix(); break;
            case STAFF: prefix = "Staff"; break;
            case BOW: prefix = randomBowPrefix(); break;
            default: prefix = "UNKOWN ITEM"; break;
        }
        
        suffix = suffixes[random(8)];
        
        name = prefix + " " + suffix;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the pointValue
     */
    public int getPointValue() {
        return pointValue;
    }

    /**
     * @param pointValue the pointValue to set
     */
    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    /**
     * @return the itemType
     */
    public ItemType getItemType() {
        return itemType;
    }

    /**
     * @param itemType the itemType to set
     */
    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    /**
     * @return the itemSlot
     */
    public ItemSlot getItemSlot() {
        return itemSlot;
    }

    /**
     * @param itemSlot the itemSlot to set
     */
    public void setItemSlot(ItemSlot itemSlot) {
        this.itemSlot = itemSlot;
    }
    
}
