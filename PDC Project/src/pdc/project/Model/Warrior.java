package pdc.project.Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Warrior extends Player {
    public Warrior(int damage, String name, int health, int exp, ArrayList inventory,
            int score, HashMap equipped, double hitChance, double critChance, 
            double dodgeChance) {
            
        super(damage,name,health,exp,inventory,score,equipped,hitChance,critChance,dodgeChance);   
    }
    
    @Override
    public String findClass() {
        return "Warrior";
    }
}
