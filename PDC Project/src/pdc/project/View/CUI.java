/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdc.project.View;

import pdc.project.Controller.CUIController;
import pdc.project.Model.Board;
import pdc.project.Model.Player;

/**
 *
 * @author MPKohl
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
