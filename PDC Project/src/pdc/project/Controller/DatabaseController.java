
package pdc.project.Controller;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pdc.project.Model.DataHolder;
import pdc.project.Model.PlayerClass;

/**
 * Controls all communication between program and database.
 */
public class DatabaseController {
    
    private static Connection conn;
    private final String url = "jdbc:derby://localhost:1527/GameDB;create=true;user=pdc;password=123";
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
    
    /**
     * Creates the Highscore table with 3 columns:
     * player_name 
     * player_score 
     * player_class
     */
    public void createTable(){
        try {
            Statement stmt=conn.createStatement();
            String createHighScoreTable="CREATE TABLE Highscore (player_name VARCHAR(255), player_score FLOAT, player_class VARCHAR(255))";
            stmt.executeUpdate(createHighScoreTable);
            stmt.close();
        } catch (SQLException e) {
            if(e.getSQLState().equals("X0Y32")){
                // Do nothing if table already exists
            } else {
                Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, e);
            }
        } finally {
            
        }
    }
    
    /**
     * Deletes the Highscore table.
     */
    public void deleteTable(){
        try {
            Statement stmt=conn.createStatement();
            String deleteHighScoreTable="DROP TABLE Highscore";
            stmt.executeUpdate(deleteHighScoreTable);
            stmt.close();
        } catch (SQLException e) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
       
     /**
     * Returns an ArrayList<String> with the highscores sorted by score in 
     * descending order in the following format: 
     * player_name --- player_score --- player_class
     * @return ArrayList of highscores in String format
     */
    public ArrayList<String> getHighscores(){
        Statement stmt;
        String sqlQuery = "SELECT player_name, player_score, player_class FROM Highscore ORDER BY player_score DESC";
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
     * Updates the high score table.
     * @return true if successful.
     */
    public boolean updateHighscores(){
        DataHolder data = DataHolder.getInstance();
        double player_score = data.getPlayer().getScore();
        String player_name = data.getPlayer().getName();
        String player_class;
        if (data.getPlayer().findClass() == PlayerClass.WIZARD){
            player_class = "Wizard";
        } else if (data.getPlayer().findClass() == PlayerClass.WARRIOR){
            player_class = "Warrior";
        } else if (data.getPlayer().findClass() == PlayerClass.ARCHER) {
            player_class = "Archer";
        } else {
            player_class = "Unknown";
        }
        PreparedStatement stmt;
        String sqlUpdate = "INSERT INTO Highscore (player_name, player_score, player_class) VALUES (?, ?, ?)";
        try {
            stmt = conn.prepareStatement(sqlUpdate);
            stmt.setString(1, player_name);
            stmt.setFloat(2, (float) player_score);
            stmt.setString(3, player_class);
            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    
    /**
     * Clears the Highscore table by deleting it and remaking it.
     */
    public void clearHighscores(){
        deleteTable();
        createTable();
    }
}
