package enums;

import Interfaces.ITextSerializeable;

public enum Rating implements ITextSerializeable {

    // Implements simple rating in range from 1 to 10.
    // In my app will be shown as stars

    // TODO -- make this enum for SURE!
    // ratings
    OneStar(1,"one star"),
    TwoStars(2,"two stars"),
    ThreeStars(3,"three stars"),
    FourStars(4,"four stars"),
    FiveStars(5,"five stars"),

    // when not added by user -- default version
    NotInitalized(0,"not initialized");

    private int howManyStars;
    private String description;

    Rating(int howManyStars, String description) {
        this.howManyStars = howManyStars;
        this.description = description;
    }

    public String serialize() {
        StringBuilder output = new StringBuilder();
        output.append(howManyStars);
        output.append(";");
        return output.toString();
    }
}
