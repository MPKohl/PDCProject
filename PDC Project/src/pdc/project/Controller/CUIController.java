package pdc.project.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import pdc.project.Model.*;
import java.util.Scanner;
/**
 * The CUIController controls the game mechanics for the CUI version. 
 */
public class CUIController {

    private static final Scanner scan = new Scanner(System.in);
    private static DataHolder data = DataHolder.getInstance();
    int[] startTime;
    
    /**
     * Starts the game and keeps it running until the player quits or finishes the game.
     */
    public void startGame(){
        //Creates the gameboard
        data.setBoard(new Board());
        
        System.out.println("\n---------------------------" + 
                           "\n-- THE AMAZING ADVENTURE --" + 
                           "\n---------------------------");
        
        // Initialises the player and saves it in the singleton
        data.setPlayer(playerDetails());
        
        System.out.println("\nWelcome " + data.getPlayer().getName() + " to the best RPG ever!");
        System.out.println("Type 'help' to get help.\n");
        
        data.getBoard().printBoard();
        
        boolean gameIsRunning = true;
        while(gameIsRunning){
            move(data.getBoard().reachableTiles());
            printCurrentStats();
            data.getBoard().printBoard();
        }
    }
    
    /**
     * Returns the commands reachable from the current tile. 
     * Tile[0] = Tile above current position. 
     * Tile[1] = Tile below current position. 
     * Tile[2] = Tile to the right of current position.
     * Tile[3] = Tile to the left of current position. 
     * @param reachableTiles Takes the current reachable tiles in an array.
     */
    public void move(Tile[] reachableTiles){
        boolean moveChosen = false;
        
        while(!moveChosen){
            
            Scanner moveScan = new Scanner(System.in);
            boolean moveUp    =    false;
            boolean moveDown  =    false;
            boolean moveRight =    false;
            boolean moveLeft  =    false;
            int[] position = data.getBoard().getPosition();
            
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
                data.getBoard().changePosition(position[0], position[1]-1);
                moveChosen=true;
                checkCurrentTile();
                
            } else if (answer.equals("2")&& moveDown){
                data.getBoard().changePosition(position[0], position[1]+1);
                moveChosen=true;
                checkCurrentTile();
                
            } else if (answer.equals("3") && moveRight){
                data.getBoard().changePosition(position[0]+1, position[1]);
                moveChosen=true;
                checkCurrentTile();
                
            } else if (answer.equals("4")&& moveLeft){
                data.getBoard().changePosition(position[0]-1, position[1]);
                moveChosen=true;
                checkCurrentTile();
                
            } else if(answer.equalsIgnoreCase("quit")){
                System.out.println("\nThanks for playing!");
                saveHighscore();
                
                scan.close();
                moveScan.close();
                
                System.exit(0);
                
            } else if (answer.equalsIgnoreCase("i")){
                printInventory();
            } else if (answer.equalsIgnoreCase("e")){
                printEquippedItems();             
            } else if (answer.equalsIgnoreCase("equip")){
                equipItem(scan);
            } else if (answer.equalsIgnoreCase("cmds")){
                printCommands();
            } else if (answer.equalsIgnoreCase("help")){
                printHelp();
            } else if (answer.equalsIgnoreCase("thereisnospoon")) {
                // Cheat code for testing purposes
                data.getPlayer().setHealth(1000000000);
                data.getPlayer().setLvl(200);
            } else if (answer.equalsIgnoreCase("highscores")){
                printHighscores();
            } else if (answer.equalsIgnoreCase("save")){
                saveHighscore();
            } else if (answer.equalsIgnoreCase("clear")){
                clearHighscores();
            } else {
                System.out.println("Please choose one of the given options.");
            }
        }
    }
    
    /**
     * Prints the commands for the game to the console.
     */
    private static void printCommands(){
        System.out.println("\nType 'i' to open the inventory."
                         + "\nType 'e' to show current equipped items."
                         + "\nType 'equip' to equip an item from your inventory."
                         + "\nType 'help' to view the help screen"
                         + "\nType 'highscores' to view the highscores"
                         + "\nType 'save' to save your score"
                         + "\nType 'clear' to clear highscores."
                         + "\nType 'quit' to quit the game.\n");
    }
    
    /**
     * Prints a help paragraph to the console.
     */
    private static void printHelp(){
        System.out.println("\nThis is a turn based RPG game."
                         + "\nYour player is the 'P' on the map."
                         + "\nType 'cmds' to view useful commands to help you complete the game"
                         + "\n'C' on the map is a challenge, move into the challenge to complete it"
                         + "\nIf you complete a challenge your health will be restored and you will gain experiece points and score"
                         + "\nThroughout your travels your player will run into spooky monsters"
                         + "\nIf you manage to defeat these monsters you will be rewarded with a random item, updated score and experiecnce points."
                         + "\n'X' on the map is a blocked square, you cannot move into these squares."
                         + "\nRemember to equip items after combat!"
                         + "\nHave fun!\n");
    }
    
    /**
     * Prints the highscores from the database in order of highest score to the console.
     */
    private static void printHighscores(){
        System.out.println("\nHIGHSCORES:");
        for (String score : data.getDbController().getHighscores()){
            System.out.println(score);
        }
        System.out.println("");
    }
    
    /**
     * Saves the the current score in the database.
     */
    private static void saveHighscore(){
        if (data.getDbController().updateHighscores()){
            System.out.println("\nHighscore saved succesfully.\n");
        } else {
            System.out.println("\nERROR: Highscore not saved.\n");
        }
    }
    
    /**
     * Prints out the Player's inventory as a numbered list.
     */
    private void printInventory(){
        if (data.getPlayer().getInventory().isEmpty()){
            System.out.println("Inventory is empty.");
        }
        try {
            printOutItemList(data.getPlayer().getInventory());
        } catch (NullPointerException e) {
            System.out.println("Inventory is empty.");
        }
    }
    
    /**
     * Prints out the Player's equipment as numbered list.
     */
    public void printEquippedItems(){
        if (data.getPlayer().getEquipped().isEmpty()){
            System.out.println("No items equipped.");
        }
        try {
            printOutItemList(data.getPlayer().getEquipped().values());
        } catch (NullPointerException e) {
            System.out.println("No items equipped.");
        }
    }
    
    /**
     * Prints out the given Collection of Items.
     * @param list Collection<Item> of Items
     */
    private void printOutItemList(Collection<Item> list){
        int i = 1;
        for (Item item : list) {
                System.out.print(i + ". " + item.getName());
                // If Item is a piece of armour, print it's name and damage reduction
                if (item.getItemType() == ItemType.CLOTHARMOUR || item.getItemType() == ItemType.LEATHERARMOUR || item.getItemType() == ItemType.PLATEARMOUR || item.getItemType() == ItemType.SHIELD)
                    System.out.println(" - Damage reduction: " + item.getDmgReduction() + "%");
                
                // If Item is a weapon, print it's name and damage increase
                else if (item.getItemType() == ItemType.BOW || item.getItemType() == ItemType.ONEHANDEDWEAPON || item.getItemType() == ItemType.TWOHANDEDWEAPON)
                    System.out.println(" - Damage increase: " + item.getDmg() + "%");
                i++;
            }
    }
    
    private void printCurrentStats(){
        System.out.println("\nHealth: " + data.getPlayer().getHealth() + " Level: " + data.getPlayer().getLvl() +  " exp: " + data.getPlayer().getExp() + " Score: " + data.getPlayer().getScore());
    }
    
    /**
     * Deletes all highscores.
     */
    private static void clearHighscores(){
        data.getDbController().clearHighscores();
        System.out.println("\nHighscores cleared.\n");
    }

    /**
     * Prints the inventory and gives the player an option to choose which
     * item to equip by writing the corresponding number.
     * @param scan Scanner that scans for user input
     */
    private void equipItem(Scanner scan){
        // Prints the inventory
        printInventory();
        if (!data.getPlayer().getInventory().isEmpty()){
            System.out.println("\nType in the number of the item you want to equip:");
        
            try {
                int input = scan.nextInt();
                data.getPlayer().equipItem(input, true);
                scan.nextLine();
            } catch (InputMismatchException | NullPointerException e){
                System.out.println("\nWrong input.");
                scan.nextLine();
            } catch (IndexOutOfBoundsException e){
                System.out.println("\nWrong input.");
                scan.next();
            }
        }
        data.getBoard().printBoard();
    }
    
    /**
     * Checks what Tile the player is currently on and executes the correct sequence
     * for that Tile.
     */
    private void checkCurrentTile(){
        int x = data.getBoard().getPosition()[0];
        int y = data.getBoard().getPosition()[1];
        Tile tile = data.getBoard().getBoard()[x][y];
        
        // If the Tile is a challenge, execute the challenge
        if (tile.getType() == TileType.CHALLENGE){
            poseChallenge(x, y);
        }
        
        // If the Tile is an enemy, execute the combat sequence
        else if(tile.getType() == TileType.ENEMY){
            Enemy enemy = (Enemy) data.getBoard().getBoard()[x][y];

            Combat.combatStart(enemy, data.getPlayer());
            
            // Inserts an empty Tile after combat is done
            data.getBoard().getBoard()[x][y] = new EmptyTile();
            
            Item itemRewarded = data.getPlayer().enemyReward();
            System.out.println("\nAt your feet a " + itemRewarded.getName() + " appears! You pick it up and put it in your Inventory.");
        }
        
        // If the Tile is the final boss, execute combat sequence and end game afterwards
        else if(tile.getType() == TileType.BOSS){
            Boss enemy = (Boss) data.getBoard().getBoard()[x][y];
            Combat.combatStart(enemy, data.getPlayer());
            finishGame();
        }
    }
    
    /**
     * Poses the player a riddle with one correct answer and several wrong
     * answers that are shuffled randomly.
     * @param x Position of player on x-axis of board.
     * @param y Position of player on y-axis of board.
     */
    private static void poseChallenge(int x, int y){
        Challenge ch = (Challenge) data.getBoard().getBoard()[x][y];
        
        System.out.println("\nA wizard appears before you in a flash of smoke and poses you the following riddle:");
        
        // Prints the riddle
        System.out.println(ch.getQuestion().getText());
        
        // Make a list of all possible answers and shuffle them
        ArrayList<TextOutput> answers = new ArrayList<>();
        answers.add(ch.getCorrectAnswer());
        for (TextOutput t : ch.getWrongAnswers())
            answers.add(t);
        Collections.shuffle(answers);
            
        // Prints all the options with a number for each answer
        int optionNr = 1;
        for (TextOutput a : answers){
            System.out.println(optionNr + ". " + a.getText());
            optionNr++;
        }
            
        // Try/catch that handles the users input and rewards the player for a correct answer
        // All wrong answers result in no reward and a termination of the challenge sequence
        try {
            int userAnswer = scan.nextInt();
            if (answers.get(userAnswer-1) instanceof CorrectAnswer){
                data.getPlayer().challengeReward();
                System.out.println("\nThe wizard seems pleased with your answer and raises his arms over you before fading away." +
                                   "\nYou suddenly feel rejuvenated.\n");
            }
            else {
                System.out.println("\nThe wizard shakes his head and dissapears with a *BANG*!\n");
            }
        }
        catch (InputMismatchException e){
            System.out.println("\nInput was not valid, the wizard shakes his head and walks away.");
            scan.next();
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("\nInput was not valid, the wizard shakes his head and walks away.");
        }
        catch (Exception e) {
            System.out.println("\nInput could not be read, the wizard shakes his head and walks away.");
        }
        finally {
            //Empties the Tile so the Challenge can't be trigered again
            data.getBoard().getBoard()[x][y] = new EmptyTile();
            try {
                //Pause for effect
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    /**
     * Gives the player the option to play again.
     */
    public void playAgain(){
        boolean correctInput = false;
        
        System.out.println("Would you like to play again? (y/n)");
        
        while(!correctInput){
            String input = scan.nextLine();
            input = input.trim();
            if(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")){
                // Play again
                startGame();
                correctInput=true;
            } else if(input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")){
                System.exit(0);
            }
            else
                System.out.println("Please choose either y for yes or n for no.");
        }
    }
    
    /**
     * Rewards the player for finishing the game and gives him/her the option to play again
     */
    public void finishGame(){
        data.getPlayer().bossReward();
        System.out.println("You have completed the game! Well done!");
        printCurrentStats();
        data.getPlayer().timerReward(startTime);
        
        saveHighscore();
        
        // Gives the player the option to play again
        playAgain();        
    }
    
    /**
     * Enables the user to choose a name and a class. Returns the Player object created.
     * @return Player object with chosen name and class.
     */
    private static Player playerDetails(){
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
                    System.out.println("Please choose either 1, 2 or 3.");
                }
            } catch(InputMismatchException e){
                System.out.println("Please choose either 1, 2 or 3.");
                scan.next();
            }
        }
        
        //startTime = data.getTimer().getCurrentTime();
        return createPlayer(playerName, classType);
    }
    
    /**
     * Returns a Player object with the given name and class. The rest of the 
     * player stats are preset. The parameter classType means the following: 
     * 1 = Warrior 
     * 2 = Archer 
     * 3 = Wizard 
     * @param playerName String representation of player name
     * @param classType Int representation of player class
     * @return Player object with chosen name and class
     */
    private static Player createPlayer(String playerName, int classType){
        if (classType == 1){
            return new Warrior(30,playerName, 100, 0, new ArrayList<Item>(), 0.0, new HashMap<ItemSlot, Item>(), 90.0, 20.0, 5.0, false, false);
        }
        else if (classType == 2){
            return new Archer(20,playerName, 100, 0, new ArrayList<Item>(), 0.0, new HashMap<ItemSlot, Item>(), 80.0, 10.0, 30.0, false, false);
        }
        else if (classType == 3){
            return new Wizard(30,playerName, 100, 0, new ArrayList<Item>(), 0.0, new HashMap<ItemSlot, Item>(), 90.0, 20.0, 5.0, false, false);
        }
        else {
            System.out.println("This should never happen, but you dun goofed and now you're a wizard... Harry.");
            return new Wizard(30,playerName, 100, 0, new ArrayList<Item>(), 0.0, new HashMap<ItemSlot, Item>(), 90.0, 20.0, 5.0, false, false);
        }
    }
}
