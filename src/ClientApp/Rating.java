package ClientApp;

public class Rating {

    // Implements simple rating in range from 1 to 10.
    // In my app will be shown as stars

    // TODO -- make this enum for SURE!
    private int howGood;
    private Boolean initialised;

    public Rating(int howGood) {
        this.howGood = howGood;
        this.initialised = false;
    }

    void updateRating(int howGood) {

        // scale is forced to be between 1 and 10
        if (howGood >= 1 && howGood <= 10) {
            this.howGood = howGood;
            this.initialised = true;
        }
    }

    int getHowGood() {
        return this.howGood;
    }

}
