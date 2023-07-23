package ru.findfood.PersonalArea.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import ru.findfood.PersonalArea.entities.Goal;
import ru.findfood.PersonalArea.repositories.GoalRepository;

import java.util.Collections;
import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
public class GoalRepositoryTest {
    @Autowired
    private GoalRepository goalRepository;



    @Test
    public void findAllGoalsTest() {
        List<Goal> list = goalRepository.findAll();
        Goal testGoal = new Goal();
        testGoal.setId(1L);
        testGoal.setCarbohydrate(1);
        testGoal.setFat(1);
        testGoal.setTitle("Keep");
        testGoal.setProtein(1);
        testGoal.setPersons(Collections.emptyList());

        Assertions.assertEquals(list.size(), 3);
        Assertions.assertEquals(list.get(0).getTitle(), "Keep");


    }
}
