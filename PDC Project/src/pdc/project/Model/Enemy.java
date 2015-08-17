/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdc.project.Model;

import java.util.Random;

/**
 *
 * @author MPKohl
 */
public class Enemy extends Tile{
    //Name
    private String enemyName;
    //Health
    private int enemyHealth;
    //Damage low
    private int damageLow;
    //Damage High
    private int damageHigh;
    //Chance to hit
    private int chanceToHit;
    //Chance to crit
    private int chanceToCrit;
    //Chance to dodge
    private int chanceToDodge;
    //Difficulty - Enumeration
    //Experience yield
    private int expYield;
    //Item yield
    private Item itemYield;
    
    public Enemy(){
        setType(TileType.ENEMY);
        randomizeName();
    }
    
    public void randomizeName(){
        Random random = new Random();
                
        String[] prefixes = new String[8];
        String[] suffixes = new String[8];
        
        String prefix;
        String suffix;
        
        prefixes[0] = "Orc";
        prefixes[1] = "Ogre";
        prefixes[2] = "Goblin";
        prefixes[3] = "Brother";
        prefixes[4] = "Giant Space Hamster";
        prefixes[5] = "Dragonling";
        prefixes[6] = "Huge Salamander";
        prefixes[7] = "Minotaur";
        
        suffixes[0] = "of the Swamp";
        suffixes[1] = "of Destruction";
        suffixes[2] = "of the Deep";
        suffixes[3] = "from Another Mother";
        suffixes[4] = "from the 32nd Dimension";
        suffixes[5] = "that just got off the Tardis";
        suffixes[6] = "that loves My Little Pony";
        suffixes[7] = "that has a Horrible Imagination";
        
        prefix = prefixes[random.nextInt(8)];
        suffix = suffixes[random.nextInt(8)];
        
        enemyName = prefix + " " + suffix;
    }

    /**
     * @return the enemyName
     */
    public String getEnemyName() {
        return enemyName;
    }

    /**
     * @param enemyName the enemyName to set
     */
    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    /**
     * @return the enemyHealth
     */
    public int getEnemyHealth() {
        return enemyHealth;
    }

    /**
     * @param enemyHealth the enemyHealth to set
     */
    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    /**
     * @return the damageLow
     */
    public int getDamageLow() {
        return damageLow;
    }

    /**
     * @param damageLow the damageLow to set
     */
    public void setDamageLow(int damageLow) {
        this.damageLow = damageLow;
    }

    /**
     * @return the damageHigh
     */
    public int getDamageHigh() {
        return damageHigh;
    }

    /**
     * @param damageHigh the damageHigh to set
     */
    public void setDamageHigh(int damageHigh) {
        this.damageHigh = damageHigh;
    }

    /**
     * @return the chanceToHit
     */
    public int getChanceToHit() {
        return chanceToHit;
    }

    /**
     * @param chanceToHit the chanceToHit to set
     */
    public void setChanceToHit(int chanceToHit) {
        this.chanceToHit = chanceToHit;
    }

    /**
     * @return the chanceToCrit
     */
    public int getChanceToCrit() {
        return chanceToCrit;
    }

    /**
     * @param chanceToCrit the chanceToCrit to set
     */
    public void setChanceToCrit(int chanceToCrit) {
        this.chanceToCrit = chanceToCrit;
    }

    /**
     * @return the chanceToDodge
     */
    public int getChanceToDodge() {
        return chanceToDodge;
    }

    /**
     * @param chanceToDodge the chanceToDodge to set
     */
    public void setChanceToDodge(int chanceToDodge) {
        this.chanceToDodge = chanceToDodge;
    }

    /**
     * @return the expYield
     */
    public int getExpYield() {
        return expYield;
    }

    /**
     * @param expYield the expYeild to set
     */
    public void setExpYield(int expYield) {
        this.expYield = expYield;
    }

    /**
     * @return the itemYield
     */
    public Item getItemYield() {
        return itemYield;
    }

    /**
     * @param itemYield the itemYield to set
     */
    public void setItemYield(Item itemYield) {
        this.itemYield = itemYield;
    }
}
