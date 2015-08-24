package pdc.project.Model;

import java.util.HashMap;

/**
 * 
 */
public class Wizard extends Player {
    public String[] spells;    //Actually probably need a 'spell' class.
    public Wizard(int damage, String name, int health, int exp, Item[] inventory,
            int score, HashMap equipped, double hitChance, double critChance, 
            double dodgeChance) {
        super(damage,name,health,exp,inventory,score,equipped,hitChance,critChance,dodgeChance);
        health = 100;
        damage = 0;
        dodgeChance = 5;
        critChance = 20;
        hitChance = 85;
        setSpells(); 
    }
    public String findClass() {
        return "Wizard";
    }
    public void setSpells() {
        String spellList[] = {"Fireball", "Ignite", "Shroud"};
        spells = spellList;
    }

}
