package pdc.project.View;

import pdc.project.Controller.CUIController;
import pdc.project.Model.Board;
import pdc.project.Model.Player;

/**
 * 
 */
public class CUI {
    public static void startGame(){
        System.out.println("Totally awesome RPG");
        CUIController.checkIfSave();
        Player player = CUIController.playerDetails();
        System.out.println("Welcome " + player.getName() + " the "+ player.findClass()
        + " to ...");
        CUIController.move();
    }
}
