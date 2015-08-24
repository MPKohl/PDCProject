package pdc.project.Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Warrior extends Player {
    public Warrior(int damage, String name, int health, int exp, ArrayList inventory,
            int score, HashMap equipped, double hitChance, double critChance, 
            double dodgeChance) {
            
        super(damage,name,health,exp,inventory,score,equipped,hitChance,critChance,dodgeChance);
        health = 100;
        damage = 20;
        exp = 0;
        hitChance = 90;
        critChance = 20;
        dodgeChance = 10;    
    }
    
    @Override
    public String findClass() {
        return "Warrior";
    }
}
