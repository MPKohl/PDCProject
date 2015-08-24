package pdc.project.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Super class for the player.
 */
public abstract class Player {
    private String name = "";
    private int health;
    private int exp;
    private ArrayList<Item> inventory = new ArrayList<>();
    private int score;
    private HashMap<ItemSlot, Item> equipped = new HashMap<>();
    private double hitChance;
    private double critChance;
    private double dodgeChance;
    private int lvl;
    //Construcotrs.
    public Player() {}
    public Player(String name, int health, int exp, ArrayList<Item> inventory,
            int score, HashMap<ItemSlot, Item> equipped, double hitChance, double critChance, 
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
    
    //Methods
    public abstract String findClass();   //illegal to call getClass.
    
    public void showInventory(){
        int i = 1;
        if (inventory.size() == 0){
            System.out.println("Inventory is empty.");
        }
        try {
            for (Item item : inventory) {
                System.out.println(i + ". " + item.getName());
                i++;
            }
        } catch (NullPointerException e) {
            System.out.println("No items in inventory");
        }
    }
    
    public void showEquippedItems(){
        int i = 1;
        if (equipped.size() == 0){
            System.out.println("No items equipped.");
        }
        try {
            for (Item item : equipped.values()) {
                System.out.println(i + ". " + item.getName());
                i++;
            }
        } catch (NullPointerException e) {
            System.out.println("No items equipped");
        }
    }
    
    private void equipItem(int invSlot){
        Item itemToEquip = inventory.get(invSlot-1);
        ItemType itemToEquipType = itemToEquip.getItemType();
        inventory.remove(invSlot-1);
        
        //If an item is already equipped in that slot, remove it and put it in inventory
        if (equipped.containsKey(itemToEquipType)){
            inventory.add(equipped.get(itemToEquipType));
            equipped.remove(itemToEquipType);
        }
        
        equipped.put(itemToEquip.getItemSlot(), itemToEquip);
    }
    
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
    public int getLvl() {
        return lvl;
    }
    public void setLvl(int lvl){
        this.lvl = lvl;
    }
    
    public void isLvlUp(){
         if (this.exp == 100){
             this.lvl = lvl + 1;
             exp = 0;
         }
    }
    /*
    public void EnemyReward(){
        Random r = new Random();
        exp += 15;
        score += 20;
        int firstRoll = r.nextInt(8);
        switch (firstRoll)
            case 0: 
                Armour armour = new Armour();
                
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
        inventory.add();
        
        //add item to inventory
    }*/
    public void challengeReward() {
        health = 100;
        exp +=  15;
        score += 20;
    }
    
    public void getCurrentStats(){
        System.out.println("Health: " + this.getHealth() + " Level: " + this.getLvl() +  " exp: " + this.getExp() + " Score: " + this.getScore());
    }
 
}
