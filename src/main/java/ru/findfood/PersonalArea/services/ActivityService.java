package ru.findfood.PersonalArea.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.findfood.PersonalArea.entities.Activity;
import ru.findfood.PersonalArea.exceptions.NotFoundException;
import ru.findfood.PersonalArea.repositories.ActivityRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;

    public Activity getByTitle(String title) {
        return activityRepository.findByTitle(title).orElseThrow(
                () -> new NotFoundException("Activity is not found by title - " + title));

    }

    public Activity getById(Long id) {
        return activityRepository.findById(id).orElseThrow(
                        () -> new NotFoundException("Activity is not found by title - " + id));
    }

    public List<String> getAllTitles() {
        List<Activity> activities = activityRepository.findAll();
        return activities.stream().map(s -> s.getTitle()).collect(Collectors.toList());
    }

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }
 }
