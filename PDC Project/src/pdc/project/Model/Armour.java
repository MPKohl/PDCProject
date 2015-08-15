package pdc.project.Model;

/**
 * All types of armour. Can only be worn in on body. Extends Item.
 */
public class Armour extends Item{
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
