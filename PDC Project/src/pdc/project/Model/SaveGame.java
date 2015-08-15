package pdc.project.Model;

import java.util.ArrayList;

/**
 * Contains all the information to be saved.
 */
public class SaveGame {
    String playerName;
    Board board;
    ArrayList<Item> inventory;
    ArrayList<Item> equipped;
    Timer timer;    
}
