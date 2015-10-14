
package pdc.project.Controller;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pdc.project.Model.DataHolderSingleton;
import pdc.project.Model.GameTimer;
import pdc.project.Model.Player;

/**
 * Controls all communication between program and database.
 */
public class DatabaseController {
    
    private static Connection conn;
    private final String url = "jdbc:derby://localhost:1527/GameDB;create=true";
    private final String username = "pdc";
    private final String password = "123";
    
    /**
     * Connects to the database.
     */
    public void initialize() {
        
        try{
            //Open a connection
            conn = DriverManager.getConnection(url, username, password); //Database credentials

        } catch(SQLException e){
            //Handle errors
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void createTables(){
        try {
            Statement stmt=conn.createStatement();
            String createHighScoreTable="CREATE TABLE HIGHSCORE (player_name VARCHAR(255) NOT NULL, score INT(255) NOT NULL, player_class VARCHAR(255) NOT NULL);";
            stmt.executeUpdate(createHighScoreTable);
            
        } catch (SQLException e) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    /**
     * Closes connection to database.
     */
    public void closeConnection(){
        try{
            conn.close();
            System.out.println("Connection Closed");
        } catch(SQLException e){
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void createTable(){
        try {
            Statement stmt=conn.createStatement();
            String createHighScoreTable="CREATE TABLE HIGHSCORE (player_name VARCHAR(255), score INTEGER)";
            stmt.executeUpdate(createHighScoreTable);
            
        } catch (SQLException e) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void deleteTable(){
        try {
            Statement stmt=conn.createStatement();
            String deleteHighScoreTable="DROP TABLE HIGHSCORE";
            stmt.executeUpdate(deleteHighScoreTable);
            
        } catch (SQLException e) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    /**
     * Example of query with ResutlSet
     * @param id
     * @return ArrayList 
     */
    public ArrayList<String> exampleQuery(int id){
        Statement stmt;
        String sqlQuery = "SELECT some_attribute1 FROM some_table WHERE some_attribute2 = '" + id + "' ;";
        ArrayList<String> returnedList = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);
            while (rs.next()) {
                String result = rs.getString("some_attribute1");
                returnedList.add(result);
            }
            stmt.close();
        } catch (SQLException e) {
            //Handle errors
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, e);
        }
        return returnedList;
    }
    
    /**
     * Show the saves saved on the database query with ResutlSet
     * @return ArrayList 
     */
    /*public ArrayList<String> showSaves(){
        Statement stmt;
        String sqlQuery = "SELECT save_id, save_name, player_name FROM savegames, player WHERE savegames.player_id = player.player_id;";
        ArrayList<String> returnedList = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);
            while (rs.next()) {
                String save_id = rs.getString("save_id");
                String save_name = rs.getString("save_name");
                String player_name = rs.getString("player_name");
                String result = (save_id + ", " + save_name + ", " + player_name);
                returnedList.add(result);
                
            }
            stmt.close();
        } catch (SQLException e) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, e);
        }
        return returnedList;
    }*/
    /**
     * loads a game from the database query with ResutlSet
     * @param id is the save id the user has chosen.
     * @return ArrayList 
     */
    /*public ArrayList<String> loadGame(int id){
        Statement stmt;
        String boardQuery = "SELECT x_pos, y_pos, tile_status FROM savegames, tile, board WHERE savegames.save_id = '" + id + "' AND savegames.board_id = board.board_id;";
        String playerQuery = "SELECT player_name, player_class, player_lvl, player_exp, player_health, player_score FROM savegames, player, player_stats WHERE player.player_id = savegames.player_id AND player_stats.player_id = player.player_id;";
        ArrayList<String> returnedList = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rsBoard = stmt.executeQuery(boardQuery);
            while (rsBoard.next()) {
                int x_pos = rsBoard.getInt("x_pos");
                int y_pos = rsBoard.getInt("y_pos");
                String tile_status = rsBoard.getString("tile_status");
                String result = (x_pos + ", " + y_pos + ", " + tile_status);
                returnedList.add(result);
            }
            stmt.close();
        } catch (SQLException e) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, e);
        }
        return returnedList;
    }*/
    
    
     /**
     * Show High Scores query with ResultSet
     * @return ArrayList 
     */
    public ArrayList<String> showHighscores(){
        Statement stmt;
        String sqlQuery = "SELECT player_name, player_score FROM player, player_stats WHERE player.player_id = player_stats.player_id ORDER BY player_score;";
        ArrayList<String> returnedList = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);
            while (rs.next()) {
                String player_name = rs.getString("player_name");
                String player_score = rs.getString("player_score");
                String result = (player_name + ", " + player_score);
                returnedList.add(result);
            }
            stmt.close();
        } catch (SQLException e) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, e);
        }
        return returnedList;
    }
    
    /**
     * Example update
     * @param 
     */
    public void exampleUpdate(String value1, String value2){
        Statement stmt;
        String sqlUpdate = "INSERT INTO some_table (column1, column2, ...) VALUES ('" + value1 + "', '" + value2 + "', ...);";
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sqlUpdate);
            
        } catch (SQLException e) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    
    /**
     * Updates the high score table
     */
    public void highScoreUpdate(){
        DataHolderSingleton data = DataHolderSingleton.getInstance();
        double score = data.getPlayer().getScore();
        String player_name = data.getPlayer().getName();
        String player_class = data.getPlayer().findClass();
        Statement stmt;
        String sqlUpdate = "INSERT INTO highscore (player_name, score, class) VALUES ('" + player_name + "', '" + score + "', '"  +  player_class + "');";
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sqlUpdate);
            
        } catch (SQLException e) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
