package pdc.project.Model;

import java.util.Random;

/**
 * Class for enemy tiles. Extends Tile. Contains the information about 
 * the enemy.
 */
public class Enemy extends Tile{
    private String enemyName;
    private int enemyHealth;
    //private int damageLow;
    private int damageHigh;
    private int chanceToHit;
    private int chanceToCrit;
    private int chanceToDodge;
    private int expYield;
    private Item itemYield;
    private String difficulty = "";
    private boolean stun;
    
    public Enemy() {}
    public Enemy(int xLoc, int yLoc, boolean stun){
        setType(TileType.ENEMY);
        randomizeName();
        chooseDifficulty(xLoc,yLoc,12);
        chooseStats(difficulty);
        this.stun = false;
    }
    public void chooseStats(String difficulty) {
        Random random = new Random();
        if (difficulty.equals("easy")) {
            //damageLow = random.nextInt(5)+1;
            damageHigh = random.nextInt(15)+1;
            chanceToHit = 70;
            chanceToDodge = 10;
            chanceToCrit = 10;
            expYield = 35;
            enemyHealth = 100;
        }
        if (difficulty.equals("medium")) {
            //damageLow = random.nextInt(10)+1;
            damageHigh = random.nextInt(20)+1;
            chanceToHit = 70;
            chanceToDodge = 10;
            chanceToCrit = 10;
            expYield = 35;
            enemyHealth = 100;
        }
        if (difficulty.equals("hard")) {
            //damageLow = random.nextInt(15)+1;
            damageHigh = random.nextInt(25)+1;
            chanceToHit = 70;
            chanceToDodge = 10;
            chanceToCrit = 10;
            expYield = 35;
            enemyHealth = 100;
        }
        
    }
    public void chooseDifficulty(int xLoc, int yLoc, int gameBoardSize) {
        int divideResult = 0;
        divideResult = (int)gameBoardSize/3;
        int easy = 12 - divideResult; //==8
        int medium = 12 - (divideResult*2); //==4
        int hard = 12 - (divideResult*3); //==0
        if (yLoc >= easy) {
            setDifficulty("easy"); //can fight 2 monsters with no heal
        }
        if (yLoc >= medium) {
            setDifficulty("medium"); //could need to heal, could not need
        }
        if (yLoc >= hard) {
            setDifficulty("hard"); //can fight no more than 1 monster with no heal.
        }
    }
    public void randEasy() {
        
    }
    public void randMedium() {
        
    }
    public void randHard() {
        
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
//    public int getDamageLow() {
//        return damageLow;
//    }

    /**
     * @param damageLow the damageLow to set
     */
//    public void setDamageLow(int damageLow) {
//        this.damageLow = damageLow;
//    }

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
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    public String getDifficulty() {
        return difficulty;
    }
    
    //Added by SED for stun variable
    public void setStun(boolean stun){
        this.stun = stun;
    }
    public boolean getStun(){
        return stun;
    }
}
