/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdc.project.Controller;

import java.util.InputMismatchException;
import pdc.project.Model.Blocked;
import pdc.project.Model.Tile;
import java.util.Scanner;
import pdc.project.Model.Archer;
import pdc.project.Model.Board;
import pdc.project.Model.Player;
import pdc.project.Model.Warrior;
import pdc.project.Model.Wizard;

/**
 *
 * @author MPKohl
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
     */
    public static void move(){
        Tile[] reachableTiles = board.reachableTiles();
        if(!(reachableTiles[0] instanceof Blocked)){
            System.out.println("1. Move Up");
        }
        if(!(reachableTiles[1] instanceof Blocked)){
            System.out.println("2. Move Down");
        }
        if(!(reachableTiles[2] instanceof Blocked)){  
            System.out.println("3. Move Right");
        }
        if(!(reachableTiles[3] instanceof Blocked)){
            System.out.println("4. Move Left");
        }
        try{
        int ans = scan.nextInt();
        int[] position = board.getPosition();
            if (ans ==1){
               board.changePosition(position[0], position[1]+1);
            }
            if (ans ==2){
               board.changePosition(position[0], position[0]-1);
            }
            if (ans ==3){
               board.changePosition(position[0]+1, position[1]);
            }
            if (ans ==4){
               board.changePosition(position[0]-1, position[1]);
            }
            System.out.println("x: " + position[0] + " y: " + position[1]);
        } catch(Exception e){
            
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
    public static Player playerDetails(){
        int classType = 0;
        //board.changePosition(0,0);
        System.out.println("What is your name adventurer?");
        String playerName = scan.nextLine();
        System.out.println("What class would you like to be?");
        while(classType != 1 || classType != 2 || classType != 3){
            System.out.println("1. Warrior"
                    + "\n 2.Archer"
                    + "\n 3.Wizard");
            try{
                classType = scan.nextInt();
            } catch(InputMismatchException e){
                scan.next();
            }
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
