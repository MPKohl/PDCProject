package pdc.project.Model;

import pdc.project.Controller.DatabaseController;

/**
 * Singleton that holds the data of the game to ensure that no duplicates are created.
 */
public class DataHolderSingleton {

    /**
     * @return the dataHolder
     */
    public static DataHolderSingleton getDataHolder() {
        return dataHolder;
    }

    /**
     * @param aDataHolder the dataHolder to set
     */
    public static void setDataHolder(DataHolderSingleton aDataHolder) {
        dataHolder = aDataHolder;
    }
    
    private Board board;
    private Player player;
    private Challenge challenge;
    private GameTimer timer;
    private DatabaseController dbController = new DatabaseController();
    //need to talk about what instance variables this needs.
   
    private static DataHolderSingleton dataHolder = new DataHolderSingleton( );
   
    private DataHolderSingleton(){ }  //private constructor so it can never be intitliased.

    /**
     * Returns the only instance of the Singleton
     * @return Returns the Singleton with the game data
     */
    public static DataHolderSingleton getInstance( ) {
       return getDataHolder();
    }
   
    /**
     * @param board the Board to set
     */
    public void setBoard(Board board ) {
       this.board = board;
    }

    /**
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * @return the challenge
     */
    public Challenge getChallenge() {
        return challenge;
    }

    /**
     * @param challenge the challenge to set
     */
    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    /**
     * @return the timer
     */
    public GameTimer getTimer() {
        return timer;
    }

    /**
     * @param timer the timer to set
     */
    public void setTimer(GameTimer timer) {
        this.timer = timer;
    }

    /**
     * @return the dbController
     */
    public DatabaseController getDbController() {
        return dbController;
    }

    /**
     * @param dbController the dbController to set
     */
    public void setDbController(DatabaseController dbController) {
        this.dbController = dbController;
    }
    
}    
