
package pdc.project.Controller;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controls all communication between program and database.
 */
public class DatabaseController {
    
    private static Connection conn;
    private final String url = "url=jdbc:derby://localhost:1527/GameDB";
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
            String createHighScoreTable="CREATE TABLE HIGHSCORE (player_name VARCHAR(255) NOT NULL, score INT(255) NOT NULL)";
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
}
