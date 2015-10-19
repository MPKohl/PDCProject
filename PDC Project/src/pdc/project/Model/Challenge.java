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
    
    /**
     * Constructor that sets the question, correct and wrong answer for the challenge.
     * @param question Question object with the question to ask
     * @param correct CorrectAnswer object of the correct answer
     * @param wrong WrongAnswer[] of the wrong answers
     */
    public Challenge(Question question, CorrectAnswer correct, WrongAnswer[] wrong){
        setType(TileType.CHALLENGE);
        this.question = question;
        this.correctAnswer = correct;
        
        this.wrongAnswers.addAll(Arrays.asList(wrong));
    }
    
    /**
     * Returns an array of TextOutput objects with the question at [0], the 
     * correct answer at [1] and the wrong answers from [2] and on.
     * @return TextOutput[] of question, correct answer and wrong answers in that order
     */
    public TextOutput[] getChallenge(){
        
        TextOutput[] array = new TextOutput[2 + getWrongAnswers().size()];
        
        array[0] = getQuestion();
        array[1] = getCorrectAnswer();
        
        for (int i = 0 ; i < getWrongAnswers().size() ; i++)
            array[i+2] = getWrongAnswers().get(i);
        return array;
    }
    
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
    
    public String getStringAnswer() {
        return correctAnswer.toString();
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