package pdc.project.Model;

/**
 * Class for all weapons. Extends Item.
 */
public class Weapon extends Item {
    private int dmgLow;
    private int dmgHigh;
    private boolean twoHanded;
    //Special attribute

    /**
     * @return the dmgLow
     */
    public int getDmgLow() {
        return dmgLow;
    }

    /**
     * @param dmgLow the dmgLow to set
     */
    public void setDmgLow(int dmgLow) {
        this.dmgLow = dmgLow;
    }

    /**
     * @return the dmgHigh
     */
    public int getDmgHigh() {
        return dmgHigh;
    }

    /**
     * @param dmgHigh the dmgHigh to set
     */
    public void setDmgHigh(int dmgHigh) {
        this.dmgHigh = dmgHigh;
    }

    /**
     * @return the twoHanded
     */
    public boolean isTwoHanded() {
        return twoHanded;
    }

    /**
     * @param twoHanded the twoHanded to set
     */
    public void setTwoHanded(boolean twoHanded) {
        this.twoHanded = twoHanded;
    }
}
