package pdc.project.Controller;



import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import pdc.project.Model.Enemy;
import pdc.project.Model.Item;
import pdc.project.Model.ItemType;
import pdc.project.Model.Player;


public class Combat {
    
    //Method to start the combat
    //Show player and enemy stats
    //Call appropriate attack method based on class
    
    public static void combatStart(Enemy enemy, Player player){
        
        int defensiveCount = 0;
        int dotCount = 0;
        
        System.out.println("\n"+enemy.getEnemyName()+" approaches, prepare for battle: ");
        System.out.println("\nEnemy: " + enemy.getEnemyName() + "\nEnemy health: " + enemy.getEnemyHealth() + "\n");
        System.out.println("Player health: " + player.getHealth());
        
        selectClassCombat(enemy, player, defensiveCount, dotCount);
    }
    
    //Method to check class of player and choose appropriate attack phase
    public static void selectClassCombat(Enemy enemy, Player player, int defensiveCount, int dotCount){

        if(player.findClass().contains("Warrior")){   
            warriorAttackPhase(enemy, player, defensiveCount, dotCount);
        }
        else if(player.findClass().contains("Archer")){
            archerAttackPhase(enemy, player, defensiveCount, dotCount);
        }
        else if(player.findClass().contains("Wizard")){
            wizardAttackPhase(enemy, player, defensiveCount, dotCount);
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////
    
    //CLASS ATTACK PHASES//
    
    //Warrior attack phase method   
    public static void warriorAttackPhase(Enemy enemy, Player player, int defensiveCount, int dotCount){
                     
        Scanner scan = new Scanner(System.in);   
    
        boolean correctInput = false;
        while (!correctInput){
            System.out.println("1. Sword strike\n2: Bleeding strike\n3: Defensive stance");
            try{               
                int command = scan.nextInt();
                scan.nextLine();
                
                if(command == 1){
                    correctInput = true;
                    warriorCalcution(enemy, player, defensiveCount, dotCount);
                }
                else if(command == 2){
                    correctInput = true;
                    player.setDot(true);
                    dotCount = 3;
                    int damage = bleedCalc(enemy);
                    enemyHealthReduction(enemy, damage);
                }
                else if(command == 3){
                    correctInput = true;
                    player.setDefensive(true);
                    defensiveCount = 2;                                      
                }
                
                defenseUpdate(player, defensiveCount);
                dotUpdate(player, dotCount);
                
                if(enemy.getEnemyHealth() > 0){
                    System.out.println(enemy.getEnemyName()+" has been reduced to "+enemy.getEnemyHealth()+".");
                    enemyAttackPhase(enemy, player, defensiveCount, dotCount);
                }
                else {
                    System.out.print(enemy.getEnemyName() + " has been defeated, enter any key to continue the adventure: ");
                    scan.next();
                }
            }catch(InputMismatchException e){
                    System.err.println("Command not recognised.");
                    scan.next();
            }
        }
    }
    
    //Archer attack phase method   
    public static void archerAttackPhase(Enemy enemy, Player player, int defensiveCount, int dotCount){ 
        
        Scanner scan = new Scanner(System.in);   
    
        boolean correctInput = false;
        while (!correctInput){
            System.out.println("1. Sword strike\n2: Bleeding strike\n3: Defensive stance");
            try{               
                int command = scan.nextInt();
                scan.nextLine();
                
                if(command == 1){
                    correctInput = true;
                    archerCalculation(enemy, player, defensiveCount, dotCount);
                }
                else if(command == 2){
                    correctInput = true;
                    player.setDot(true);
                    dotCount = 3;
                    int damage = poisonShotCalc(enemy, player);
                    enemyHealthReduction(enemy, damage);
                }
                else if(command == 3){
                    correctInput = true;
                    player.setDefensive(true);
                    defensiveCount = 2;                                      
                }
                
                if(enemy.getEnemyHealth() > 0){
                    System.out.println(enemy.getEnemyName()+" has been reduced to "+enemy.getEnemyHealth()+".");
                    enemyAttackPhase(enemy, player, defensiveCount, dotCount);
                }
                else {
                    System.out.print(enemy.getEnemyName() + " has been defeated, enter any key to continue the adventure: ");
                    scan.next();
                }
            }catch(InputMismatchException e){
                    System.err.println("Command not recognised.");
                    scan.next();
            }
        }
    }
     
    //Wizard attack phase method    
    public static void wizardAttackPhase(Enemy enemy, Player player, int defensiveCount, int dotCount){

        Scanner scan = new Scanner(System.in);   
    
        boolean correctInput = false;
        while (!correctInput){
            System.out.println("1. Dark Missile\n2: Soul Leech\n3: Blood Shield");
            try{               
                int command = scan.nextInt();
                scan.nextLine();
                
                if(command == 1){
                    correctInput = true;
                    wizardCalculation(enemy, player, defensiveCount, dotCount);
                }
                else if(command == 2){
                    correctInput = true;
                    player.setDot(true);
                    dotCount = 3;
                    int damage = soulLeechCalc(enemy, player);
                    enemyHealthReduction(enemy, damage);
                }
                else if(command == 3){
                    correctInput = true;
                    player.setDefensive(true);
                    defensiveCount = 2;                                      
                }
                
                if(enemy.getEnemyHealth() > 0){
                    System.out.println(enemy.getEnemyName()+" has been reduced to "+enemy.getEnemyHealth()+".");
                    enemyAttackPhase(enemy, player, defensiveCount, dotCount);
                }
                else {
                    System.out.print(enemy.getEnemyName() + " has been defeated, enter any key to continue the adventure: ");
                    scan.next();
                }
            }catch(InputMismatchException e){
                    System.err.println("Command not recognised.");
                    scan.next();
            }
        }
    }
      
    /////////////////////////////////////////////////////////////////////////////////////////////////////

    //CLASS ATTACK PHASE CALCULATIONS//
    
    //Warrior attack phase calculations
    
    public static void warriorCalcution(Enemy enemy, Player player, int defensiveCount, int dotCount){

        if((!enemyDodgeCalc(enemy)) && (playerHitCalc(player))){
            playerDamageCalc(enemy, player);
            //System.out.println(enemy.getEnemyName()+" has been reduced to "+enemy.getEnemyHealth()+".");
        }
        else if(enemyDodgeCalc(enemy) || (!playerHitCalc(player))){
            System.out.println("Your attack has missed the enemy.");
        }
        dotUpdate(player, dotCount);
        defenseUpdate(player, defensiveCount);
    }
    
    //Archer attack phase calculations
    public static void archerCalculation(Enemy enemy, Player player, int defensiveCount, int dotCount){
        if((!enemyDodgeCalc(enemy)) && (playerHitCalc(player))){
            playerDamageCalc(enemy, player);
            //System.out.println(enemy.getEnemyName()+" has been reduced to "+enemy.getEnemyHealth()+".");
        }
        else if(enemyDodgeCalc(enemy) || (!playerHitCalc(player))){
            System.out.println("Your attack has missed the enemy.");
        }  
        dotUpdate(player, dotCount);
        defenseUpdate(player, defensiveCount);
    }
    
    //Wizard attack phase calculations
    public static void wizardCalculation(Enemy enemy, Player player, int defensiveCount, int dotCount){
        if((!enemyDodgeCalc(enemy)) && (playerHitCalc(player))){
            playerDamageCalc(enemy, player);
            //System.out.println(enemy.getEnemyName()+" has been reduced to "+enemy.getEnemyHealth()+".");
        }
        else if(enemyDodgeCalc(enemy) || (!playerHitCalc(player))){
            System.out.println("Your attack has missed the enemy.");
        }  
        dotUpdate(player, dotCount);
        defenseUpdate(player, defensiveCount);
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    
    //CALCULATION METHODS// 
    
    //Update dot and dot counter   
    public static void dotUpdate(Player player, int dotCount){
        if(player.getDot()){
            dotCount --;
            if(dotCount == 0){
                player.setDot(false);
            }
        }
    }
    
    //Update defense and defense counter    
    public static void defenseUpdate(Player player, int defenseCount){
        if(player.getDefensive()){
            defenseCount --;
            if(defenseCount == 0){
                player.setDefensive(false);
            }
        }
    }
    
    //Bleeding strike calculation    
    public static int bleedCalc(Enemy enemy){
        int bleedDamage = (enemy.getEnemyHealth() / 100 * 10);
        return bleedDamage;
    }
    
    //Soul leech effects calculation   
    public static int soulLeechCalc(Enemy enemy, Player player){
        int soulLeechDamage = player.getDamage() / 100 * 25;
        return soulLeechDamage;
    }
    
    //Poision shot effect calculation    
    public static int poisonShotCalc(Enemy enemy, Player player){
        int poisonDamage = player.getDamage() / 100 * 10;
        enemy.setChanceToDodge(enemy.getChanceToDodge() - (enemy.getChanceToDodge() / 100 * 5));
        enemy.setChanceToHit(enemy.getChanceToHit() - (enemy.getChanceToHit() / 100 * 5));
        return poisonDamage;
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////
    
    //ENEMY ATTACK PHASE//
       
    //Enemy attack phase   
    public static void enemyAttackPhase(Enemy enemy, Player player, int defensiveCount, int dotCount){
        Scanner scan = new Scanner(System.in);
        System.out.println("The enemy attacks...");

        if((!playerDodgeCalc(player)) && (enemyHitCalc(enemy))){
            enemyDamageCalc(enemy, player);           
        }
        if(player.getHealth() > 0){
            System.out.println("Your health has been reduced to " + player.getHealth() + "\nEnter any key to continue: ");  
            scan.nextLine();
            selectClassCombat(enemy, player, defensiveCount, dotCount);
        }
        else
            quit();            
    }
    
    /////////////////////////////////////////////////////////////////////////////////
    
    //DAMAGE CALCULATION METHODS//
        
    //Player damage calculation   
    public static void playerDamageCalc(Enemy enemy, Player player){
        int totalDamage;
        if(playerCritCalc(player)){
            totalDamage = player.getDamage() + ((player.getDamage() / 100) * 25);
        }
        else    
            totalDamage = player.getDamage();
        
        if((player.getDot()) && (player.findClass().contains("Archer"))){
            totalDamage += poisonShotCalc(enemy, player);
        }
        else if(player.getDot() && (player.findClass().contains("Wizard"))){
            totalDamage += soulLeechCalc(enemy, player);
        }
        else if(player.getDot() && (player.findClass().contains("Warrior"))){
            totalDamage += bleedCalc(enemy);
        }
        
        HashMap<Integer, Item> equipped = player.getEquipped();
        
        if(equipped != null){
            for (Item item : equipped.values()) {
                if (item.getItemType() == ItemType.BOW || item.getItemType() == ItemType.ONEHANDEDWEAPON || item.getItemType() == ItemType.TWOHANDEDWEAPON)
                    totalDamage += item.getDmg();
            }
        }
        enemyHealthReduction(enemy, totalDamage); 
    }
       
    //Enemy damage calculation
    public static void enemyDamageCalc(Enemy enemy, Player player){
        int totalDamage;
        if(enemyCritCalc(enemy)){
            totalDamage = enemy.getDamageHigh() + ((enemy.getDamageHigh() / 100) * 25);
        }
        else    
            totalDamage = enemy.getDamageHigh();  
        

        HashMap<Integer, Item> equipped = player.getEquipped();
        if (equipped != null){
            for (Item item : equipped.values()) {
                if (item.getItemType() == ItemType.CLOTHARMOUR || item.getItemType() == ItemType.LEATHERARMOUR || item.getItemType() == ItemType.PLATEARMOUR || item.getItemType() == ItemType.SHIELD)
                    totalDamage -= item.getDmgReduction();
            }
        }
        
        playerHealthReduction(player, totalDamage);
    }
    
    ///////////////////////////////////////////////////////////////////////////////////
    
    //HEALTH REDUCTION METHODS//
    
    //Enemy health reduction method
    public static Enemy enemyHealthReduction(Enemy enemy, int totalDamage){
        enemy.setEnemyHealth(enemy.getEnemyHealth() - totalDamage);
        return enemy;
    }
    
    //Player health reduction method
    public static Player playerHealthReduction(Player player, int totalDamage){
        player.setHealth(player.getHealth() - totalDamage);
        return player;
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////
    
    // CALCULATIONS FOR PLAYER CHANCES //
    
    //Player dodge chance calculation 
    public static boolean playerDodgeCalc(Player player){
        
        if("Warrior".equals(player.findClass())){
            Random r = new Random();
            int Low = 1;
            int High = 10;
            int R = r.nextInt(High-Low) + Low;
        
            return R == 1;        
        }
        if("Archer".equals(player.findClass())){
            if(player.getDefensive()){
                Random r = new Random();
                int Low = 1;
                int High = 10;
                int R = r.nextInt(High-Low) + Low;
                
                return R <= 5;
            }
            else{
                Random r = new Random();
                int Low = 1;
                int High = 10;
                int R = r.nextInt(High-Low) + Low;

                return R <= 3; 
            }
        }
        if("Wizard".equals(player.findClass())){
            Random r = new Random();
            int Low = 1;
            int High = 20;
            int R = r.nextInt(High-Low) + Low;
        
            return R == 1; 
        }       
        return false;
    }
    
    //Player critical hit chance calculation  
    public static boolean playerCritCalc(Player player){
        
        if("Warrior".equals(player.findClass())){
            Random r = new Random();
            int Low = 1;
            int High = 10;
            int R = r.nextInt(High-Low) + Low;
        
            return R == 1 || R == 2;        
        }
        if("Archer".equals(player.findClass())){
            Random r = new Random();
            int Low = 1;
            int High = 10;
            int R = r.nextInt(High-Low) + Low;
        
            return R == 1 || R == 2 || R == 3;            
        }
        if("Wizard".equals(player.findClass())){
            Random r = new Random();
            int Low = 1;
            int High = 20;
            int R = r.nextInt(High-Low) + Low;
        
            return R == 1 || R == 2; 
        }       
        return false;       
    }
    
    // Player hit chance calculation    
    public static boolean playerHitCalc(Player player){
        if("Warrior".equals(player.findClass())){
            Random r = new Random();
            int Low = 1;
            int High = 10;
            int R = r.nextInt(High-Low) + Low;
        
            return R != 1;        
        }
        if("Archer".equals(player.findClass())){
            Random r = new Random();
            int Low = 1;
            int High = 10;
            int R = r.nextInt(High-Low) + Low;
        
            return R != 1 || R != 2;            
        }
        if("Wizard".equals(player.findClass())){
            Random r = new Random();
            int Low = 1;
            int High = 20;
            int R = r.nextInt(High-Low) + Low;
        
            return R != 1; 
        }       
        return false;         
    } 
    
    //CALCULATIONS FOR ENEMY CHANCES//
    
    //Enemy dodge chance calculation    
    public static boolean enemyDodgeCalc(Enemy enemy){
        if(enemy.getStun() == false){
            Random r = new Random();
            int Low = 1;
            int High = 10;
            int R = r.nextInt(High-Low) + Low;

            return R == 1;
        }
        else{
            return false;
        }
    }
    
    //Enemy critical hit chance calculation   
    public static boolean enemyCritCalc(Enemy enemy){
        Random r = new Random();
        int Low = 1;
        int High = 10;
        int R = r.nextInt(High-Low) + Low;
        
        return R == 1;        
    }
    
    // Enemy hit chance calculation
    public static boolean enemyHitCalc(Enemy enemy){
        if(enemy.getStun() == false){
            Random r = new Random();
            int Low = 1;
            int High = 10;
            int R = r.nextInt(High-Low) + Low;

            return R != 1 || R != 2 || R != 3;  
        }
        else{
            return false;
        }
    }  
    
    /////////////////////////////////////////////////////////////////////////////////////
    
    // Game over method when player dies
    public static void quit(){
        Scanner scan = new Scanner(System.in);
        System.out.println("GAME OVER\nPress any key to exit: ");
        scan.nextLine();
        System.exit(0);
    }
}
