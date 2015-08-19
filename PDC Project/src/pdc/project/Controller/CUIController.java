package pdc.project.Controller;

import java.util.InputMismatchException;
import pdc.project.Model.*;
import java.util.Scanner;
import pdc.project.Model.Player;
import pdc.project.View.CUI;

/**
 * 
 */
public class CUIController {
    private static Scanner scan = new Scanner(System.in);
    private static Board board;
    //method that takes an array of tiles
            //depending on the tiles give options to the user (i.e. move up, move left, etc.)
            //don't show options the user can't take
    /**
     * Returns the commands reachable from the current tile. 
     * Tile[0] = Tile above current position. 
     * Tile[1] = Tile below current position. 
     * Tile[2] = Tile to the right of current position.
     * Tile[3] = Tile to the left of current position. 
     * @param reachableTiles Takes the current reachable tiles.
     * @param board the game board.
     */
    public static void move(Tile[] reachableTiles, Board board){
        boolean x = true;
            while(x){
            boolean moveUp = false;
            boolean moveDown =  false;
            boolean moveRight = false;
            boolean moveLeft = false;
            if(!(reachableTiles[0] instanceof Blocked)){
                System.out.println("1. Move Up");
                moveUp=true;
            }
            if(!(reachableTiles[1] instanceof Blocked)){
                System.out.println("2. Move Down");
                moveDown=true;
            }
            if(!(reachableTiles[2] instanceof Blocked)){  
                System.out.println("3. Move Right");
                moveRight=true;
            }
            if(!(reachableTiles[3] instanceof Blocked)){
                System.out.println("4. Move Left");
                moveLeft=true;
            }
            int[] position = board.getPosition();
            try{
            int ans = scan.nextInt();

                if (ans ==1 && moveUp){
                   board.changePosition(position[0], position[1]-1);
                   x=false;
                }
                else if (ans ==2 && moveDown){
                   board.changePosition(position[0], position[1]+1);
                   x=false;
                }
                else if (ans ==3 && moveRight){
                   board.changePosition(position[0]+1, position[1]);
                   x=false;
                }
                else if (ans ==4 && moveLeft){
                   board.changePosition(position[0]-1, position[1]);
                   x=false;
                } else {
                    System.out.println("You cannot move in that direction.");
                }
            } catch(Exception e){
                String quitCheck = scan.nextLine();
                if(quitCheck.equalsIgnoreCase("quit")){
                    System.out.println("Thanks for playing!");
                    System.exit(0); // -- can be changed later but for now --
                    //quitGame
                } else {
                    System.out.println("I did not recogonise that command");
                }
                scan.next();
            }
            System.out.println("Current player position\n x: " + position[0] + "\n y: " + position[1]);
        }
    }
    public static boolean checkIfSave(){
        boolean x = true;
         while(x){
            System.out.println("Would you like to load a previously saved game? (Y/N)");
            String ans = scan.nextLine();
            if (ans.equalsIgnoreCase("Y")){
                //load game method
                return true;
            } else if(ans.equalsIgnoreCase("N")){
                return false;
            }
            System.out.println("I did not recognise that command");
        }
         return false;
    }
    public Player playerDetails(){
        System.out.println("Totally awesome RPG");
        CUIController.checkIfSave();
        int classType = 0;
        System.out.println("What is your name adventurer?");
        String playerName = scan.nextLine();
        System.out.println("What class would you like to be?");
        boolean x = true;
        while(x){
            System.out.println(" 1. Warrior"
                    + "\n 2. Archer"
                    + "\n 3. Wizard");
            try{
                classType = scan.nextInt();
                x = false;
            } catch(InputMismatchException e){
                scan.next();
            }
        }
            Player player = createPlayer(playerName, classType);
            System.out.println("Welcome " + player.getName() + " the "+ player.findClass()
        + " to the best RPG ever");
            return player;

        
    }
    
    public Player createPlayer(String playerName, int classType){
        boolean x = true;
        while(x){
            if (classType == 1){
                    return new Warrior(playerName, 100, 0, null, 0, null, 3.5, 2.5, 1.5);
                }
            if (classType == 2){
                    return new Archer(playerName, 100, 0, null, 0, null, 3.5, 2.5, 1.5);
                }
            if (classType == 3){
                    return new Wizard(playerName, 100, 0, null, 0, null, 3.5, 2.5, 1.5);
                }
            System.out.println("Sorry I did not recognise that command "
                        + "please try again.");

            }
        return null;
    }
        

        
        
    
    //method that takes a random challenge
            //show options for that challenge
            //call the print method
}
