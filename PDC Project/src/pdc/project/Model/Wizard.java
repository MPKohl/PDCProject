/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdc.project.Model;

import java.util.HashMap;

/**
 *
 * @author MPKohl
 */
public class Wizard extends Player {
    public Wizard(String name, int health, int exp, Item[] inventory,
            int score, HashMap equipped, double hitChance, double critChance, 
            double dodgeChance){
        super(name,health,exp,inventory,
            score,equipped,hitChance,critChance, 
            dodgeChance);
        
    }
        /**
     *
     * @return the class
     */
    @Override
    public String findClass(){
    return ("Wizard");
    }
    //Spell list
    //Three chosen spells
    //Reduced health
}
