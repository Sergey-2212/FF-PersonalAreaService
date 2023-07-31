package ru.findfood.PersonalArea.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.findfood.PersonalArea.entities.Goal;
import ru.findfood.PersonalArea.enums.GoalTitle;
import ru.findfood.PersonalArea.exceptions.NotFoundException;
import ru.findfood.PersonalArea.repositories.GoalRepository;
import ru.findfood.PersonalArea.services.GoalService;
import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = GoalService.class)
public class GoalServiceTest {
    @Autowired
    private GoalService goalService;
    @MockBean
    private GoalRepository goalRepository;

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
                GoalTitle.GET_WEIGHT.toString(),
                GoalTitle.KEEP_WEIGHT.toString(),
                GoalTitle.LOSE_WEIGHT.toString()
        );
        return list;
    }

    @Test
    public void getGoalByIdTest() {
        Goal goal = getTestEntity(2L);
        Mockito.doReturn(Optional.of(goal)).when(goalRepository).findById(2L);
        Mockito.doThrow(NotFoundException.class).when(goalRepository).findById(3L);
        Assertions.assertEquals(getTestEntity(2L), goalService.getById(2L));
        Assertions.assertThrows(NotFoundException.class, () -> goalService.getById(3L));

    }
    @Test
    public void getByTitleTest() {
        Goal goal = getTestEntity(2L);
        Mockito.doReturn(Optional.of(goal)).when(goalRepository).findByTitle(GoalTitle.GET_WEIGHT.toString());
        Mockito.doThrow(NotFoundException.class).when(goalRepository).findByTitle("title");
        Assertions.assertEquals(GoalTitle.GET_WEIGHT, goalService.getByTitle(GoalTitle.GET_WEIGHT.title));
        Assertions.assertThrows(NotFoundException.class, () -> goalService.getByTitle("title"));
    }
    @Test
    public void getAllTitlesTest() {
        Mockito.doReturn(getTestEntityList()).when(goalRepository).findAll();
        Assertions.assertEquals(getTitleList(), goalService.getAllTitles());
    }

    public void getByUsernameTest() {

    }


}
