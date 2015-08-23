package pdc.project.Model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 */
public class Wizard extends Player {
    public String[] spells;    //Actually probably need a 'spell' class.
    public Wizard(String name, int health, int exp, ArrayList<Item> inventory,
            int score, HashMap equipped, double hitChance, double critChance, 
            double dodgeChance) {
            
        super(name,health,exp,inventory,score,equipped,hitChance,critChance,dodgeChance);
        health = 80;
        setSpells(); // to be changed later.
    }
    public String findClass() {
        return "Wizard";
    }
    public void setSpells() {
        String spellList[] = {"Fireball", "Ignite", "Shroud"};
        spells = spellList;
    }

}
