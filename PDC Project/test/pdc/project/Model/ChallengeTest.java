package pdc.project.Model;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Tests for Challenge class.
 */
public class ChallengeTest {
    
    public ChallengeTest() {
    }
    
    /**
     * Test of getChallenge method, of class Challenge.
     */
    @Test
    public void testGetChallenge() {
        Question question = new Question("Question");
        CorrectAnswer correct = new CorrectAnswer("Correct");
        WrongAnswer wrong = new WrongAnswer("Wrong");
        WrongAnswer[] wrongs = {wrong};
        Challenge challenge = new Challenge(question, correct, wrongs);
        
        TextOutput[] array = challenge.getChallenge();
        Assert.assertEquals("Question should be at index 0.", array[0], question);
        Assert.assertEquals("Correct answer should be at index 1.", array[1], correct);
        Assert.assertEquals("Wrong answer should be at index 2.", array[2], wrong);
    }
}
