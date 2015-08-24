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
public class Boss extends Enemy {
    private String enemyName;
    private int enemyHealth;
    private int damageLow;
    private int damageHigh;
    private int chanceToHit;
    private int chanceToCrit;
    private int chanceToDodge;
    //has no item and exp yield because it represents end of game.
    public Boss() {
        setType(TileType.BOSS);
        enemyName = "Martini Lord of the Underworld";
        enemyHealth = 500;
        damageLow = 30;
        damageHigh = 50;
        chanceToHit = 80;
        chanceToCrit = 80;
        chanceToDodge = 10;
    }
}
