package pdc.project.Model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Subclass of Player, defines the type of class as Archer.
 */
public class Archer extends Player {
        public Archer(int damage, String name, int health, int exp, ArrayList inventory,
            double score, HashMap equipped, double hitChance, double critChance, 
            double dodgeChance, boolean defensive, boolean dot) {
        super(damage,name,health,exp,inventory,score,equipped,hitChance,critChance,dodgeChance, defensive, dot);
    } 
        
    @Override
    public PlayerClass findClass() {
        return PlayerClass.ARCHER;
    }
}
