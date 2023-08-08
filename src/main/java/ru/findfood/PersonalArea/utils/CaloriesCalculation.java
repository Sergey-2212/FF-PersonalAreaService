package ru.findfood.PersonalArea.utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.findfood.PersonalArea.dtos.PersonDto;
import ru.findfood.PersonalArea.enums.Sex;
import ru.findfood.PersonalArea.services.ActivityService;

import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class CaloriesCalculation {

    private final ActivityService activityService;



    public int getCaloriesByPersonDto(PersonDto dto) {
        int result;
        if (dto.getSex().equals(Sex.MALE.toString())) {
            result = (int) (88.362F + (13.397 * dto.getWeight())
                    + (4.799 * dto.getHeight())
                    - (5.677 * (LocalDateTime.now().getYear() - dto.getBirthdate().getYear()))
                    * activityService.getByTitle(dto.getActivity_title()).getCoefficient());
            log.info("CALORIES_CALCULATE" + result);
            return result;
        }
        else if(dto.getSex().equals(Sex.FEMALE.toString())) {
            result =  (int)  ((88.362F + (13.397 * dto.getWeight())
                    + (4.799 * dto.getHeight())
                    - (5.677 * (LocalDateTime.now().getYear() - dto.getBirthdate().getYear())))
                    * activityService.getByTitle(dto.getActivity_title()).getCoefficient());
            log.info("CALORIES_CALCULATE" + result);
            return result;
        }
        return 0;
    }


}
