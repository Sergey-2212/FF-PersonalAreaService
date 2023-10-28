package ru.findfood.PersonalArea.enums;

import java.util.Objects;

public enum Sex {
    FEMALE("female"),
    MALE("male"),
    NO_DATA("No data");

    private String sex;

    Sex(String sex) {
        this.sex = sex;
    }

    public static Sex getBySex(String sex) {
        for (Sex value : values()) {
            if (Objects.equals(value.sex, sex)) {
                return value;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String toString(){
        return sex;
    }

}





