package ru.findfood.PersonalArea.enums;

import ru.findfood.PersonalArea.entities.Activity;

import java.util.Objects;

public enum ActivityTitle {

    MIN_ACTIVITY("Min"),
    LOW_ACTIVITY("Light"),
    MEDIUM_ACTIVITY("Medium"),
    HIGH_ACTIVITY("High"),
    EXTREME_ACTIVITY("Extreme");

    public String title;

    ActivityTitle(String title) {
        this.title = title;
    }

    public static ActivityTitle getByTitle(String title) {
        for (ActivityTitle value : values()) {
            if (Objects.equals(value.title, title)) {
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
