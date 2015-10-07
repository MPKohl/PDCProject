package pdc.project.Model;

import java.util.ArrayList;
import java.util.HashMap;


public class Archer extends Player {
        public Archer(int damage,String name, int health, int exp, ArrayList inventory,
            int score, HashMap equipped, double hitChance, double critChance, 
            double dodgeChance, boolean defensive, boolean dot) {
        super(damage,name,health,exp,inventory,score,equipped,hitChance,critChance,dodgeChance, defensive, dot);
    } 
        
    @Override
    public String findClass() {
        return "Archer";
    }
}
