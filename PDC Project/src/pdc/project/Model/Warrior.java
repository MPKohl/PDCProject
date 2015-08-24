package pdc.project.Model;

import java.util.HashMap;

public class Warrior extends Player {
    public Warrior(int damage, String name, int health, int exp, Item[] inventory,
            int score, HashMap equipped, double hitChance, double critChance, 
            double dodgeChance) {
            
        super(damage,name,health,exp,inventory,score,equipped,hitChance,critChance,dodgeChance);
        health = 100;
        damage = 20;
        exp = 0;
        hitChance = 90;
        critChance = 17;
        dodgeChance = 10;    
    }
    
    public String findClass() {
        return "Warrior";
    }
}