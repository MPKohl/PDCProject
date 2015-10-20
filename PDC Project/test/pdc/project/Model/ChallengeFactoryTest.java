package pdc.project.Model;

import junit.framework.Assert;
import org.junit.Test;

/**
 * 
 */
public class ChallengeFactoryTest {
    
    public ChallengeFactoryTest() {
    }

    /**
     * Test of getRandomChallenge method, of class ChallengeFactory.
     */
    @Test
    public void testGetRandomChallenge() {
        ChallengeFactory instance = new ChallengeFactory();
        
        Assert.assertEquals("Start size of ArrayList of unused challenges not 15.", 15, instance.getNewChallenges().size());
        Assert.assertEquals("Start size of ArrayList of used challenges not 0.", 0, instance.getDoneChallenges().size());
        
        Challenge result = instance.getRandomChallenge();
        
        Assert.assertEquals("Size of ArrayList of unused challenges after getting challenge not 14.", 14, instance.getNewChallenges().size());
        Assert.assertEquals("Size of ArrayList of used challenges after getting challenge not 1.", 1, instance.getDoneChallenges().size());
        Assert.assertTrue("Used challenge not moved to ArrayList of used challenges.", instance.getDoneChallenges().contains(result));
        Assert.assertFalse("Used challenge not moved out of ArrayList of unused challenges.", instance.getNewChallenges().contains(result));
    }

    
}
