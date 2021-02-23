package enums;

import Interfaces.ITextSerializeable;

public enum Rating implements ITextSerializeable {

    // Implements simple rating in range from 1 to 10.
    // In my app will be shown as stars

    // ratings
    OneStar(1),
    TwoStars(2),
    ThreeStars(3),
    FourStars(4),
    FiveStars(5),

    // when not added by user -- default version
    NotInitalized(0);

    private int howManyStars;

    Rating(int howManyStars) {
        this.howManyStars = howManyStars;
    }

    public static Rating getRating(int value) {
        switch (value) {
            case 0 : return NotInitalized;
            case 1 : return OneStar;
            case 2 : return TwoStars;
            case 3 : return ThreeStars;
            case 4 : return FourStars;
            case 5 : return FiveStars;
        }
        return null;
    }

    public String serialize() {
        StringBuilder output = new StringBuilder();
        output.append(howManyStars);
        output.append(";");
        return output.toString();
    }
}
