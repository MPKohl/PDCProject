/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdc.project.Controller;

import pdc.project.Model.Blocked;
import pdc.project.Model.Tile;
import java.util.Scanner;

/**
 *
 * @author MPKohl
 */
public class CUIController {
    private static boolean moveUp;
    private static boolean moveDown;
    private static boolean moveLeft;
    private static boolean moveRight;
    private static Scanner scan = new Scanner(System.in);
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
    public void move(Tile[] options){
        if(!(options[0] instanceof Blocked)){
            moveUp=true;
            System.out.println("1. Move Up");
        }
        if(!(options[1] instanceof Blocked)){
            moveDown=true;
            System.out.println("2. Move Down");
        }
        if(!(options[2] instanceof Blocked)){
            moveRight=true;
            System.out.println("3. Move Right");
        }
        if(!(options[3] instanceof Blocked)){
            moveLeft=true;
            System.out.println("4. Move Left");
        }
        try{
        int ans = scan.nextInt();
            if (ans ==1){
                //moveup
            }
            if (ans ==2){
                //movedown
            }
            if (ans ==3){
                //moveright
            }
            if (ans ==4){
                //moveleft
            }
        } catch(Exception e){
            
        }
        
    }
    //method that takes a random challenge
            //show options for that challenge
            //call the print method
}
