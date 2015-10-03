
package pdc.project.Controller;
import java.sql.*;
import java.util.ArrayList;

/**
 * Controls all communication between program and database.
 */
public class DatabaseController {
    
    private static Connection conn;
    private final String url = "url=jdbc:mysql://localhost/CarDB";
    private final String username = "root";
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
            System.err.println("SQLException: " + e.getMessage());
        }
    }
    
    /**
     * Closes connection to database.
     */
    public void closeConnection(){
        try{
            conn.close();
        } catch(SQLException e){
            System.err.println("SQLException: " + e.getMessage());
        }
        System.out.println("Connection Closed");
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
            System.err.println("SQLException: " + e.getMessage());
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
            System.err.println("SQLException: " + e.getMessage());
        }
    }
}
