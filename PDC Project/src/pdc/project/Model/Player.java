package pdc.project.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Super class for the player. Contains name, stats, inventory and equipment.
 */
public abstract class Player {
    private String name = "";
    private int damage;
    private int health;
    private int exp;
    private ArrayList<Item> inventory = new ArrayList<>();
    private double score = 0.0;
    private HashMap<ItemSlot, Item> equipped = new HashMap<>();
    private double hitChance;
    private double critChance;
    private double dodgeChance;
    private int lvl;
    private boolean defensive;
    private boolean dot;
    
    /**
     * Empty constructor for Player.
     */
    public Player() {}
    
    /**
     * Main constructor that sets all fields for the player.
     * @param damage int value representing damage
     * @param name String name
     * @param health int value representing health
     * @param exp int value representing experience
     * @param inventory ArrayList<Item> representing inventory
     * @param score double value representing score
     * @param equipped HashMap<ItemSlot, Item> representing equipped Items
     * @param hitChance double value representing chance to hit in percent
     * @param critChance double value representing chance to hit a critical strike in percent
     * @param dodgeChance double value representing chance to dodge an attack in percent
     * @param defensive boolean true if Player is in defensive stance
     * @param dot boolean true if damage over time spell is active
     */
    public Player(int damage, String name, int health, int exp, ArrayList inventory,
            double score, HashMap equipped, double hitChance, double critChance, 
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
    }        
    
    /**
     * Returns the class of the player as a PlayerClass enumeration.
     * @return PlayerClass enumeration
     */
    public PlayerClass findClass(){
        return PlayerClass.NONE;
    }
    
    /**
     * Moves the chosen item (by ArrayList index + 1) from the inventory list to 
     * the equipment HashMap. If an item of that ItemSlot enumeration is already 
     * in the HashMap, replace it and move that Item to the inventory.
     * @param invSlot ArrayList index in inventory + 1
     * @param gameIsCUIVersion true if the game is played through the CUI, false if GUI
     */
    public void equipItem(int invSlot, boolean gameIsCUIVersion){
        Item itemToEquip = getInventory().get(invSlot-1);
        ItemType itemToEquipType = itemToEquip.getItemType();
        ItemSlot itemToEquipSlot = itemToEquip.getItemSlot();
        
        if (findClass() == PlayerClass.WIZARD && itemToEquipType != ItemType.CLOTHARMOUR){
            if (gameIsCUIVersion){
                System.out.println("You are not eligible to equip that item.");
            } else {
                // **** SHANON INSERT YOUR CODE FOR THE GUI VERSION HERE ****
            }
            return;
        }
        
        else if (findClass() == PlayerClass.ARCHER && !(itemToEquipType == ItemType.CLOTHARMOUR || itemToEquipType == ItemType.LEATHERARMOUR || itemToEquipType == ItemType.BOW)){
            if (gameIsCUIVersion){
                System.out.println("You are not eligible to equip that item.");
            } else {
                // **** SHANON INSERT YOUR CODE FOR THE GUI VERSION HERE ****
            }
            return;
        }
                
        getInventory().remove(invSlot-1);
               
        //Remove both mainhand and offhand if twohandedweapon or bow is equipped
        if (itemToEquipType == ItemType.BOW || itemToEquipType == ItemType.TWOHANDEDWEAPON){
            if (getEquipped().containsKey(ItemSlot.OFFHAND)){
                getInventory().add(getEquipped().get(ItemSlot.OFFHAND));
                getEquipped().remove(ItemSlot.OFFHAND);
            }
            if (getEquipped().containsKey(ItemSlot.MAINHAND)){
                getInventory().add(getEquipped().get(ItemSlot.MAINHAND));
                getEquipped().remove(ItemSlot.MAINHAND);
            }
        }
        
        //Remove weapon from mainhand if it is 2 handed when equipping a shield
        else if (itemToEquipType == ItemType.SHIELD){
            if (getEquipped().containsKey(ItemSlot.MAINHAND)){
                if (getEquipped().get(ItemSlot.MAINHAND).getItemType() == ItemType.TWOHANDEDWEAPON){
                    getInventory().add(getEquipped().get(ItemSlot.MAINHAND));
                    getEquipped().remove(ItemSlot.MAINHAND);
                }
            }
        }
        
        //If an item is already equipped in that slot, remove it and put it in inventory
        else if (getEquipped().containsKey(itemToEquipSlot)){
            getInventory().add(getEquipped().get(itemToEquipSlot));
            getEquipped().remove(itemToEquipSlot);
        }
        
        getEquipped().put(itemToEquipSlot, itemToEquip);
        
        System.out.println("Item equipped!");
    }
    
    /**
     * Checks whether the Player should level up at current experience. 
     * If this is the case the Player levels up and experience is set to 0.
     */
    public void isLvlUp(){
         if (this.getExp() == 100){
             this.setLvl(getLvl() + 1);
             setExp(0);
         }
    }
    
    /**
     * Gives the Player the chosen amount of experience points.
     * @param exp int representation of experience points to add
     */
    public void giveExp(int exp){
        this.setExp(this.getExp() + exp);
        if (this.getExp() >= 100){
            this.setExp(this.getExp() - 100);
            this.setLvl(this.getLvl() + 1);
        }
    }
    
    /**
     * Rewards the Player after defeating the final boss.
     */
    public void bossReward(){
        setScore(getScore() + 100);
        giveExp(50);
    }
    
    /**
     * Rewards the Player after finishing the game based on time spent. 
     * The faster the better.
     * Faster than 4 minutes = 1.5 * score 
     * Faster than 6 minutes = 1.35 * score 
     * Faster than 10 minutes = 1.1 * score
     * @param startTime int[3] where [0] is hours, [1] minutes and [2] seconds 
     */
    public void timerReward(int[] startTime){
        DataHolder data = DataHolder.getInstance();
        int[] finishTime = data.getTimer().getCurrentTime();
        int[] finalTime = new int[3];
        
        for(int i = 0; i > 3; i++){
            finalTime[i] = finishTime[i] - startTime[i]; 
        }
        
        // If the player used less than 4 minutes to complete the game,
        // add 50% to the score
        if(finalTime[0] == 0 && finalTime[1] < 4){
            setScore(getScore() * 1.5);
        }
        
        // If the player used between 4 and 6 minutes to complete the game,
        // add 35% to the score
        else if(finalTime[0] == 0 && finalTime[1] < 6){
            setScore(getScore() * 1.35);
        }
        
        // If the player used between 6 and 10 minutes to complete the game,
        // add 10% to the score
        else if(finalTime[0] == 0 && finalTime[1] < 10){
            setScore(getScore() + getScore() * 0.15);
        }
    }
    
    /**
     * Rewards the player with experience, score points and an item after combat 
     * The rewarded Item is random, but weighted towards the items eligible 
     * for the Players class.
     * @return the Item rewarded
     */
    public Item enemyReward(){
        Random r = new Random();
        Item item = null;
        int roll = 0;
        
        giveExp(15);
        setScore(getScore() + 20);
        
        if (this.findClass()== PlayerClass.WARRIOR)
            roll = randWarrior(r);
        else if (this.findClass()== PlayerClass.ARCHER)
            roll = randArcher(r);
        else if (this.findClass()== PlayerClass.WIZARD)
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
        getInventory().add(item);
        
        return item;
    }
    
    /**
     * Random rolls for Warrior items.
     * @param r Random object
     * @return int random int between 0 and 6
     */
    private int randWarrior(Random r){
        int roll = r.nextInt(7);
        return roll;
    } 
    
    /**
     * Random rolls for Archer items. Weighted towards items eligible for Archers.
     * @param r Random object
     * @return int random int between 0 and 6
     */
    private int randArcher(Random r){
        int roll = r.nextInt(40);
        if (roll < 10)
            return 0;
        else if (roll < 20)
            return 1;
        else if (roll < 30)
            return 2;
        else {
            roll = r.nextInt(7);
        return roll;
        }
    }
    
    /**
     * Random rolls for Wizard items. Weighted towards items eligible for Wizards.
     * @param r Random object
     * @return int random int between 0 and 6
     */
    private int randWizard(Random r){
        int roll = r.nextInt(10);
        if (roll < 7)
            return 1;
        else {
            roll = r.nextInt(7);
            return roll;
        }
    } 
    
    /**
     * Rewards the Player with experience, score points and full health after 
     * a correct guess in a Challenge.
     */
    public void challengeReward() {
        setHealth(100);
        giveExp(15);
        setScore(getScore() + 20);
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
        return isDefensive();
    }
    
    public void setDefensive(boolean defensive){
        this.defensive = defensive;
    }
    
    public boolean getDot(){
        return isDot();
    }
    
    public void setDot(boolean dot){
        this.dot = dot;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * @return the exp
     */
    public int getExp() {
        return exp;
    }

    /**
     * @param exp the exp to set
     */
    public void setExp(int exp) {
        this.exp = exp;
    }

    /**
     * @return the score
     */
    public double getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(double score) {
        this.score = score;
    }

    /**
     * @return the equipped
     */
    public HashMap<ItemSlot, Item> getEquipped() {
        return equipped;
    }

    /**
     * @param equipped the equipped to set
     */
    public void setEquipped(HashMap<ItemSlot, Item> equipped) {
        this.equipped = equipped;
    }

    /**
     * @return the hitChance
     */
    public double getHitChance() {
        return hitChance;
    }

    /**
     * @param hitChance the hitChance to set
     */
    public void setHitChance(double hitChance) {
        this.hitChance = hitChance;
    }

    /**
     * @return the critChance
     */
    public double getCritChance() {
        return critChance;
    }

    /**
     * @param critChance the critChance to set
     */
    public void setCritChance(double critChance) {
        this.critChance = critChance;
    }

    /**
     * @return the dodgeChance
     */
    public double getDodgeChance() {
        return dodgeChance;
    }

    /**
     * @param dodgeChance the dodgeChance to set
     */
    public void setDodgeChance(double dodgeChance) {
        this.dodgeChance = dodgeChance;
    }

    /**
     * @return the lvl
     */
    public int getLvl() {
        return lvl;
    }

    /**
     * @param lvl the lvl to set
     */
    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    /**
     * @return the defensive
     */
    public boolean isDefensive() {
        return defensive;
    }

    /**
     * @return the dot
     */
    public boolean isDot() {
        return dot;
    } 
}
