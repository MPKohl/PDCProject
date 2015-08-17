package pdc.project.View;

import pdc.project.Controller.CUIController;
import pdc.project.Model.Board;
import pdc.project.Model.Player;

/**
 * 
 */
public class CUI {
    public static void startGame(CUIController cuiController, Board board){
        boolean x = true;
        while(x){
            CUIController.move(board.reachableTiles(), board);
            board.printBoard();
        }
    }
        
}
