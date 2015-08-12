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
    private Tile[][] board = new Tile[5][20];
    //Player position
    private int[] position = new int[2];
    
    
    
    public void changePosition(int changeInX, int changeInY){
        position[0] = changeInX;
        position[1] = changeInY;
    }
    public int[] getPosition(){
        return position;
    }
    public void setPosition(int[] position){
        this.position = position;
    }
    /**
     * Checks whether a specific Tile is reachable. If true, return the Tile. 
     * If false, return a Blocked Tile.
     * @param tileToCheck
     * @return Tile.
     */
    private Tile checkTile(Tile tileToCheck){
        try {
        if (tileToCheck.isReachable())
            return tileToCheck;
        else
            return new Blocked();
        } catch (ArrayIndexOutOfBoundsException e){
            return new Blocked();
        }
    }
    
    /**
     * Returns the tiles reachable from the current tile. If a tile is 
     * unreachable or outside the array, it contains a Blocked tile. 
     * Tile[0] = Tile above current position. 
     * Tile[1] = Tile below current position. 
     * Tile[2] = Tile to the right of current position. 
     * Tile[3] = Tile to the left of current position. 
     * @return Tile[] of tiles surrounding the player.
     */
    public Tile[] reachableTiles(){
        Tile[] reachableTiles = new Tile[4];
        int x = position[0]; //Player x coordinate
        int y = position[1]; //Player y coordinate
        
        Tile upTile = board[x][y-1]; //Tile one above player
        reachableTiles[0] = checkTile(upTile);
        
        Tile downTile = board[x][y+1]; //Tile one below
        reachableTiles[1] = checkTile(downTile);
        
        Tile rightTile = board[x+1][y]; //Tile to the right of player
        reachableTiles[2] = checkTile(rightTile);
        
        Tile leftTile = board[x-1][y]; //Tile to the left of player
        reachableTiles[3] = checkTile(leftTile);
        
        return reachableTiles;
    }
}
