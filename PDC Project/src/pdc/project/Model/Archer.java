package pdc.project.Model;

import java.util.HashMap;

/**
 * 
 */
public class Archer extends Player {
package pdc.project.Model;

import java.util.HashMap;

/**
 * 
 */
public class Archer extends Player {

    public boolean extraAttack = false; //will be used to determine if extra attack is granted.
        public Archer(String name, int health, int exp, Item[] inventory,
            int score, HashMap equipped, double hitChance, double critChance, 
            double dodgeChance) {
            
        super(name,health,exp,inventory,score,equipped,hitChance,critChance,dodgeChance);
        critChance = 20;
        extraAttack = true;
        health = 80;
    } 
    public String findClass() {
        return "Archer";
    }
=======
    //Extra attack at beginning of combat
    //Higher crit damage
    //Low health
    
    
    public Archer(String name, int health, int exp, Item[] inventory,
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
    return ("Archer");
    }
}