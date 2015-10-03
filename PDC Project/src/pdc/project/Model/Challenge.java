package pdc.project.Model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class for challenge tiles. Extends Tile. 
 * All challenges consist of a question, a correct answer and some 
 * wrong answers.
 */
public class Challenge extends Tile {
    
    private Question question;
    private CorrectAnswer correctAnswer;
    private ArrayList<WrongAnswer> wrongAnswers = new ArrayList<>();
    
    public Challenge(Question question, CorrectAnswer correct, WrongAnswer[] wrong){
        setType(TileType.CHALLENGE);
        this.question = question;
        this.correctAnswer = correct;
        
        this.wrongAnswers.addAll(Arrays.asList(wrong));
    }
    
    public TextOutput[] getChallenge(){
        
        TextOutput[] array = new TextOutput[2 + getWrongAnswers().size()];
        
        array[0] = getQuestion();
        array[1] = getCorrectAnswer();
        
        for (int i = 0 ; i < getWrongAnswers().size() ; i++)
            array[i+2] = getWrongAnswers().get(i);
        return array;
    }
    
    //Timer

    /**
     * @return the question
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(Question question) {
        this.question = question;
    }

    /**
     * @return the correctAnswer
     */
    public CorrectAnswer getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * @param correctAnswer the correctAnswer to set
     */
    public void setCorrectAnswer(CorrectAnswer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    /**
     * @return the wrongAnswers
     */
    public ArrayList<WrongAnswer> getWrongAnswers() {
        return wrongAnswers;
    }

    /**
     * @param wrongAnswers the wrongAnswers to set
     */
    public void setWrongAnswers(ArrayList<WrongAnswer> wrongAnswers) {
        this.wrongAnswers = wrongAnswers;
    }
}
