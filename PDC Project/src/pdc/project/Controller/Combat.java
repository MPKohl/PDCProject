
package pdc.project.Controller;



import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import pdc.project.Model.DataHolderSingleton;
import pdc.project.Model.Enemy;
import pdc.project.Model.Player;
import pdc.project.Model.Wizard;



public class Combat {
    private static int poisonCount;
    private static int ironCount;
    private static DataHolderSingleton data = DataHolderSingleton.getInstance();
    //Method to start the combat, show player and enemy stats
    
    public static void combatStart(Enemy enemy, Player player){
        
        System.out.println("\nEnemy: " + enemy.getEnemyName() + "\nEnemy health: " + enemy.getEnemyHealth() + "\n");
        System.out.println("Player health: " + player.getHealth());
        
        playerAttack(enemy, player);
    }
    
    private static boolean wizardAttack(Enemy enemy, Player player){
        Scanner scan = new Scanner(System.in);
        if (((Wizard)data.getPlayer()).getPoison()==true && poisonCount < 2){
            poisonDmg(enemy, player);
            System.out.println("Your Poison seeds hurt the enemy!");
            System.out.println("The " + enemy.getEnemyName() + "'s health is now " +enemy.getEnemyHealth());
            if(enemy.getEnemyHealth() <= 0)
                return false;
            poisonCount++;
        }
        if (poisonCount==2){
            System.out.println("Oh no! Your Poison seeds have worn off!");
            ((Wizard)data.getPlayer()).setPoison(false);
            poisonCount=0;
        }
        if (ironCount==1){
            System.out.println("Oh no! Your iron skin has worn off!");
            ((Wizard)data.getPlayer()).setIronSkin(false);
            ironCount=0;
        }
        System.out.println("1. Fireball");
        System.out.println("2. Iron Skin");
        System.out.println("3. Poison Seeds");
        try{
                int command = scan.nextInt();
                scan.nextLine();
                if (command == 1){
                    if((!enemyDodgeCalc(enemy)) && (playerHitCalc(player))){
                        playerDamageCalc(enemy, player);
                    }
                    if(enemy.getEnemyHealth() > 0){
                        System.out.println("Enemy health: " + enemy.getEnemyHealth() + "\nEnter any key to continue: ");
                        scan.next();
                        enemyAttack(enemy, player);
                        return false;
                    }
                     else {
                        System.out.println(enemy.getEnemyName() + " has been defeated, enter any key to continue: ");
                        scan.next();
                        return false;
                    }
                } else if(command == 2){
                    //iron skin
                    if (((Wizard)data.getPlayer()).getIronSkin()==true){
                        System.out.println("\nIron Skin is already enabled");
                        return true;
                    } else {
                        ((Wizard)data.getPlayer()).setIronSkin(true);
                        System.out.println("\nIron Skin is now enabled for 1 turn");
                        //enemy attacks
                        if(enemy.getEnemyHealth() > 0){
                            System.out.println("Enemy health: " + enemy.getEnemyHealth() + "\nEnter any key to continue: ");
                            scan.next();
                            enemyAttack(enemy, player);
                            return false;
                        } else {
                            System.out.println(enemy.getEnemyName() + " has been defeated, enter any key to continue: ");
                            scan.next();
                            return false;
                        }
                    }
                    
                } else if(command == 3){
                    //poison seeds
                    if (((Wizard)data.getPlayer()).getPoison()==true){
                        System.out.println("\nPoison is already enabled");
                        return true;
                    } else {
                        ((Wizard)data.getPlayer()).setPoison(true);
                        System.out.println("\nPoison is now enabled for 2 turns");
                        
                        //enemy attacks
                        if(enemy.getEnemyHealth() > 0){
                            System.out.println("Enemy health: " + enemy.getEnemyHealth() + "\nEnter any key to continue: ");
                            scan.next();
                            enemyAttack(enemy, player);
                            return false;
                        } else {
                            System.out.println(enemy.getEnemyName() + " has been defeated, enter any key to continue: ");
                            scan.next();
                            return false;
                        }
                    }
                }
            }catch(InputMismatchException e){
                System.err.println("I did not recognise that command");
                scan.next();
                return true;
            }
        return false;
    }
    
    
    
    //Main Player attack method
    
    public static void playerAttack(Enemy enemy, Player player){
        
        Scanner scan = new Scanner(System.in);    
    
        boolean x = true;
        int turnCount = 0;
        while (x){
            turnCount++;
            if(data.getPlayer()instanceof Wizard){
                x = wizardAttack(enemy, player);
            }else{
            System.out.println("1. Attack");
            try{               
                int command = scan.nextInt();
                scan.nextLine();
                
                if(command == 1){
                        x = false;
                        if((!enemyDodgeCalc(enemy)) && (playerHitCalc(player))){
                            playerDamageCalc(enemy, player);
                        }
                        if(enemy.getEnemyHealth() > 0){
                            System.out.println("Enemy health: " + enemy.getEnemyHealth() + "\nEnter any key to continue: ");
                            scan.next();
                            enemyAttack(enemy, player);
                        }
                        else {
                            System.out.println(enemy.getEnemyName() + " has been defeated, enter any key to continue: ");
                            scan.next();
                        }

                }
            }catch(InputMismatchException e){
                    System.err.println("I did not recognise that command");
                    scan.next();
            }
        }
        }
    }
    
    //Main Enemy attack method
    
    public static void enemyAttack(Enemy enemy, Player player){
        Scanner scan = new Scanner(System.in);
        if(((Wizard)data.getPlayer()).getIronSkin()==true && ironCount < 2){
            System.out.println("The enemy tries to attack but it is blocked by your iron skin!");
            ironCount++;
        } else {
            System.out.println("The enemy attacks\n");
            if((!playerDodgeCalc(player)) && (enemyHitCalc(enemy))){
                enemyDamageCalc(enemy, player);
            }
        }
        if(player.getHealth() > 0){
            System.out.println("Player health: " + player.getHealth() + "\nEnter any key to continue: ");  
            scan.next();
            playerAttack(enemy, player);
        }
            else
                quit();
            
        
    }
    
    /////////////////////
    
    //Player damage calculation and enemy health reduction
    
    public static Enemy playerDamageCalc(Enemy enemy, Player player){
        int totalDamage;
        if(playerCritCalc(player)){
            totalDamage = player.getDamage() + ((player.getDamage() / 100) * 25);
        }
        else    
            totalDamage = player.getDamage();
        
        enemy.setEnemyHealth(enemy.getEnemyHealth() - totalDamage);
        return enemy;
    }
    
    //Enemy damage calculation and player health reduction
    
    public static Player enemyDamageCalc(Enemy enemy, Player player){
        int totalDamage;
        if(enemyCritCalc(enemy)){
            totalDamage = enemy.getDamageHigh() + ((enemy.getDamageHigh() / 100) * 25);
        }
        else    
            totalDamage = enemy.getDamageHigh();
        
        player.setHealth(player.getHealth() - totalDamage);
        
        return player;
    }
    
    // Calculations for the player chances //
    
    //Player dodge calculation
    
    public static boolean playerDodgeCalc(Player player){
        
        if("Warrior".equals(player.findClass())){
            Random r = new Random();
            int Low = 1;
            int High = 10;
            int R = r.nextInt(High-Low) + Low;
        
            return R == 1;        
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
        
            return R == 1; 
        }       
        return false;
    }
    
    //Player critical hit calculation
    
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
    
    // Player hit calculation
    
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
    
    // Calculations for the enemy chances //
    
    //Enemy dodge calculation
    
    public static boolean enemyDodgeCalc(Enemy enemy){
        Random r = new Random();
        int Low = 1;
        int High = 10;
        int R = r.nextInt(High-Low) + Low;
        
        return R == 1;
    }
    
    //Enemy critical hit calculation
    
    public static boolean enemyCritCalc(Enemy enemy){
        Random r = new Random();
        int Low = 1;
        int High = 10;
        int R = r.nextInt(High-Low) + Low;
        
        return R == 1;        
    }
    
    // Enemy hit calculation
    
    public static boolean enemyHitCalc(Enemy enemy){
        Random r = new Random();
        int Low = 1;
        int High = 10;
        int R = r.nextInt(High-Low) + Low;
        
        return R != 1 || R != 2 || R != 3;        
    }  
    
    public static void quit(){
        Scanner scan = new Scanner(System.in);
        System.out.println("GAME OVER\nPress any key to exit: ");
        scan.nextLine();
        System.exit(0);
    }

    private static void poisonDmg(Enemy enemy, Player player) {
        enemy.setEnemyHealth(enemy.getEnemyHealth() - 5);
    }
}
