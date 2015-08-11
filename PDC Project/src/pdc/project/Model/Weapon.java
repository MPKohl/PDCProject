/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdc.project.Model;

/**
 *
 * @author MPKohl
 */
public class Weapon extends Item {
    private int dmgLow;
    private int dmgHigh;
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
}
