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
    private Tile[][] board = new Tile[5][20];   //Not sure if this is right? -b
    //Player position
    private int[] position = new int[2];
    
    public Board(){
        position[0] = 2;
        position[1] = 19;
        
        for (int i = 0 ; i < board.length ; i++){
            for (int j = 0 ; j < board[0].length ; j++){
                Challenge tile = new Challenge();
                board[i][j] = tile;
            }
        }
    }
    
    public void changePosition(int newX, int newY){
        position[0] = newX;
        position[1] = newY;
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
        
        try {
        Tile upTile = board[x][y-1]; //Tile one above player
        reachableTiles[0] = checkTile(upTile);
        } catch (ArrayIndexOutOfBoundsException e) {
            reachableTiles[0] = new Blocked();
        }
        
        try {
        Tile downTile = board[x][y+1]; //Tile one below
        reachableTiles[1] = checkTile(downTile);
        } catch (ArrayIndexOutOfBoundsException e) {
            reachableTiles[1] = new Blocked();
        }
        
        try {
        Tile rightTile = board[x+1][y]; //Tile to the right of player
        reachableTiles[2] = checkTile(rightTile);
        } catch (ArrayIndexOutOfBoundsException e) {
            reachableTiles[2] = new Blocked();
        }

        try {
        Tile leftTile = board[x-1][y]; //Tile to the left of player
        reachableTiles[3] = checkTile(leftTile);
        } catch (ArrayIndexOutOfBoundsException e) {
            reachableTiles[3] = new Blocked();
        }

        return reachableTiles;
    }
    
    /**
     * Prints the board to the console.
     * Blank fields are challenges or enemies.
     * Crosses are unreachable/blocked tiles.
     * P is the player location.
     * O are visited tiles.
     */
    public void printBoard(){
        printLine();
        for (int i = 0 ; i < board[0].length ; i++){
            for (int j = 0 ; j < board.length ; j++){
                if (position[0] == j && position[1] == i)
                    System.out.print("| P ");
                else if (board[j][i].isVisited)
                    System.out.print("| O ");
                else if (board[j][i].type == TileType.BLOCKED)
                    System.out.print("| X ");
                else
                    System.out.print("|   ");
            }
            System.out.print("|");
            System.out.println("");
            printLine();
        }
    }
    
    /**
     * Prints the lines between the board arrays.
     */
    private void printLine(){
        System.out.print("+");
        for (int i = 0 ; i < board.length * 4 - 1 ; i++)
            System.out.print("-");
        System.out.print("+");
        System.out.println("");
    }
}
