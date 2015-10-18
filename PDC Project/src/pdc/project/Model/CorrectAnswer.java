package pdc.project.Model;

/**
 * Correct answer for challenges.
 */
public class CorrectAnswer extends TextOutput {
    public CorrectAnswer(String correctAnswer){
        setText(correctAnswer);
    }
    
    public String toString() {
        return getText();
    }
}
