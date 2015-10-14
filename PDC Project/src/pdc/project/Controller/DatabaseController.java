
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
    public void openConnection() {
        
        try{
            //Open a connection
            conn = DriverManager.getConnection(url, username, password); //Database credentials

        } catch(SQLException e){
            //Handle errors
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
            String createHighScoreTable="CREATE TABLE HIGHSCORE (player_name VARCHAR(255), player_score FLOAT, player_class VARCHAR(255))";
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
     * Show High Scores query with ResultSet
     * @return ArrayList 
     */
    public ArrayList<String> getHighscores(){
        Statement stmt;
        String sqlQuery = "SELECT player_name, player_score, player_class FROM HIGHSCORE ORDER BY player_score DESC";
        ArrayList<String> returnedList = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);
            while (rs.next()) {
                String player_name = rs.getString("player_name");
                String player_score = rs.getString("player_score");
                String player_class = rs.getString("player_class");
                String result = (player_name + " --- " + player_score + " --- " + player_class);
                returnedList.add(result);
            }
            stmt.close();
        } catch (SQLException e) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, e);
        }
        return returnedList;
    }
    
    /**
     * Updates the high score table
     */
    public boolean updateHighscores(){
        DataHolderSingleton data = DataHolderSingleton.getInstance();
        double player_score = data.getPlayer().getScore();
        String player_name = data.getPlayer().getName();
        String player_class = data.getPlayer().findClass();
        PreparedStatement stmt;
        String sqlUpdate = "INSERT INTO HIGHSCORE (player_name, player_score, player_class) VALUES (?, ?, ?)";
        try {
            stmt = conn.prepareStatement(sqlUpdate);
            stmt.setString(1, player_name);
            stmt.setFloat(2, (float) player_score);
            stmt.setString(3, player_class);
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
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
}
