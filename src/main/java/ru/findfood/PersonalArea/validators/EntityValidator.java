package ru.findfood.PersonalArea.validators;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.findfood.PersonalArea.dtos.PersonDto;
import ru.findfood.PersonalArea.dtos.PersonInfoDto;
import ru.findfood.PersonalArea.enums.ActivityTitle;
import ru.findfood.PersonalArea.enums.GoalTitle;
import ru.findfood.PersonalArea.enums.Sex;
import ru.findfood.PersonalArea.exceptions.ValidationErrorException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Slf4j
@Component
public class EntityValidator {


    private final Date BEGINING_OF_PREVIOUS_CENTURY = new Date(0,0,1);

    public void checkPersonDto (PersonDto dto) {
        List<String> errorList = new ArrayList<>();

        if(dto.getUsername().isBlank()) {
            errorList.add("Username is not valid - " + dto.getUsername());
        }
        if(dto.getSex().equals(Sex.FEMALE.toString()) == dto.getSex().equals(Sex.MALE.toString())) {
            errorList.add("Sex is not valid - " + dto.getSex());
        }
        log.info("dto - " + dto.getBirthdate().toString());
        log.info("Date - " + BEGINING_OF_PREVIOUS_CENTURY);
        if(dto.getBirthdate().before(BEGINING_OF_PREVIOUS_CENTURY)) {
            errorList.add("Birthdate is not valid - " + dto.getBirthdate());
        }
        if(dto.getWeight() <= 0) {
            errorList.add("Weight is not valid - " + dto.getWeight());
        }
        if(dto.getHeight() <= 0) {
            errorList.add("Height is not valid - " + dto.getHeight());
        }
        if(!(dto.getActivity_title().equals(ActivityTitle.EXTREME_ACTIVITY.toString()) ^
                dto.getActivity_title().equals(ActivityTitle.HIGH_ACTIVITY.toString()) ^
                dto.getActivity_title().equals(ActivityTitle.MEDIUM_ACTIVITY.toString()) ^
                dto.getActivity_title().equals(ActivityTitle.LOW_ACTIVITY.toString()) ^
                dto.getActivity_title().equals(ActivityTitle.MIN_ACTIVITY.toString()))) {
            errorList.add("Activity Title is not valid - " + dto.getActivity_title());
        }
        if(!(dto.getGoal_title().equals(GoalTitle.GET_WEIGHT.toString()) ^
                dto.getGoal_title().equals(GoalTitle.KEEP_WEIGHT.toString()) ^
                dto.getGoal_title().equals(GoalTitle.LOSE_WEIGHT.toString()))) {
            errorList.add("GoalTitle is not valid - " + dto.getGoal_title());
        }

        if(!errorList.isEmpty()) {
            throw new ValidationErrorException(errorList);
        }
    }

    public void checkPersonInfoDto (PersonInfoDto dto) {
        if(dto.getPersonId() <= 0) {
            throw new ValidationErrorException("PersonId is not valid - " + dto.getPersonId());
        }
    }


}
