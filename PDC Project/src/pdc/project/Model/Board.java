package pdc.project.Model;

/**
 *
 * @author MPKohl
 */
public class Board {
    //Double sided array of tiles
    private Tile[][] board = new Tile[5][12];
    //Player position
    private int[] position = new int[2];
    
    public Board(){
        position[0] = 2;
        position[1] = 11;
        ChallengeFactory challengeFactory = new ChallengeFactory();
        
        board[0][11] = new EmptyTile();
        board[1][11] = new Blocked();
        board[2][11] = new EmptyTile();
        board[3][11] = new Blocked();
        board[4][11] = new EmptyTile();
        
        board[0][10] = new Blocked();
        board[1][10] = new Enemy();
        board[2][10] = new EmptyTile();
        board[3][10] = challengeFactory.getRandomChallenge();
        board[4][10] = new Blocked();
        
        board[0][9] = challengeFactory.getRandomChallenge();
        board[1][9] = new EmptyTile();
        board[2][9] = new Blocked();
        board[3][9] = new Blocked();
        board[4][9] = challengeFactory.getRandomChallenge();
        
        board[0][8] = new Blocked();
        board[1][8] = new Enemy();
        board[2][8] = new EmptyTile();
        board[3][8] = new Blocked();
        board[4][8] = new EmptyTile();
        
        board[0][7] = challengeFactory.getRandomChallenge();
        board[1][7] = new EmptyTile();
        board[2][7] = new EmptyTile();
        board[3][7] = new Enemy();
        board[4][7] = new EmptyTile();
        
        board[0][6] = new Blocked();
        board[1][6] = new Blocked();
        board[2][6] = new Blocked();
        board[3][6] = new Blocked();
        board[4][6] = new EmptyTile();
        
        board[0][5] = challengeFactory.getRandomChallenge();
        board[1][5] = new Blocked();
        board[2][5] = new EmptyTile();
        board[3][5] = new Enemy();
        board[4][5] = new EmptyTile();
        
        board[0][4] = new EmptyTile();
        board[1][4] = new Blocked();
        board[2][4] = new Enemy();
        board[3][4] = new Blocked();
        board[4][4] = challengeFactory.getRandomChallenge();
        
        board[0][3] = new EmptyTile();
        board[1][3] = new Enemy();
        board[2][3] = new EmptyTile();
        board[3][3] = new EmptyTile();
        board[4][3] = new Blocked();
        
        board[0][2] = challengeFactory.getRandomChallenge();
        board[1][2] = new Blocked();
        board[2][2] = challengeFactory.getRandomChallenge();
        board[3][2] = new EmptyTile();
        board[4][2] = challengeFactory.getRandomChallenge();
        
        board[0][1] = new Blocked();
        board[1][1] = new Blocked();
        board[2][1] = new Blocked();
        board[3][1] = new Enemy();
        board[4][1] = new Blocked();
        
        board[0][0] = new Blocked();
        board[1][0] = new Boss();
        board[2][0] = new EmptyTile();
        board[3][0] = new EmptyTile();
        board[4][0] = challengeFactory.getRandomChallenge();
    }
    
    public void changePosition(int newX, int newY){
        getBoard()[position[0]][position[1]].visit();
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
        Tile upTile = getBoard()[x][y-1]; //Tile one above player
        reachableTiles[0] = checkTile(upTile);
        } catch (ArrayIndexOutOfBoundsException e) {
            reachableTiles[0] = new Blocked();
        }
        
        try {
        Tile downTile = getBoard()[x][y+1]; //Tile one below
        reachableTiles[1] = checkTile(downTile);
        } catch (ArrayIndexOutOfBoundsException e) {
            reachableTiles[1] = new Blocked();
        }
        
        try {
        Tile rightTile = getBoard()[x+1][y]; //Tile to the right of player
        reachableTiles[2] = checkTile(rightTile);
        } catch (ArrayIndexOutOfBoundsException e) {
            reachableTiles[2] = new Blocked();
        }

        try {
        Tile leftTile = getBoard()[x-1][y]; //Tile to the left of player
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
        for (int i = 0 ; i < getBoard()[0].length ; i++){
            for (int j = 0 ; j < getBoard().length ; j++){
                if (position[0] == j && position[1] == i)
                    System.out.print("| P ");
                else if (getBoard()[j][i].isVisited)
                    System.out.print("| O ");
                else if (getBoard()[j][i].type == TileType.BLOCKED)
                    System.out.print("| X ");
                else if (getBoard()[j][i].type == TileType.CHALLENGE)
                    System.out.print("| C ");
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
        for (int i = 0 ; i < getBoard().length * 4 - 1 ; i++)
            System.out.print("-");
        System.out.print("+");
        System.out.println("");
    }

    /**
     * @return the board
     */
    public Tile[][] getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(Tile[][] board) {
        this.board = board;
    }
}
