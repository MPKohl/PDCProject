package pdc.project.Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Warrior extends Player {
    private boolean freeCrit = false;
    public Warrior(String name, int health, int exp, ArrayList<Item> inventory,
            int score, HashMap equipped, double hitChance, double critChance, 
            double dodgeChance) {
            
        super(name,health,exp,inventory,score,equipped,hitChance,critChance,dodgeChance);
        health = 100;
        freeCrit = true;    
    }
    
    public String findClass() {
        return "Warrior";
    }
}