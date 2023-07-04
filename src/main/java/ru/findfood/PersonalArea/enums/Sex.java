package ru.findfood.PersonalArea.enums;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Objects;


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





