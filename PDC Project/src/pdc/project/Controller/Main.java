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
        
        data.getDbController().openConnection();
        data.getDbController().createTable();
        
        data.setBoard(new Board());
        CUIController.startGame();
                        
        GameBoardGUI GUI1 = new GameBoardGUI();
        GUI1.show();
        
        data.getDbController().closeConnection();
    }      
}
