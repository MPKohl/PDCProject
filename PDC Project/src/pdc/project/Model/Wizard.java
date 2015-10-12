package pdc.project.Model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 */
public class Wizard extends Player {
    public Wizard(int damage, String name, int health, int exp, ArrayList inventory,
            double score, HashMap equipped, double hitChance, double critChance, 
            double dodgeChance, boolean defensive, boolean dot) {
        super(damage,name,health,exp,inventory,score,equipped,hitChance,critChance,dodgeChance, defensive, dot);
    }

    @Override
    public String findClass() {
        return "Wizard";
    }
}
