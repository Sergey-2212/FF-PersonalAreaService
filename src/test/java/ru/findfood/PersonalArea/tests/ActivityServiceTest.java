package ru.findfood.PersonalArea.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.findfood.PersonalArea.entities.Activity;
import ru.findfood.PersonalArea.enums.ActivityTitle;
import ru.findfood.PersonalArea.exceptions.NotFoundException;
import ru.findfood.PersonalArea.repositories.ActivityRepository;
import ru.findfood.PersonalArea.services.ActivityService;

import java.security.PrivateKey;
import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = ActivityService.class)
public class ActivityServiceTest {

    @Autowired
    private ActivityService activityService;
    @MockBean
    private ActivityRepository activityRepository;

    private Activity getTestEntity(Long id) {
        Activity activity = new Activity();
        activity.setId(id);
        activity.setTitle(ActivityTitle.MIN_ACTIVITY.toString());
        return activity;
    }

    private List<Activity> getListOfTestEntities() {
        return List.of(
                new Activity(ActivityTitle.MIN_ACTIVITY.toString(), 1F),
                new Activity(ActivityTitle.LOW_ACTIVITY.title.toString(), 2F),
                new Activity(ActivityTitle.MEDIUM_ACTIVITY.toString(), 3F),
                new Activity(ActivityTitle.HIGH_ACTIVITY.toString(), 4F),
                new Activity(ActivityTitle.EXTREME_ACTIVITY.toString(), 5F));

    }

    @Test
    public void getActivityByTitleTest() {
        Activity activity = getTestEntity(1L);
        Mockito.doReturn(Optional.of(activity)).when(activityRepository).findByTitle(ActivityTitle.MIN_ACTIVITY.toString());
        Mockito.doThrow(NotFoundException.class).when(activityRepository).findByTitle("activity");
        Assertions.assertEquals(ActivityTitle.MIN_ACTIVITY.toString(), activityService.getActivityByTitle(ActivityTitle.MIN_ACTIVITY.toString()).getTitle());
        Assertions.assertThrows(NotFoundException.class, () -> activityService.getActivityByTitle("activity"));
    }

    @Test
    public void getActivityByIdTest() {
        Activity activity = getTestEntity(1L);
        Mockito.doReturn(Optional.of(activity)).when(activityRepository).findById(1L);
        Mockito.doThrow(NotFoundException.class).when(activityRepository).findById(2L);
        Assertions.assertEquals(ActivityTitle.MIN_ACTIVITY.toString(), activityService.getActivityById(1L).getTitle());
        Assertions.assertThrows(NotFoundException.class, () -> activityService.getActivityById(2L));
    }

    @Test
    public void listOfActivityTitlesTest() {
        Mockito.doReturn(getListOfTestEntities()).when(activityRepository).findAll();
        Assertions.assertEquals(ActivityTitle.MIN_ACTIVITY.toString(), activityService.listOfActivityTitles().get(0));
    }

    @Test
    public void getAllActivitiesTest() {
        Mockito.doReturn(getListOfTestEntities()).when(activityRepository).findAll();
        Assertions.assertEquals(5, activityService.getAllActivities().size());
    }

}
