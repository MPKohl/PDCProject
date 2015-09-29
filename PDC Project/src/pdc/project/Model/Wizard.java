package pdc.project.Model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 */
public class Wizard extends Player {
    public String[] spells;    //Actually probably need a 'spell' class.
    private boolean ironSkin;
    private boolean poison;
    public Wizard(int damage, String name, int health, int exp, ArrayList inventory,
            int score, HashMap equipped, double hitChance, double critChance, 
            double dodgeChance) {
        super(damage,name,health,exp,inventory,score,equipped,hitChance,critChance,dodgeChance);
        health = 100;
        damage = 30;
        dodgeChance = 5;
        critChance = 20;
        hitChance = 90;
        poison = false;
        ironSkin = false;
        setSpells(); 
    }
    public boolean getIronSkin(){
        return ironSkin;
    }
    public void setIronSkin(boolean ironSkin){
        this.ironSkin=ironSkin;
    }
    public boolean getPoison(){
        return poison;
    }
    public void setPoison(boolean poison){
        this.poison=poison;
    }
    @Override
    public String findClass() {
        return "Wizard";
    }
    public void setSpells() {
        String spellList[] = {"Fireball" ,"Iron Skin", "Poison Seeds"};
        spells = spellList;
    }
}
