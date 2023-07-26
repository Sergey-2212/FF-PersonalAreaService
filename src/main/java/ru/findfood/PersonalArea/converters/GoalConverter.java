package ru.findfood.PersonalArea.converters;

import org.springframework.stereotype.Component;
import ru.findfood.PersonalArea.dtos.GoalDto;
import ru.findfood.PersonalArea.entities.Goal;

@Component
public class GoalConverter {

    public Goal dtoToEntity(GoalDto dto) {
        Goal goal = new Goal();
        goal.setId(dto.getId());
        goal.setTitle(dto.getTitle());
        goal.setProtein(dto.getProtein());
        goal.setFat(dto.getFat());
        goal.setCarbohydrate(dto.getCarbohydrate());
        return goal;
    }


    public GoalDto entityToDto (Goal goal) {
        GoalDto dto = new GoalDto();
        dto.setId(goal.getId());
        dto.setTitle(goal.getTitle());
        dto.setCarbohydrate(goal.getCarbohydrate());
        dto.setFat(goal.getFat());
        dto.setProtein(goal.getProtein());
        return dto;
    }
}
