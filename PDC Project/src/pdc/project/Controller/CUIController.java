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
    
    private static Player player = data.getPlayer();
    private static Board board = data.getBoard();
    int[] startTime;
    
    public static void startGame(){
        boolean gameIsRunning = true;
        while(gameIsRunning){
            move(board.reachableTiles());
            player.getCurrentStats();
            board.printBoard();
        }
    }
    
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
    public static void move(Tile[] reachableTiles){
        boolean moveChosen = false;
        
        while(!moveChosen){
            
            Scanner moveScan = new Scanner(System.in);
            boolean moveUp    =    false;
            boolean moveDown  =    false;
            boolean moveRight =    false;
            boolean moveLeft  =    false;
            int[] position = board.getPosition();
            
            if(!(reachableTiles[0].getType() == TileType.BLOCKED)){
                System.out.println("1. Move Up.");
                moveUp=true;
            }
            if(!(reachableTiles[1].getType() == TileType.BLOCKED)){
                System.out.println("2. Move Down.");
                moveDown=true;
            }
            if(!(reachableTiles[2].getType() == TileType.BLOCKED)){  
                System.out.println("3. Move Right.");
                moveRight=true;
            }
            if(!(reachableTiles[3].getType() == TileType.BLOCKED)){
                System.out.println("4. Move Left.");
                moveLeft=true;
            }
            
            String answer = moveScan.nextLine();
            answer = answer.trim();
            if (answer.equals("1") && moveUp){
                board.changePosition(position[0], position[1]-1);
                moveChosen=true;
                checkTile(board, player);
            } else if (answer.equals("2")&& moveDown){
                board.changePosition(position[0], position[1]+1);
                moveChosen=true;
                checkTile(board, player);
            } else if (answer.equals("3") && moveRight){
                board.changePosition(position[0]+1, position[1]);
                moveChosen=true;
                checkTile(board, player);
            } else if (answer.equals("4")&& moveLeft){
                board.changePosition(position[0]-1, position[1]);
                moveChosen=true;
                checkTile(board, player);
            } else if(answer.equalsIgnoreCase("quit")){
                System.out.println("Thanks for playing!");
                scan.close();
                moveScan.close();
                System.exit(0);
            } else if (answer.equalsIgnoreCase("i")){
                data.getPlayer().showInventory();
            } else if (answer.equalsIgnoreCase("e")){
                data.getPlayer().showEquippedItems();
            } else if (answer.equalsIgnoreCase("equip")){
                equipItem(scan);
            } else if (answer.equalsIgnoreCase("cmds")){
                printCommands();
            } else if (answer.equalsIgnoreCase("help")){
                printHelp();
            } else if (answer.equalsIgnoreCase("thereisnospoon")) {
                player.setHealth(1000000000);
            } else {
                System.err.println("Please choose one of the given options.");
            }
        }
    }
    
    private static void printCommands(){
        System.out.println("Type 'i' to open the inventory.");
        System.out.println("Type 'e' to show current equipped items.");
        System.out.println("Type 'equip' to equip an item from your inventory.");
        System.out.println("Type 'help' to view the help screen");
        System.out.println("Type 'quit' to quit the game.");
    }
    
    private static void printHelp(){
        System.out.println("\nThis is a turn based RPG game."
                         + "\nYour player is the 'P' on the map."
                         + "\nType 'cmds' at any time to view useful commands to help you complete the game"
                         + "\n'C' on the map is a challenge, move into the challenge to complete it"
                         + "\nIf you complete a challenge your health will be restored and you will gain experiece points and score"
                         + "\nThroughout your travels your player will run into spooky monsters"
                         + "\nIf you manage to defeat these monsters you will be rewarded with a random item, updated score and experiecnce points."
                         + "\n'X' on the map is a blocked square, you cannot move into these squares."
                         + "\nHave fun!\n");
    }

    private static void equipItem(Scanner scan){
        data.getPlayer().showInventory();
        if (!data.getPlayer().getInventory().isEmpty()){
            System.out.println("Type in the number of the item you want to equip:");
        
            try {
                int input = scan.nextInt();
                data.getPlayer().equipItem(input);
                scan.nextLine();
            } catch (InputMismatchException | NullPointerException e){
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
        Tile tile = board.getBoard()[x][y];
        
        if (tile.getType() == TileType.CHALLENGE){
            poseChallenge(board, player, x, y);
        }
        else if(tile.getType() == TileType.ENEMY){
            Enemy enemy = (Enemy) board.getBoard()[x][y];

            Combat.combatStart(enemy, player);
            
            
            board.getBoard()[x][y] = new EmptyTile();
            
            Item itemRewarded = data.getPlayer().enemyReward();
            System.out.println("\nAt your feet a " + itemRewarded.getName() + " appears! You pick it up and put it in your Inventory");
        }
        else if(tile.getType() == TileType.BOSS){
            Boss enemy = (Boss) board.getBoard()[x][y];
            Combat.combatStart(enemy, player);
            finishGame();
            }
    }
    
    private static void poseChallenge(Board board, Player player, int x, int y){
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
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
    public static void playAgain(){
        boolean correctInput = false;
        while(!correctInput){
            String input = scan.nextLine();
            input = input.trim();
            if(input.equalsIgnoreCase("y")){
                //play again
                correctInput=true;
            } else if(input.equalsIgnoreCase("n")){
                System.exit(0);
            }
            else
                System.out.println("Sorry I did not recognise that command");
        }
    }
        
    public static void finishGame(){
        data.getPlayer().bossReward();
        System.out.println("You have completed the game! Well done!");
        data.getPlayer().getCurrentStats();
        //data.getPlayer().timerReward(startTime);
        //update high scores
        System.out.println("Would you like to play again?");
        playAgain();        
    }
    

    
    public Player playerDetails(){
        System.out.println("THE AMAZING ADVENTURE");
        System.out.println("---------------------");
        int classType = 0;
        System.out.println("\nWhat is your name adventurer?");
        String playerName = scan.nextLine();
        boolean correctInput = false;
        while(!correctInput){
            System.out.println("\nWhat class would you like to be?");
            System.out.println(" 1. Warrior"
                           + "\n 2. Archer"
                           + "\n 3. Wizard");
            try{
                classType = scan.nextInt();
                if (classType == 1 || classType == 2 || classType == 3){
                    correctInput = true;
                    scan.nextLine();
                } else {
                    System.err.println("Please choose either 1, 2 or 3.");
                }
            } catch(InputMismatchException e){
                System.err.println("Please choose either 1, 2 or 3.");
                scan.next();
            }
        }
        Player player = createPlayer(playerName, classType);
        
        System.out.println("\nWelcome " + player.getName() + " the "+ player.findClass()
        + " to the best RPG ever");
        System.out.println("Type 'help' at any time to get help.\n");
        //startTime = data.getTimer().getCurrentTime();
        return player;
    }
    
    
    public Player createPlayer(String playerName, int classType){
            if (classType == 1){
                    player = new Warrior(30,playerName, 100, 0, new ArrayList<Item>(), 0.0, new HashMap<ItemSlot, Item>(), 90.0, 20.0, 5.0, false, false);
                    return player;
                }
            if (classType == 2){
                    player = new Archer(20,playerName, 100, 0, new ArrayList<Item>(), 0.0, new HashMap<ItemSlot, Item>(), 80.0, 10.0, 30.0, false, false);
                    return player;
                }
            if (classType == 3){
                     player = new Wizard(30,playerName, 100, 0, new ArrayList<Item>(), 0.0, new HashMap<ItemSlot, Item>(), 90.0, 20.0, 5.0, false, false);
                    return player;
                }
            System.out.println("Sorry I did not recognise that command "
                        + "please try again.");

        return null;
    }
}
