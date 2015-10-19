package pdc.project.Controller;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 */
public class DatabaseControllerTest {
    
    public DatabaseControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of openConnection method, of class DatabaseController.
     */
    @Test
    public void testOpenConnection() {
        System.out.println("openConnection");
        DatabaseController instance = new DatabaseController();
        instance.openConnection();
    }

    /**
     * Test of closeConnection method, of class DatabaseController.
     */
    @Test
    public void testCloseConnection() {
        System.out.println("closeConnection");
        DatabaseController instance = new DatabaseController();
        instance.closeConnection();
    }

    /**
     * Test of createTable method, of class DatabaseController.
     */
    @Test
    public void testCreateTable() {
        System.out.println("createTable");
        DatabaseController instance = new DatabaseController();
        instance.createTable();
    }

    /**
     * Test of deleteTable method, of class DatabaseController.
     */
    @Test
    public void testDeleteTable() {
        System.out.println("deleteTable");
        DatabaseController instance = new DatabaseController();
        instance.deleteTable();
    }

    /**
     * Test of getHighscores method, of class DatabaseController.
     */
    @Test
    public void testGetHighscores() {
        System.out.println("getHighscores");
        DatabaseController instance = new DatabaseController();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getHighscores();
        assertEquals(expResult, result);
    }

    /**
     * Test of updateHighscores method, of class DatabaseController.
     */
    @Test
    public void testUpdateHighscores() {
        System.out.println("updateHighscores");
        DatabaseController instance = new DatabaseController();
        boolean expResult = false;
        boolean result = instance.updateHighscores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearHighscores method, of class DatabaseController.
     */
    @Test
    public void testClearHighscores() {
        System.out.println("clearHighscores");
        DatabaseController instance = new DatabaseController();
        instance.clearHighscores();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
