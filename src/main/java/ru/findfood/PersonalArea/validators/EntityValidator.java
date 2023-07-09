package ru.findfood.PersonalArea.validators;

import org.springframework.stereotype.Component;
import ru.findfood.PersonalArea.dtos.PersonDto;
import ru.findfood.PersonalArea.enums.ActivityTitle;
import ru.findfood.PersonalArea.enums.GoalTitle;
import ru.findfood.PersonalArea.enums.Sex;
import ru.findfood.PersonalArea.exceptions.ValidationErrorException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class EntityValidator {

    private final Long BEGINING_OF_PREVIOUS_CENTURY = 57751927306014L;

    private List<String> errorList = new ArrayList<>();

    public void checkPersonDto (PersonDto dto) {

        if(dto.getUsername().isBlank()) {
            errorList.add("Username is not valid - " + dto.getUsername());
        }
        if(!dto.getSex().equals(Sex.FEMALE) || !dto.getSex().equals(Sex.MALE)) {
            errorList.add("Sex is not valid - " + dto.getSex());
        }
        if(dto.getBirthdate().before(new Date(BEGINING_OF_PREVIOUS_CENTURY))) {
            errorList.add("Birthdate is not valid - " + dto.getBirthdate());
        }
        if(dto.getWeight() <= 0) {
            errorList.add("Weight is not valid - " + dto.getWeight());
        }
        if(dto.getHeight() <= 0) {
            errorList.add("Height is not valid - " + dto.getHeight());
        }
        if(!dto.getActivity_title().equals(ActivityTitle.EXTREME_ACTIVITY) ||
                !dto.getActivity_title().equals(ActivityTitle.HIGH_ACTIVITY) ||
                !dto.getActivity_title().equals(ActivityTitle.MEDIUM_ACTIVITY) ||
                !dto.getActivity_title().equals(ActivityTitle.LOW_ACTIVITY) ||
                !dto.getActivity_title().equals(ActivityTitle.MIN_ACTIVITY)) {
            errorList.add("Activity Title is not valid - " + dto.getActivity_title());
        }
        if(!dto.getGoal_title().equals(GoalTitle.GET_WEIGHT) ||
                !dto.getGoal_title().equals(GoalTitle.KEEP_WEIGHT) ||
                !dto.getGoal_title().equals(GoalTitle.LOSE_WEIGHT)) {
            errorList.add("GoalTitle is not valid - " + dto.getGoal_title());
        }

        if(!errorList.isEmpty()) {
            throw new ValidationErrorException(errorList);
        }
    }


}
