package pdc.project.Controller;

import pdc.project.Model.*;

public class Main {

   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataHolder data = DataHolder.getInstance();
        
        GameTimer gameTimer = new GameTimer();
        gameTimer.startThread();
        data.setTimer(gameTimer);
        try {
            Thread.sleep(0);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        
        int[] curTime = gameTimer.getCurrentTime();
        gameTimer.printCurrentTime(curTime);
        
        // Initiates the database
        data.getDbController().openConnection();
        data.getDbController().createTable();

        // Creates the board and starts the CUI version of the game
        CUIController cui = new CUIController();
        cui.startGame();
        
       // data.getDbController().closeConnection();
    }      
}
