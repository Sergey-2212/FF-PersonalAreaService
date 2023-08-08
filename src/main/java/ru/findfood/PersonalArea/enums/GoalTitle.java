package ru.findfood.PersonalArea.enums;

import lombok.EqualsAndHashCode;

import java.util.Objects;

public enum GoalTitle {

    KEEP_WEIGHT("Keep"),
    LOSE_WEIGHT("Lose"),
    GET_WEIGHT("Get");

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
