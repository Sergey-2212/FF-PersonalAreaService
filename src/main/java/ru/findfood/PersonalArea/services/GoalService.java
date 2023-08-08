package ru.findfood.PersonalArea.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.findfood.PersonalArea.dtos.PersonDto;
import ru.findfood.PersonalArea.entities.Goal;
import ru.findfood.PersonalArea.enums.GoalTitle;
import ru.findfood.PersonalArea.exceptions.NotFoundException;
import ru.findfood.PersonalArea.repositories.GoalRepository;
import ru.findfood.PersonalArea.utils.CaloriesCalculation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GoalService {
    private final GoalRepository goalRepository;
    private final CaloriesCalculation caloriesCalculation;

    private final int CALORIES_IN_PROTEIN = 4;
    private final int CALORIES_IN_FAT = 9;
    private final int CALORIES_IN_CARBOHYDRATE = 4;
    private Map<String, List<Float>> nutrition;

    @PostConstruct
    private void nutritionInitializer() {
        nutrition = new HashMap<>();
        nutrition.put(
                GoalTitle.LOSE_WEIGHT.toString(),
                List.of(0.4F, 0.35F, 0.25F)
        );
        nutrition.put(
                GoalTitle.KEEP_WEIGHT.toString(),
                List.of(0.3F, 0.2F, 0.5F)
        );
        nutrition.put(
                GoalTitle.GET_WEIGHT.toString(),
                List.of(0.3F, 0.3F, 0.4F)
        );
    }


    public Goal getById(Long id) {
        return  goalRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Goal is not found by Id - " + id)
        );
    }

    public Goal getByPersonDto(PersonDto dto) {
        return  goalRepository.findById(dto.getGoal().getId()).orElse(calculateGoalByPersonDto(dto));
    }

    public List<String> getAllTitles() {
           return nutrition.keySet().stream().toList();

    }

    public Goal calculateGoalByPersonDto (PersonDto dto) {
        int calories = caloriesCalculation.getCaloriesByPersonDto(dto);
        Goal goal = new Goal();
        goal.setTitle(dto.getGoal().getTitle());
        goal.setProtein((int) (calories * nutrition.get(dto.getGoal().getTitle()).get(0) / CALORIES_IN_PROTEIN));
        goal.setFat((int) (calories * nutrition.get(dto.getGoal().getTitle()).get(1) / CALORIES_IN_FAT));
        goal.setCarbohydrate((int) (calories * nutrition.get(dto.getGoal().getTitle()).get(2) / CALORIES_IN_CARBOHYDRATE));
        return goal;

    }

}
