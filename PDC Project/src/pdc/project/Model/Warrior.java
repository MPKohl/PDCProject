package pdc.project.Model;

import java.util.HashMap;

/**
 * 
 */
public class Warrior extends Player {
    public Warrior(String name, int health, int exp, Item[] inventory,
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
    return ("Warrior");
    }
    //High health
    //One guaranteed crit
}
