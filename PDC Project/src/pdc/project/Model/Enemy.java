/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdc.project.Model;

/**
 *
 * @author MPKohl
 */
public class Enemy {
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
    private int expYeild;
    //Item yield
    private Item itemYeild;
    
    //Method that randomizes a name

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
     * @return the expYeild
     */
    public int getExpYeild() {
        return expYeild;
    }

    /**
     * @param expYeild the expYeild to set
     */
    public void setExpYeild(int expYeild) {
        this.expYeild = expYeild;
    }

    /**
     * @return the itemYeild
     */
    public Item getItemYeild() {
        return itemYeild;
    }

    /**
     * @param itemYeild the itemYeild to set
     */
    public void setItemYeild(Item itemYeild) {
        this.itemYeild = itemYeild;
    }
}
