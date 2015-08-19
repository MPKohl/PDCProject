
package pdc.project.Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 */
public class ChallengeFactory {
    
    private ArrayList<Challenge> newChallenges = new ArrayList<Challenge>();
    private ArrayList<Challenge> doneChallenges = new ArrayList<Challenge>();

    public ChallengeFactory() {
        //Create a list of all challenges
        
        Question question = new Question("I can have no color, though there may be darkness within. I have no weight and hold nothing, and if placed in a container it becomes lighter.");
        CorrectAnswer correctAnswer = new CorrectAnswer("A hole.");
        WrongAnswer[] wrongAnswers = new WrongAnswer[7];
        wrongAnswers[0] = new WrongAnswer("Air.");
        wrongAnswers[1] = new WrongAnswer("Faith.");
        wrongAnswers[2] = new WrongAnswer("Fellowship.");
        wrongAnswers[3] = new WrongAnswer("A rope.");
        wrongAnswers[4] = new WrongAnswer("Love.");
        wrongAnswers[5] = new WrongAnswer("Water.");
        wrongAnswers[6] = new WrongAnswer("Poetry.");
        
        Challenge challenge = new Challenge(question, correctAnswer, wrongAnswers);
        
        newChallenges.add(challenge);
        
        question = new Question("Of all your possessions, I am the hardest to guard. If you have me, you will want to share me. If you share me, you no longer have me.");
        correctAnswer = new CorrectAnswer("A secret.");
        wrongAnswers = new WrongAnswer[7];
        wrongAnswers[0] = new WrongAnswer("Your life.");
        wrongAnswers[1] = new WrongAnswer("Good intentions.");
        wrongAnswers[2] = new WrongAnswer("Water.");
        wrongAnswers[3] = new WrongAnswer("The Gods.");
        wrongAnswers[4] = new WrongAnswer("Air.");
        wrongAnswers[5] = new WrongAnswer("Music.");
        wrongAnswers[6] = new WrongAnswer("Hatred.");
        
        challenge = new Challenge(question, correctAnswer, wrongAnswers);
        
        newChallenges.add(challenge);
        
        question = new Question("Alive as you but without breath, as cold in my life as in my death; never a thirst though. I always drink dressed in a mail but never a clink.");
        correctAnswer = new CorrectAnswer("Fish.");
        wrongAnswers = new WrongAnswer[7];
        wrongAnswers[0] = new WrongAnswer("Specter.");
        wrongAnswers[1] = new WrongAnswer("Wealth.");
        wrongAnswers[2] = new WrongAnswer("Water.");
        wrongAnswers[3] = new WrongAnswer("Poetry.");
        wrongAnswers[4] = new WrongAnswer("Sails.");
        wrongAnswers[5] = new WrongAnswer("The Plague.");
        wrongAnswers[6] = new WrongAnswer("Winter.");
        
        challenge = new Challenge(question, correctAnswer, wrongAnswers);
        
        newChallenges.add(challenge);
        
        question = new Question("I am free for the taking through all of your life, though given but once at birth. I am less than nothing in weight, but will fell the strongest of you if held.");
        correctAnswer = new CorrectAnswer("Breath.");
        wrongAnswers = new WrongAnswer[7];
        wrongAnswers[0] = new WrongAnswer("Good Will.");
        wrongAnswers[1] = new WrongAnswer("A Blade.");
        wrongAnswers[2] = new WrongAnswer("Water.");
        wrongAnswers[3] = new WrongAnswer("The Sky.");
        wrongAnswers[4] = new WrongAnswer("A Hand.");
        wrongAnswers[5] = new WrongAnswer("Language.");
        wrongAnswers[6] = new WrongAnswer("Spirit.");
        
        challenge = new Challenge(question, correctAnswer, wrongAnswers);
        
        newChallenges.add(challenge);
        
        question = new Question("I have holes throughout, from back to front and top to bottom to core. More nothing than something within, and yet I still hold water.");
        correctAnswer = new CorrectAnswer("A Sponge.");
        wrongAnswers = new WrongAnswer[7];
        wrongAnswers[0] = new WrongAnswer("A Well.");
        wrongAnswers[1] = new WrongAnswer("Cupped Hands.");
        wrongAnswers[2] = new WrongAnswer("A Glass.");
        wrongAnswers[3] = new WrongAnswer("The Sky.");
        wrongAnswers[4] = new WrongAnswer("The Ocean.");
        wrongAnswers[5] = new WrongAnswer("Tears.");
        wrongAnswers[6] = new WrongAnswer("A Stream.");
        
        challenge = new Challenge(question, correctAnswer, wrongAnswers);
        
        newChallenges.add(challenge);
        
        question = new Question("They flow and leap, but only as you pass. Dress yourself in darkest black, and they are darker still. Always they flee in the light, though without the sun there would be none.");
        correctAnswer = new CorrectAnswer("Shadows.");
        wrongAnswers = new WrongAnswer[7];
        wrongAnswers[0] = new WrongAnswer("Ravens.");
        wrongAnswers[1] = new WrongAnswer("Good Intentions.");
        wrongAnswers[2] = new WrongAnswer("Ghosts.");
        wrongAnswers[3] = new WrongAnswer("Wheat.");
        wrongAnswers[4] = new WrongAnswer("Lovers.");
        wrongAnswers[5] = new WrongAnswer("Stars.");
        wrongAnswers[6] = new WrongAnswer("Willow.");
        
        challenge = new Challenge(question, correctAnswer, wrongAnswers);
        
        newChallenges.add(challenge);
        
        question = new Question("They come to witness the night without being called, a sailor's guide and a poet's tears. They are lost to sight each day without the hand of a thief.");
        correctAnswer = new CorrectAnswer("Stars.");
        wrongAnswers = new WrongAnswer[7];
        wrongAnswers[0] = new WrongAnswer("Eyes.");
        wrongAnswers[1] = new WrongAnswer("Mourners.");
        wrongAnswers[2] = new WrongAnswer("Doves.");
        wrongAnswers[3] = new WrongAnswer("Relatives.");
        wrongAnswers[4] = new WrongAnswer("The Gods.");
        wrongAnswers[5] = new WrongAnswer("Good Intentions.");
        wrongAnswers[6] = new WrongAnswer("Lovers.");
        
        challenge = new Challenge(question, correctAnswer, wrongAnswers);
        
        newChallenges.add(challenge);
        
        question = new Question("The more that there is, the less that you see. Squint all you wish when surrounded by me.");
        correctAnswer = new CorrectAnswer("Darkness.");
        wrongAnswers = new WrongAnswer[7];
        wrongAnswers[0] = new WrongAnswer("The Sun.");
        wrongAnswers[1] = new WrongAnswer("Bliss.");
        wrongAnswers[2] = new WrongAnswer("Drink.");
        wrongAnswers[3] = new WrongAnswer("Fire.");
        wrongAnswers[4] = new WrongAnswer("The Gods.");
        wrongAnswers[5] = new WrongAnswer("Breath.");
        wrongAnswers[6] = new WrongAnswer("Hope.");
        
        challenge = new Challenge(question, correctAnswer, wrongAnswers);
        
        newChallenges.add(challenge);
        
        question = new Question("The life I lead is mere hours or less, I serve all my time by being consumed. I am quickest when thin, slowest when fat, and wind is the bane of the gift that I bring.");
        correctAnswer = new CorrectAnswer("A Candle.");
        wrongAnswers = new WrongAnswer[7];
        wrongAnswers[0] = new WrongAnswer("A Wisp.");
        wrongAnswers[1] = new WrongAnswer("A Cloud.");
        wrongAnswers[2] = new WrongAnswer("A Child.");
        wrongAnswers[3] = new WrongAnswer("Good Intentions.");
        wrongAnswers[4] = new WrongAnswer("Speech.");
        wrongAnswers[5] = new WrongAnswer("Time.");
        wrongAnswers[6] = new WrongAnswer("Daybreak.");
        
        challenge = new Challenge(question, correctAnswer, wrongAnswers);
        
        newChallenges.add(challenge);
        
        question = new Question("The man who invented it, doesn't want it for himself. The man who bought it, doesn't need it for himself. The man who needs it, doesn't know when he needs it.");
        correctAnswer = new CorrectAnswer("A Coffin.");
        wrongAnswers = new WrongAnswer[7];
        wrongAnswers[0] = new WrongAnswer("A Charriot.");
        wrongAnswers[1] = new WrongAnswer("Fire.");
        wrongAnswers[2] = new WrongAnswer("A Wife.");
        wrongAnswers[3] = new WrongAnswer("Food.");
        wrongAnswers[4] = new WrongAnswer("Good will.");
        wrongAnswers[5] = new WrongAnswer("Sanctuary.");
        wrongAnswers[6] = new WrongAnswer("The Gods.");
        
        challenge = new Challenge(question, correctAnswer, wrongAnswers);
        
        newChallenges.add(challenge);
        
        question = new Question("A spirited jig it dances bright, banishing all but darkest night. Give it food and it will live, give it water and it will die.");
        correctAnswer = new CorrectAnswer("Fire.");
        wrongAnswers = new WrongAnswer[7];
        wrongAnswers[0] = new WrongAnswer("A Fool.");
        wrongAnswers[1] = new WrongAnswer("The Air.");
        wrongAnswers[2] = new WrongAnswer("Wheat.");
        wrongAnswers[3] = new WrongAnswer("The Desert.");
        wrongAnswers[4] = new WrongAnswer("Earth.");
        wrongAnswers[5] = new WrongAnswer("Laughter.");
        wrongAnswers[6] = new WrongAnswer("The Gods.");
        
        challenge = new Challenge(question, correctAnswer, wrongAnswers);
        
        newChallenges.add(challenge);
        
        question = new Question("Lighter than what I am made of, more of me is hidden than is seen, I am the bane of the mariner, a tooth within the sea. Speak my name.");
        correctAnswer = new CorrectAnswer("Ice.");
        wrongAnswers = new WrongAnswer[7];
        wrongAnswers[0] = new WrongAnswer("Sharks.");
        wrongAnswers[1] = new WrongAnswer("Whales.");
        wrongAnswers[2] = new WrongAnswer("Pirates.");
        wrongAnswers[3] = new WrongAnswer("Sails.");
        wrongAnswers[4] = new WrongAnswer("Stone.");
        wrongAnswers[5] = new WrongAnswer("The Stars.");
        wrongAnswers[6] = new WrongAnswer("The Shore.");
        
        challenge = new Challenge(question, correctAnswer, wrongAnswers);
        
        newChallenges.add(challenge);
      
        question = new Question("A box without hinges, key, or lid, Yet golden treasure inside is hid.");
        correctAnswer = new CorrectAnswer("Egg.");
        wrongAnswers = new WrongAnswer[2];
        wrongAnswers[0] = new WrongAnswer("Jukebox.");
        wrongAnswers[1] = new WrongAnswer("Skull");
        wrongAnswers[2] = new WrongAnswer("Toilet.");
        
        challenge = new Challenge(question, correctAnswer, wrongAnswers);
        
        newChallenges.add(challenge);
        
        question = new Question("What animal walks in the morning on four feet, in the afternoon on two feet, and in the evening on three feet?");
        correctAnswer = new CorrectAnswer("Aging human being.");
        wrongAnswers = new WrongAnswer[2];
        wrongAnswers[0] = new WrongAnswer("IKEA Import.");
        wrongAnswers[1] = new WrongAnswer("Car");
        wrongAnswers[2] = new WrongAnswer("Tailed Frog.");
        
        challenge = new Challenge(question, correctAnswer, wrongAnswers);
        
        newChallenges.add(challenge);
    
        question = new Question("As I was going to St. Ives, I met a man with seven wives.\n" +
                                "Each wife had seven sacks, each sack had seven cats, each cat had seven kits.\n" +
                                "Kits, cats, sacks, and wives, how many were going to St. Ives?");
        correctAnswer = new CorrectAnswer("1... Just the narrator.");
        wrongAnswers = new WrongAnswer[2];
        wrongAnswers[0] = new WrongAnswer("2... Just the narrator and the man.");
        wrongAnswers[1] = new WrongAnswer("2402 ...(7 x 7 x 7 x 7) + 1");
        wrongAnswers[2] = new WrongAnswer("2801 ... (7^0) + (7^1) + (7^2) +(7^3)");
        
        challenge = new Challenge(question, correctAnswer, wrongAnswers);
        
        newChallenges.add(challenge);
    }
    
    
    
    public Challenge getRandomChallenge(){
        //Picks a random new challenge
        Random random = new Random();
        int randomInt = random.nextInt(newChallenges.size());
        Challenge challengeToReturn = newChallenges.get(randomInt);
        
        //Adds the challenge to the list of done challenges
        getDoneChallenges().add(challengeToReturn);
        
        //Removes the challenge from the list of new challenges
        newChallenges.remove(randomInt);
        
        //Returns the random challenge
        return challengeToReturn;
    }
    
    /**
     * @return the new challenges
     */
    public ArrayList<Challenge> getNewChallenges() {
        return newChallenges;
    }

    /**
     * @param challenges the challenges to set
     */
    public void setNewChallenges(ArrayList<Challenge> challenges) {
        this.newChallenges = challenges;
    }

    /**
     * @return the doneChallenges
     */
    public ArrayList<Challenge> getDoneChallenges() {
        return doneChallenges;
    }

    /**
     * @param doneChallenges the doneChallenges to set
     */
    public void setDoneChallenges(ArrayList<Challenge> doneChallenges) {
        this.doneChallenges = doneChallenges;
    }

}
