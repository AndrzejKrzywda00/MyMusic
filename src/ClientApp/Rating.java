package ClientApp;

public class Rating {

    // Implements simple rating in range from 1 to 10.
    // In my app will be shown as stars

    private int howGood;
    private Boolean initialised;

    public Rating() {
        this.initialised = false;
    }

    void updateRating(int howMuch) {

        // scale is forced to be between 1 and 10
        if (howMuch >= 1 && howMuch <= 10) {
            this.howGood = howMuch;
            this.initialised = true;
        }
    }

    int getHowGood() {
        return this.howGood;
    }

}
