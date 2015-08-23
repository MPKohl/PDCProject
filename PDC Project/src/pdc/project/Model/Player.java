package pdc.project.Model;

import java.util.ArrayList;
import java.util.HashMap;

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
    //Construcotrs.
    public Player() {}
    public Player(String name, int health, int exp, ArrayList<Item> inventory,
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
    
    //Methods
    public abstract String findClass();   //illegal to call getClass.
    
    public void showInventory(){
        int i = 1;
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
 
}
