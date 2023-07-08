package ru.findfood.PersonalArea.enums;

public enum ActivityTitle {

    MIN_ACTIVITY("Минимальная нагрузка"),
    LOW_ACTIVITY("Легкая нагрузка"),
    MEDIUM_ACTIVITY("Умеренная нагрузка"),
    HIGH_ACTIVITY("Высокая нагрузка"),
    EXTREME_ACTIVITY("Экстремальная нагрузка");

    public String value;

    ActivityTitle(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
