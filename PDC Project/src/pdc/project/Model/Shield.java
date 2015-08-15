package pdc.project.Model;

/**
 * All shield. Can only be worn in off hand. Extends Item.
 */
public class Shield extends Item{
    private int dmgReduction;

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
