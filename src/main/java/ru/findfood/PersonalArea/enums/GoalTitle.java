package ru.findfood.PersonalArea.enums;

public enum GoalTitle {

    KEEP_WEIGHT("Поддержание веса"),
    LOSE_WEIGHT("Похудеть"),
    GET_WEIGHT("Набрать вес");

    public String value;

    GoalTitle(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
