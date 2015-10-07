package pdc.project.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Super class for the player.
 */
public abstract class Player {
    private String name = "";
    private int damage;
    private int health;
    private int exp;
    private ArrayList<Item> inventory = new ArrayList<>();
    private int score;
    private HashMap<ItemSlot, Item> equipped = new HashMap<>();
    private double hitChance;
    private double critChance;
    private double dodgeChance;
    private int lvl;
    private boolean defensive;
    private boolean dot;
    //Construcotrs.
    public Player() {}
    
    public Player(int damage, String name, int health, int exp, ArrayList inventory,
            int score, HashMap equipped, double hitChance, double critChance, 
            double dodgeChance, boolean defensive, boolean dot) {
        this.damage = damage;
        this.name = name;
        this.health = health;
        this.exp = exp;
        this.inventory = inventory;
        this.score = score;
        this.equipped = equipped;
        this.hitChance = hitChance;
        this.critChance = critChance;
        this.dodgeChance = dodgeChance;  
        this.lvl = 1;
        defensive = false;
        dot = false;
        //inventory.add(new Item(ItemType.CLOTHARMOUR));
        //inventory.add(new Item(ItemType.LEATHERARMOUR));
        //inventory.add(new Item(ItemType.PLATEARMOUR));
        //inventory.add(new Item(ItemType.BOW));
        //inventory.add(new Item(ItemType.ONEHANDEDWEAPON));
        //inventory.add(new Item(ItemType.SHIELD));
        //inventory.add(new Item(ItemType.TWOHANDEDWEAPON));
    }        
    
    //Methods
    public String findClass(){
        return "No class";
    }

    
    public void showInventory(){
        int i = 1;
        if (getInventory().isEmpty()){
            System.out.println("Inventory is empty.");
        }
        try {
            for (Item item : getInventory()) {
                System.out.print(i + ". " + item.getName());
                if (item.getItemType() == ItemType.CLOTHARMOUR || item.getItemType() == ItemType.LEATHERARMOUR || item.getItemType() == ItemType.PLATEARMOUR || item.getItemType() == ItemType.SHIELD)
                    System.out.println(" - Damage reduction: " + item.getDmgReduction() + "%");
                else if (item.getItemType() == ItemType.BOW || item.getItemType() == ItemType.ONEHANDEDWEAPON || item.getItemType() == ItemType.TWOHANDEDWEAPON)
                    System.out.println(" - Damage increase: " + item.getDmg() + "%");
                i++;
            }
        } catch (NullPointerException e) {
            System.out.println("Inventory is empty.");
        }
    }
    
    public void showEquippedItems(){
        int i = 1;
        if (equipped.isEmpty()){
            System.out.println("No items equipped.");
        }
        try {
            for (Item item : equipped.values()) {
                System.out.print(i + ". " + item.getName());
                if (item.getItemType() == ItemType.CLOTHARMOUR || item.getItemType() == ItemType.LEATHERARMOUR || item.getItemType() == ItemType.PLATEARMOUR || item.getItemType() == ItemType.SHIELD)
                    System.out.println(" - Damage reduction: " + item.getDmgReduction() + "%");
                else if (item.getItemType() == ItemType.BOW || item.getItemType() == ItemType.ONEHANDEDWEAPON || item.getItemType() == ItemType.TWOHANDEDWEAPON)
                    System.out.println(" - Damage increase: " + item.getDmg() + "%");
                i++;
            }
        } catch (NullPointerException e) {
            System.out.println("No items equipped.");
        }
    }
    
    public void equipItem(int invSlot){
        Item itemToEquip = getInventory().get(invSlot-1);
        ItemType itemToEquipType = itemToEquip.getItemType();
        ItemSlot itemToEquipSlot = itemToEquip.getItemSlot();
        
        if (findClass().equals("Wizard") && itemToEquipType != ItemType.CLOTHARMOUR){
            System.out.println("You are not eligible to equip that item.");
            return;
        }
        
        else if (findClass().equals("Archer") && (itemToEquipType != ItemType.CLOTHARMOUR || itemToEquipType != ItemType.LEATHERARMOUR || itemToEquipType != ItemType.BOW)){
            System.out.println("You are not eligible to equip that item.");
            return;
        }
                
        getInventory().remove(invSlot-1);
               
        //Remove both mainhand and offhand if twohandedweapon or bow is equipped
        if (itemToEquipType == ItemType.BOW || itemToEquipType == ItemType.TWOHANDEDWEAPON){
            if (equipped.containsKey(ItemSlot.OFFHAND)){
                getInventory().add(equipped.get(ItemSlot.OFFHAND));
                equipped.remove(ItemSlot.OFFHAND);
            }
            if (equipped.containsKey(ItemSlot.MAINHAND)){
                getInventory().add(equipped.get(ItemSlot.MAINHAND));
                equipped.remove(ItemSlot.MAINHAND);
            }
        }
        
        //Remove weapon from mainhand if it is 2 handed when equipping a shield
        else if (itemToEquipType == ItemType.SHIELD){
            if (equipped.containsKey(ItemSlot.MAINHAND)){
                if (equipped.get(ItemSlot.MAINHAND).getItemType() == ItemType.TWOHANDEDWEAPON){
                    getInventory().add(equipped.get(ItemSlot.MAINHAND));
                    equipped.remove(ItemSlot.MAINHAND);
                }
            }
        }
        
        //If an item is already equipped in that slot, remove it and put it in inventory
        else if (equipped.containsKey(itemToEquipSlot)){
            getInventory().add(equipped.get(itemToEquipSlot));
            equipped.remove(itemToEquipSlot);
        }
        
        equipped.put(itemToEquipSlot, itemToEquip);
        
        System.out.println("Item equipped!");
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
    public void giveExp(int exp){
        this.exp += exp;
        if (this.exp >= 100){
            this.exp= this.exp - 100;
            this.lvl +=1;
        }
    }
    public void bossReward(){
        score +=100;
        giveExp(50);
    }
    
    public void enemyReward(){
        Random r = new Random();
        Item item = null;
        giveExp(15);
        score += 20;
        int roll = 0;
        if (this.findClass().equals("Warrior"))
            roll = randWarrior(r);
        else if (this.findClass().equals("Archer"))
            roll = randArcher(r);
        else if (this.findClass().equals("Wizard"))
            roll = randWizard(r);

        switch (roll){
            case 0: item = new Item(ItemType.BOW); break;          
            case 1: item = new Item(ItemType.CLOTHARMOUR); break;
            case 2: item = new Item(ItemType.LEATHERARMOUR); break;
            case 3: item = new Item(ItemType.ONEHANDEDWEAPON); break;
            case 4: item = new Item(ItemType.PLATEARMOUR); break;
            case 5: item = new Item(ItemType.SHIELD); break;
            case 6: item = new Item(ItemType.TWOHANDEDWEAPON); break;
        }
        inventory.add(item);
    }
    private int randWarrior(Random r){
        int roll = r.nextInt(7);
        return roll;
    } 
    private int randArcher(Random r){
        int roll = r.nextInt(40);
        if (roll < 10)
            return 0;
        else if (roll < 20)
            return 1;
        else if (roll < 30)
            return 2;
        roll = r.nextInt(7);
        return roll;
    }
    private int randWizard(Random r){
        int roll = r.nextInt(10);
        if (roll < 7)
            return 1;
        roll = r.nextInt(7);
        return roll;
    } 
    
    public void challengeReward() {
        health = 100;
        giveExp(15);
        score += 20;
    }
    
    public void getCurrentStats(){
        System.out.println("\nHealth: " + this.getHealth() + " Level: " + this.getLvl() +  " exp: " + this.getExp() + " Score: " + this.getScore());
    }

    /**
     * @return the damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * @param damage the damage to set
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * @return the inventory
     */
    public ArrayList<Item> getInventory() {
        return inventory;
    }

    /**
     * @param inventory the inventory to set
     */
    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }
    
    //Getters and setters for attack booleans (SED)
    
    public boolean getDefensive(){
        return defensive;
    }
    
    public void setDefensive(boolean defensive){
        this.defensive = defensive;
    }
    
    public boolean getDot(){
        return dot;
    }
    
    public void setDot(boolean dot){
        this.dot = dot;
    }
 
}
