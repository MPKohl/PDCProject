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
public class Board {
    //Double sided array of tiles
    private Tile[][] board = new Tile[20][4];   //Not sure if this is right? -b
    //Player position
    private int[] position;
    
    //Method - boolean isReachable()
    public boolean isReachable(int[] position){
        return true;
    }
}
