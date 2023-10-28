package ru.findfood.PersonalArea.enums;

import java.util.Objects;

public enum GoalTitle {

    KEEP_WEIGHT("Keep"),
    LOSE_WEIGHT("Lose"),
    GET_WEIGHT("Get"),
    NO_DATA("No data");

    public String title;

    GoalTitle(String title) {
        this.title = title;
    }

    public static GoalTitle getByTitle(String title) {
        for (GoalTitle value : values()) {
            if(Objects.equals(value.title, title)) {
                return value;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return title;
    }
}
