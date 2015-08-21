package pdc.project.Model;

import java.util.HashMap;

/**
 * Super class for the player.
 */
public abstract class Player {
    private String name = "";
    private int health;
    private int exp;
    private Item[] inventory;
    private int score;
    private HashMap<ItemSlot, Item> equipped = new HashMap<ItemSlot, Item>();
    private double hitChance;
    private double critChance;
    private double dodgeChance;
    private int lvl;
    //Construcotrs.
    public Player() {}
    public Player(String name, int health, int exp, Item[] inventory,
            int score, HashMap equipped, double hitChance, double critChance, 
            double dodgeChance) {
        this.name = name;
        this.health = health;
        this.exp = exp;
        this.inventory = inventory;
        this.score = score;
        this.equipped = equipped;
        this.hitChance = hitChance;
        this.critChance = critChance;
        this.dodgeChance = dodgeChance;     
    }        
    
    //Methods.
    public abstract String findClass();   //illegal to call getClass.
    //getters and setters
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getExp() {
        return exp;
    }
    public Item[] inventory() {
        return inventory;  //will change to properally return.
    }
    public int getScore() {
        return score;
    }
    public HashMap getEquipped() {
        return equipped;
    }
    public double getHitChance() {
        return hitChance;
    }
    public double getCritChance() {
        return critChance;
    }
    public double getDodgeChance() {
        return dodgeChance;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }
    public void setInventory(Item[] inventory) {
        this.inventory = inventory;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setEquipped(HashMap equipped) {
        this.equipped = equipped;
    }
    public void setCritChance(double critChance) {
        this.critChance = critChance;
    }
    public void setHitChance(double hitChance) {
        this.hitChance = hitChance;
    }
    public void setDodgeChance(double dodgeChance) {
        this.dodgeChance = dodgeChance;
    }
    
    
    public void isLvlUp(){
         if (this.exp == 100){
             this.lvl = lvl + 1;
         }
    }
 
}
