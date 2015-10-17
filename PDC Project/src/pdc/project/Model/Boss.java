package pdc.project.Model;

/**
 * Subclass of enemy for the Boss of the game. The Boss is always the same.
 */
public class Boss extends Enemy {
    private String enemyName;
    private int enemyHealth;
    private int damageLow;
    private int damageHigh;
    private int chanceToHit;
    private int chanceToCrit;
    private int chanceToDodge;
    
    /**
     * Constructor for Boss. Sets all stats to preset values.
     */
    public Boss() {
        //has no item and exp yield because it represents end of game.
        setType(TileType.BOSS);
        enemyName = "Martini Lord of the Underworld";
        enemyHealth = 500;
        damageLow = 30;
        damageHigh = 50;
        chanceToHit = 80;
        chanceToCrit = 80;
        chanceToDodge = 10;
    }
    
    /**
     * Returns the name of the enemy.
     * @return String enemyName the name of the enemy. 
     */
    @Override
    public String getEnemyName() {
        return enemyName;
    }
    
    /**
     * Returns the health of the enemy as an int.
     * @return int enemyHealth the amount of health the enemy has left.
     */
    @Override
    public int getEnemyHealth() {
        return enemyHealth;
    }

    /**
     * @param enemyName the enemyName to set
     */
    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
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
}
