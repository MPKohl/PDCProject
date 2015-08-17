package pdc.project.Model;

import java.util.ArrayList;

/**
 * Class for challenge tiles. Extends Tile. 
 * All challenges consist of a question, a correct answer and some 
 * wrong answers.
 */
public class Challenge extends Tile {
    
    Question question;
    CorrectAnswer correctAnswer;
    ArrayList<WrongAnswer> wrongAnswers = new ArrayList<>();
    
    public Challenge(Question question, CorrectAnswer correct, WrongAnswer[] wrong){
        setType(TileType.CHALLENGE);
        this.question = question;
        this.correctAnswer = correct;
        
        for (int i = 0 ; i < wrong.length ; i++)
            this.wrongAnswers.add(wrong[i]);
    }
    
    public TextOutput[] getChallenge(){
        
        TextOutput[] array = new TextOutput[2 + wrongAnswers.size()];
        
        array[0] = question;
        array[1] = correctAnswer;
        
        for (int i = 0 ; i < wrongAnswers.size() ; i++)
            array[i+2] = wrongAnswers.get(i);
        return array;
    }
    
    //Timer
}
