package pdc.project.Model;

import java.util.Random;

/**
 * All types of armour. Can only be worn in on body. Extends Item.
 */
public class Armour extends Item{
    
    public Armour(ItemType type) {
        Random r = new Random();
        setItemType(type);
        switch (getItemType()){
            case CLOTHARMOUR: setDmgReduction(r.nextInt(10) + 1); break;
            case LEATHERARMOUR: setDmgReduction(r.nextInt(10) + 10); break;
            case PLATEARMOUR: setDmgReduction(r.nextInt(10) + 20); break;
        }
    }
    public Armour(){}
    
    private int dmgReduction;
    //Special attribute

    /**
     * @return the dmgReduction
     */
    public int getDmgReduction() {
        return dmgReduction;
    }

    /**
     * @param dmgReduction the dmgReduction to set
     */
    public void setDmgReduction(int dmgReduction) {
        this.dmgReduction = dmgReduction;
    }
    
    
}
