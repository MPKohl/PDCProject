package pdc.project.Model;

import java.util.HashMap;


public class Archer extends Player {
        public Archer(int damage,String name, int health, int exp, Item[] inventory,
            int score, HashMap equipped, double hitChance, double critChance, 
            double dodgeChance) {
        super(damage,name,health,exp,inventory,score,equipped,hitChance,critChance,dodgeChance);
        critChance = 10;
        damage = 15;
        hitChance = 75;
        dodgeChance = 28;
        health = 100;
    } 
    public String findClass() {
        return "Archer";
    }
}