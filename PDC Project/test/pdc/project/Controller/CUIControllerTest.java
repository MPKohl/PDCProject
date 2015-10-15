package pdc.project.Controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pdc.project.Model.Tile;

/**
 *
 * @author MPKohl
 */
public class CUIControllerTest {
    
    public CUIControllerTest() {
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
     * Test of startGame method, of class CUIController.
     */
    @Test
    public void testStartGame() {
        System.out.println("startGame");
        CUIController.startGame();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of move method, of class CUIController.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        Tile[] reachableTiles = null;
        CUIController.move(reachableTiles);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playAgain method, of class CUIController.
     */
    @Test
    public void testPlayAgain() {
        System.out.println("playAgain");
        CUIController.playAgain();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of finishGame method, of class CUIController.
     */
    @Test
    public void testFinishGame() {
        System.out.println("finishGame");
        CUIController.finishGame();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
