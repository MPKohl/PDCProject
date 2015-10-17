package pdc.project.Model;

/**
 * Simple class for Challenges output text.
 */
public abstract class TextOutput {
    private String text;

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }
   
}
