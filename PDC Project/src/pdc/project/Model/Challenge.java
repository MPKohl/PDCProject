package pdc.project.Model;

import java.util.ArrayList;

/**
 * Class for challenge tiles. Extends Tile. 
 * All challenges consist of a question, a correct answer and some 
 * wrong answers.
 */
public class Challenge extends Tile {
    
    Question question;
    CorrectAnswer correctAsnwer;
    ArrayList<WrongAnswer> wrongAnswers = new ArrayList<>();
    
    public Challenge(){
        setType(TileType.CHALLENGE);
    }
    
    //Timer
}
