package pdc.project.Controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import pdc.project.Model.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import pdc.project.Model.Player;
/**
 * 
 */
public class CUIController {

    Player player;
    
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
     * @param player
     */
    public static void move(Tile[] reachableTiles, Board board, Player player){
        boolean x = true;
        while(x){
        Scanner moveScan = new Scanner(System.in);
        boolean moveUp    =    false;
        boolean moveDown  =    false;
        boolean moveRight =    false;
        boolean moveLeft  =    false;
        if(!(reachableTiles[0] instanceof Blocked)){
            System.out.println("1. Move Up.");
            moveUp=true;
        }
        if(!(reachableTiles[1] instanceof Blocked)){
            System.out.println("2. Move Down.");
            moveDown=true;
        }
        if(!(reachableTiles[2] instanceof Blocked)){  
            System.out.println("3. Move Right.");
            moveRight=true;
        }
        if(!(reachableTiles[3] instanceof Blocked)){
            System.out.println("4. Move Left.");
            moveLeft=true;
        }
        int[] position = board.getPosition();
        String ans = moveScan.nextLine();
        if (ans.equals("1") && moveUp){
            board.changePosition(position[0], position[1]-1);
            x=false;
            checkTile(board, player);
        }else if (ans.equals("2")&& moveDown){
            board.changePosition(position[0], position[1]+1);
            x=false;
            checkTile(board, player);
        }else if (ans.equals("3") && moveRight){
            board.changePosition(position[0]+1, position[1]);
            x=false;
            checkTile(board, player);
        }else if (ans.equals("4")&& moveLeft){
            board.changePosition(position[0]-1, position[1]);
            x=false;
            checkTile(board, player);
        }else if(ans.equalsIgnoreCase("quit")){
            System.out.println("Thanks for playing!");
            scan.close();
            moveScan.close();
            System.exit(0);
        } else if (ans.equalsIgnoreCase("i")){
            data.getPlayer().showInventory();
        } else if (ans.equalsIgnoreCase("e")){
            data.getPlayer().showEquippedItems();
        } else if (ans.equalsIgnoreCase("equip")){
            equipItem(scan);
        } else if (ans.equalsIgnoreCase("help")){
            System.out.println("Type 'i' to open the inventory.");
            System.out.println("Type 'e' to show current equipped items.");
            System.out.println("Type 'quit' to quit the game.");
            System.out.println("Type 'equip' to equip an item from your inventory.");
        } else {
            System.err.println("Please choose one of the given options.");
            }
        //System.out.println("Current player position\n x: " + position[0] + "\n y: " + position[1]);
        }
    }

    private static void equipItem(Scanner scan){
        data.getPlayer().showInventory();
        if (!data.getPlayer().getInventory().isEmpty()){
            System.out.println("Type in the number of the item you want to equip:");
        
            try {
                int input = scan.nextInt();
                data.getPlayer().equipItem(input);
                scan.nextLine();
            } catch (InputMismatchException e){
                System.err.println("Wrong input.");
                scan.nextLine();
            } catch (NullPointerException e){
                System.err.println("Wrong input.");
                scan.nextLine();
            } catch (IndexOutOfBoundsException e){
                System.err.println("Wrong input.");
                scan.next();
            }
        }
        data.getBoard().printBoard();
    }
    
    private static void checkTile(Board board, Player player){
        int x = board.getPosition()[0];
        int y = board.getPosition()[1];
        
        if (board.getBoard()[x][y] instanceof Challenge){
            Challenge ch = (Challenge) board.getBoard()[x][y];
            System.out.println("\nA wizard appears before you in a flash of smoke and poses you the following riddle:");
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
                    System.out.println("\nThe wizard seems pleased with your answer and raises his arms over you before fading away.");
                    System.out.println("You suddenly feel rejuvenated.\n");
                }
                else {
                    System.out.println("\nThe wizard shakes his head and dissapears with a *BANG*!\n");
                }
            } 
            catch (InputMismatchException e){
                System.err.println("\nInput was not valid, the wizard shakes his head and walks away.");
                scan.next();
            }
            catch (IndexOutOfBoundsException e){
                System.err.println("\nInput was not valid, the wizard shakes his head and walks away.");
            }
            catch (Exception e) {
                System.err.println("\nInput could not be read, the wizard shakes his head and walks away.");
            }
            finally {
                board.getBoard()[x][y] = new EmptyTile();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        else if(board.getBoard()[x][y] instanceof Enemy){
            Enemy enemy = (Enemy) board.getBoard()[x][y];

            Combat.combatStart(enemy, player);
            
            board.getBoard()[x][y] = new EmptyTile();
            
        }
    }
        
    
    public static boolean checkIfSave(){
        boolean x = true;
         while(x){
            System.out.println("\nWould you like to load a previously saved game? (Y/N)");
            String ans = scan.nextLine();
            if (ans.equalsIgnoreCase("Y")){
                //load game method
                return true;
            } else if(ans.equalsIgnoreCase("N")){
                return false;
            }
            System.err.println("Please choose either Y or N.");
        }
         return false;
    }
    public Player playerDetails(){
        System.out.println("THE AMAZING ADVENTURE");
        System.out.println("---------------------");
        CUIController.checkIfSave();
        int classType = 0;
        System.out.println("\nWhat is your name adventurer?");
        String playerName = scan.nextLine();
        boolean x = true;
        while(x){
            System.out.println("\nWhat class would you like to be?");
            System.out.println(" 1. Warrior"
                    + "\n 2. Archer"
                    + "\n 3. Wizard");
            try{
                classType = scan.nextInt();
                if (classType == 1 || classType == 2 || classType == 3){
                    x = false;
                    scan.nextLine();
                } else {
                    System.err.println("Please choose either 1, 2 or 3.");
                }
            } catch(InputMismatchException e){
                System.err.println("Please choose either 1, 2 or 3.");
                scan.next();
            }
        }
            Player thePlayer = createPlayer(playerName, classType);
            System.out.println("\nWelcome " + player.getName() + " the "+ player.findClass()
        + " to the best RPG ever");
            System.out.println("Type 'help' at any time to see commands.\n");
            return player;    
    }
    
    
    public Player createPlayer(String playerName, int classType){
            if (classType == 1){
                    player = new Warrior(30,playerName, 100, 0, new ArrayList<Item>(), 0, new HashMap<ItemSlot, Item>(), 90.0, 20.0, 5.0);
                    return player;
                }
            if (classType == 2){
                    player = new Archer(20,playerName, 100, 0, new ArrayList<Item>(), 0, new HashMap<ItemSlot, Item>(), 80.0, 10.0, 30.0);
                    return player;
                }
            if (classType == 3){
                     player = new Wizard(30,playerName, 100, 0, new ArrayList<Item>(), 0, new HashMap<ItemSlot, Item>(), 90.0, 20.0, 5.0);
                    return player;
                }
            System.out.println("Sorry I did not recognise that command "
                        + "please try again.");

        return null;
    }
    

    
    //method that takes a random challenge
            //show options for that challenge
            //call the print method
}
