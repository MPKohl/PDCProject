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
public class Warrior extends Player {
    private boolean freeCrit = false;
    public Warrior(String name, int health, int exp, Item[] inventory,
            int score, HashMap equipped, double hitChance, double critChance, 
            double dodgeChance) {
            
        super(name,health,exp,inventory,score,equipped,hitChance,critChance,dodgeChance);
        health = 100;
        freeCrit = true;    
    }
    public String findClass() {
        return "Warrior";
    }
      
    //High health
    //One guaranteed crit
}
