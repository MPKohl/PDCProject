package pdc.project.Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Warrior extends Player {
    public Warrior(int damage, String name, int health, int exp, ArrayList inventory,
            double score, HashMap equipped, double hitChance, double critChance, 
            double dodgeChance, boolean defensive, boolean dot) {
            
        super(damage,name,health,exp,inventory,score,equipped,hitChance,critChance,dodgeChance,defensive,dot);   
    }
    
    @Override
    public PlayerClass findClass() {
        return PlayerClass.WARRIOR;
    }
}
