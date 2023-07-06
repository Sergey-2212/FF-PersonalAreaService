package ru.findfood.PersonalArea.enums;

public enum Sex {
    FEMALE("female"),
    MALE("male");

    private String value;

    Sex(String value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }
}





