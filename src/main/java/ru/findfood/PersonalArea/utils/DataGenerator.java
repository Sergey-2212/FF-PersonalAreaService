package ru.findfood.PersonalArea.utils;

import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.findfood.PersonalArea.entities.Activity;
import ru.findfood.PersonalArea.entities.Goal;
import ru.findfood.PersonalArea.entities.Person;
import ru.findfood.PersonalArea.entities.PersonInfo;
import ru.findfood.PersonalArea.enums.ActivityTitle;
import ru.findfood.PersonalArea.enums.GoalTitle;
import ru.findfood.PersonalArea.enums.Sex;
import ru.findfood.PersonalArea.repositories.ActivityRepository;
import ru.findfood.PersonalArea.repositories.GoalRepository;
import ru.findfood.PersonalArea.repositories.PersonInfoRepository;
import ru.findfood.PersonalArea.repositories.PersonRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataGenerator {

    private final ActivityRepository activityRepository;
    private final GoalRepository goalRepository;
    private final PersonRepository personRepository;
    private final PersonInfoRepository personInfoRepository;

    //@Transactional
    @PostConstruct
    public void generateData() {
        Faker faker = new Faker();

        //Создаю Activity
        List<Activity> activities = List.of(
            new Activity(ActivityTitle.MIN_ACTIVITY.toString(), 1F),
            new Activity(ActivityTitle.LOW_ACTIVITY.title.toString(), 2F),
            new Activity(ActivityTitle.MEDIUM_ACTIVITY.toString(), 3F),
            new Activity(ActivityTitle.HIGH_ACTIVITY.toString(), 4F),
            new Activity(ActivityTitle.EXTREME_ACTIVITY.toString(), 5F));
        activityRepository.saveAll(activities);

        //Создаю Goal
        List<Goal> goals = List.of(
                new Goal(GoalTitle.LOSE_WEIGHT.toString(), 1, 1, 1),
                new Goal(GoalTitle.KEEP_WEIGHT.toString(), 2, 2, 2),
                new Goal(GoalTitle.GET_WEIGHT.toString(), 3, 3, 3)
        );
        goalRepository.saveAll(goals);

        //Создаю анкеты пользователей

//        Person person1 = new Person(
//                "test1",
//                Sex.FEMALE,
//                LocalDate.of(1985,10,12),
//                56,
//                165,
//                new Activity(ActivityTitle.MIN_ACTIVITY.toString(), 1F),
//                new Goal(GoalTitle.LOSE_WEIGHT.toString(), 1F, 1F, 1F)
//                );
//
//        Person savedPerson = personRepository.save(person1);
//        PersonInfo personInfo1 = new PersonInfo();
//        personInfo1.setCity("city");
//        personInfo1.setPerson(savedPerson);
//        personInfoRepository.save(personInfo1);
        //person1.setPersonInfo(personInfo1);



//        Person person1 = new Person();
//        person1.setUsername("test");
//        Person savedPerson = personRepository.save(person1);

        PersonInfo personInfo1 = new PersonInfo();
        personInfo1.setCity("city");
//        personInfo1.setPerson(savedPerson);
//        personInfo1 = personInfoRepository.save(personInfo1);
        log.info("PERSONINFO1 - " + personInfo1);

        Person person1 = new Person();
        person1.setUsername("test");
        person1.setPersonInfo(personInfo1);
        Person savedPerson = personRepository.save(person1);
        log.info("SAVEDPERSON - " + savedPerson);

        savedPerson.setActivity(new Activity(ActivityTitle.MIN_ACTIVITY.toString(), 1F));
        personRepository.save(savedPerson);
        log.info("SAVEDPERSON - " + savedPerson);



        PersonInfo personInfo2 = new PersonInfo();
        personInfo2.setEmail("email@email.com");
        Person person2 = new Person();
        person2.setUsername("test2");
        person2.setPersonInfo(personInfo2);
        person2 = personRepository.save(person2);
        log.info("SAVEDPERSON - " + person2);








    }


}
