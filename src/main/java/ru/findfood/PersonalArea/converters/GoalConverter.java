package ru.findfood.PersonalArea.converters;

import org.springframework.stereotype.Component;
import ru.findfood.PersonalArea.dtos.GoalDto;
import ru.findfood.PersonalArea.entities.Goal;

@Component
public class GoalConverter {

    public GoalDto entityToDto (Goal goal) {
        GoalDto dto = new GoalDto();
        dto.setTitle(goal.getTitle());
        dto.setCarbohydrate(goal.getCarbohydrate());
        dto.setFat(goal.getFat());
        dto.setProtein(goal.getProtein());
        dto.setCalories(goal.getCalories());
        return dto;
    }
}
