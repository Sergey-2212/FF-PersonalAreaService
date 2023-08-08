package ru.findfood.PersonalArea.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.findfood.PersonalArea.dtos.GoalDto;
import ru.findfood.PersonalArea.dtos.PersonDto;
import ru.findfood.PersonalArea.dtos.PersonInfoDto;
import ru.findfood.PersonalArea.entities.Goal;
import ru.findfood.PersonalArea.enums.GoalTitle;
import ru.findfood.PersonalArea.exceptions.NotFoundException;
import ru.findfood.PersonalArea.repositories.GoalRepository;
import ru.findfood.PersonalArea.services.GoalService;
import ru.findfood.PersonalArea.utils.CaloriesCalculation;

import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = GoalService.class)
public class GoalServiceTest {
    @Autowired
    private GoalService goalService;
    @MockBean
    private GoalRepository goalRepository;

    @MockBean
    private CaloriesCalculation caloriesCalculation;

    private Goal getTestEntity(Long id) {
        Goal goal = new Goal();
        goal.setTitle(GoalTitle.GET_WEIGHT.title);
        goal.setId(id);
        return goal;
    }

    private List<Goal> getTestEntityList() {
        List<Goal> list = List.of(
                new Goal(GoalTitle.GET_WEIGHT.toString(), 1, 1, 1),
                new Goal(GoalTitle.KEEP_WEIGHT.toString(), 2, 2, 2),
                new Goal(GoalTitle.LOSE_WEIGHT.toString(),  3, 3, 3)
        );
        return list;
    }

    private List<String> getTitleList() {
        List<String> list = List.of(
                GoalTitle.LOSE_WEIGHT.toString(),
                GoalTitle.KEEP_WEIGHT.toString(),
                GoalTitle.GET_WEIGHT.toString()

        );
        return list;
    }

    @Test
    public void getByIdTest() {
        Goal goal = getTestEntity(2L);
        Mockito.doReturn(Optional.of(goal)).when(goalRepository).findById(2L);
        Mockito.doThrow(NotFoundException.class).when(goalRepository).findById(3L);
        Assertions.assertEquals(getTestEntity(2L), goalService.getById(2L));
        Assertions.assertThrows(NotFoundException.class, () -> goalService.getById(3L));

    }

    @Test
    public void getAllTitlesTest() {
        Assertions.assertEquals(getTitleList(), goalService.getAllTitles());
    }
    @Test
    public void getByPersonDtoTest() {
        Goal goal = getTestEntity(1L);
        GoalDto goalDto = new GoalDto();
        goalDto.setTitle(GoalTitle.KEEP_WEIGHT.toString());
        PersonDto dto = new PersonDto();
        dto.setId(1L);
        dto.setInfo_dto(new PersonInfoDto());
        dto.setGoal(goalDto);
        Mockito.doReturn(Optional.of(goal)).when(goalRepository).findById(1L);
        Mockito.doReturn(null).when(goalRepository).findById(2L);
        Mockito.doReturn(1800).when(caloriesCalculation).getCaloriesByPersonDto(dto);
        Assertions.assertEquals(135, goalService.getByPersonDto(dto).getProtein());

    }


}
