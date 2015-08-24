package pdc.project.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import pdc.project.Model.*;
import java.util.Scanner;
import pdc.project.Model.Player;
/**
 * 
 */
public class CUIController {
    private static final Scanner scan = new Scanner(System.in);
    private static DataHolderSingleton data = DataHolderSingleton.getInstance();
    //method that takes an array of tiles
            //depending on the tiles give options to the user (i.e. move up, move left, etc.)
            //don't show options the user can't take
    /**
     * Returns the commands reachable from the current tile. 
     * Tile[0] = Tile above current position. 
     * Tile[1] = Tile below current position. 
     * Tile[2] = Tile to the right of current position.
     * Tile[3] = Tile to the left of current position. 
     * @param reachableTiles Takes the current reachable tiles.
     * @param board the game board.
     */
    public static void move(Tile[] reachableTiles, Board board){
        
        
        boolean x = true;
        while(x){
            Scanner moveScan = new Scanner(System.in);
        boolean moveUp    =    false;
        boolean moveDown  =    false;
        boolean moveRight =    false;
        boolean moveLeft  =    false;
        if(!(reachableTiles[0] instanceof Blocked)){
            System.out.println("1. Move Up");
            moveUp=true;
        }
        if(!(reachableTiles[1] instanceof Blocked)){
            System.out.println("2. Move Down");
            moveDown=true;
        }
        if(!(reachableTiles[2] instanceof Blocked)){  
            System.out.println("3. Move Right");
            moveRight=true;
        }
        if(!(reachableTiles[3] instanceof Blocked)){
            System.out.println("4. Move Left");
            moveLeft=true;
        }
        int[] position = board.getPosition();
        String ans = moveScan.nextLine();
        if (ans.equals("1") && moveUp){
            board.changePosition(position[0], position[1]-1);
            x=false;
            checkTile(board);
        }else if (ans.equals("2")&& moveDown){
            board.changePosition(position[0], position[1]+1);
            x=false;
            checkTile(board);
        }else if (ans.equals("3") && moveRight){
            board.changePosition(position[0]+1, position[1]);
            x=false;
            checkTile(board);
        }else if (ans.equals("4")&& moveLeft){
            board.changePosition(position[0]-1, position[1]);
            x=false;
            checkTile(board);
        }else if(ans.equalsIgnoreCase("quit")){
            System.out.println("Thanks for playing!");
            scan.close();
            moveScan.close();
            System.exit(0); // -- can be changed later but for now --
            //quitGame
        } else if (ans.equalsIgnoreCase("i")){
            data.getPlayer().showInventory();
        } else if (ans.equalsIgnoreCase("e")){
            data.getPlayer().showEquippedItems();
        } else{
            System.out.println("You cannot move in that direction");
            }
        //System.out.println("Current player position\n x: " + position[0] + "\n y: " + position[1]);
        }
    }

    
    private static void checkTile(Board board){
        int x = board.getPosition()[0];
        int y = board.getPosition()[1];
        
        if (board.getBoard()[x][y] instanceof Challenge){
            Challenge ch = (Challenge) board.getBoard()[x][y];
            System.out.println("A wizard appears before you and says the following:");
            System.out.println(ch.getQuestion().getText());
            ArrayList<TextOutput> answers = new ArrayList<>();
            answers.add(ch.getCorrectAnswer());
            for (TextOutput t : ch.getWrongAnswers())
                answers.add(t);
            
            Collections.shuffle(answers);
            
            int optionNr = 1;
            for (TextOutput a : answers){
                System.out.println(optionNr + ". " + a.getText());
                optionNr++;
            }
             
            try {
                int userAnswer = scan.nextInt();
                if (answers.get(userAnswer-1) instanceof CorrectAnswer){
                    data.getPlayer().challengeReward();
                    System.out.println("The wizard seems pleased with your answer and says Thanks Brah.");
                    System.out.println("You suddenly feel a lot better. Hot damn.");
                }
                else {
                    System.out.println("The wizard gives you the finger and says byesies.");
                }
            } 
            catch (InputMismatchException e){
                System.err.println(e + "Input was not valid, the wizard is unsatisfied");
                scan.next();
            }
            catch (Exception e) {
                System.err.println(e + "Input could not be read, please try again");
            }
            finally {
                board.getBoard()[x][y] = new EmptyTile();
            }
        }
    }
        
    
    public static boolean checkIfSave(){
        boolean x = true;
         while(x){
            System.out.println("Would you like to load a previously saved game? (Y/N)");
            String ans = scan.nextLine();
            if (ans.equalsIgnoreCase("Y")){
                //load game method
                return true;
            } else if(ans.equalsIgnoreCase("N")){
                return false;
            }
            System.out.println("I did not recognise that command");
        }
         return false;
    }
    public Player playerDetails(){
        System.out.println("Totally awesome RPG");
        CUIController.checkIfSave();
        int classType = 0;
        System.out.println("What is your name adventurer?");
        String playerName = scan.nextLine();
        boolean x = true;
        while(x){
            System.out.println("What class would you like to be?");
            System.out.println(" 1. Warrior"
                    + "\n 2. Archer"
                    + "\n 3. Wizard");
            try{
                classType = scan.nextInt();
                if (classType == 1 || classType == 2 || classType == 3){
                    x = false;
                    scan.nextLine();
                } else {
                    System.out.println("I did not recognise that command");
                }
            } catch(InputMismatchException e){
                System.err.println("I did not recognise that command");
                scan.next();
            }
        }
            Player player = createPlayer(playerName, classType);
            System.out.println("Welcome " + player.getName() + " the "+ player.findClass()
        + " to the best RPG ever");
            return player;    
    }
    
    public Player createPlayer(String playerName, int classType){
            if (classType == 1){
                    return new Warrior(playerName, 100, 0, new ArrayList<Item>(), 0, new HashMap<ItemSlot, Item>(), 3.5, 2.5, 1.5);
                }
            if (classType == 2){
                    return new Archer(playerName, 100, 0, new ArrayList<Item>(), 0, new HashMap<ItemSlot, Item>(), 3.5, 2.5, 1.5);
                }
            if (classType == 3){
                    return new Wizard(playerName, 100, 0, new ArrayList<Item>(), 0, new HashMap<ItemSlot, Item>(), 3.5, 2.5, 1.5);
                }
            System.out.println("Sorry I did not recognise that command "
                        + "please try again.");

        return null;
    }
    
    //method that takes a random challenge
            //show options for that challenge
            //call the print method
}
