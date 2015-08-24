
package pdc.project.Controller;



import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import pdc.project.Model.Enemy;
import pdc.project.Model.Player;


public class Combat {
    
    //Method to start the combat, show player and enemy stats
    
    public static void combatStart(Enemy enemy, Player player){
        
        System.out.println("\nEnemy: " + enemy.getEnemyName() + "\nEnemy health: " + enemy.getEnemyHealth() + "\n");
        System.out.println("Player health: " + player.getHealth());
        
        playerAttack(enemy, player);
    }
    
    //Main Player attack method
    
    public static void playerAttack(Enemy enemy, Player player){
        
        Scanner scan = new Scanner(System.in);    
    
        boolean x = true;
        while (x){
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
    
    //Main Enemy attack method
    
    public static void enemyAttack(Enemy enemy, Player player){
        Scanner scan = new Scanner(System.in);
        System.out.println("The enemy attacks\n");
        if((!playerDodgeCalc(player)) && (enemyHitCalc(enemy))){
            enemyDamageCalc(enemy, player);
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
}
