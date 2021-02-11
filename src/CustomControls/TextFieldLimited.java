package CustomControls;

import javafx.scene.control.TextField;

public class TextFieldLimited extends TextField {

    // this is custom TextField with one more property, that it has a set limit for how many characters can be typed in

    private int lengthLimit;
    private static final int DEFAULT_LENGTH_LIMIT = 30;

    // default constructor
    public TextFieldLimited() {
        this.lengthLimit = DEFAULT_LENGTH_LIMIT;
    }

    // contructor with custom length
    public TextFieldLimited(int lengthLimit) {
        this.lengthLimit = lengthLimit;
    }

    // setter
    public void setLengthLimit(int lengthLimit) {
        this.lengthLimit = lengthLimit;
    }

    @Override
    public void replaceText(int start, int end, String text) {
        super.replaceText(start, end, text);
        verify();
    }

    @Override
    public void replaceSelection(String text) {
        super.replaceSelection(text);
        verify();
    }

    private void verify() {
        if ( getText().length() > lengthLimit ) {
            setText(getText().substring(0,lengthLimit));
        }
    }
}
