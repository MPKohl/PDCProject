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
