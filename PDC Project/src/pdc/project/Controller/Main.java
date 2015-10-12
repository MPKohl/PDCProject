/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdc.project.Controller;


import pdc.project.Model.*;
import pdc.project.View.*;

/**
 *
 * @author MPKohl
 */
public class Main {

   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataHolderSingleton data = DataHolderSingleton.getInstance();
        GameTimer gameTimer = new GameTimer();
        gameTimer.startThread();
        try {
        Thread.sleep(0);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        int[] curTime = gameTimer.getCurrentTime();
        gameTimer.printCurrentTime(curTime);
        
        //DatabaseController dbController = new DatabaseController();
        //dbController.initialize();
        //dbController.createTable();
        
        data.setBoard(new Board());
        CUIController cuiController = new CUIController();
        data.setPlayer(cuiController.playerDetails());
        data.getBoard().printBoard();
        cuiController.startGame();
        
        
        GameBoardGUI GUI1 = new GameBoardGUI();
        GUI1.show();
    }      
}
