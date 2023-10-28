package ru.findfood.PersonalArea.utils;

import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;

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
import ru.findfood.PersonalArea.repositories.PersonRepository;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataGenerator {

    private final ActivityRepository activityRepository;
    private final GoalRepository goalRepository;
    private final PersonRepository personRepository;


    @PostConstruct
    public void generateData() {
        Faker faker = new Faker();


        List<Activity> activities = List.of(
                new Activity(ActivityTitle.MIN_ACTIVITY.toString(), 1F),
                new Activity(ActivityTitle.LOW_ACTIVITY.title.toString(), 2F),
                new Activity(ActivityTitle.MEDIUM_ACTIVITY.toString(), 3F),
                new Activity(ActivityTitle.HIGH_ACTIVITY.toString(), 4F),
                new Activity(ActivityTitle.EXTREME_ACTIVITY.toString(), 5F),
                new Activity(ActivityTitle.NO_DATA.toString(), 0F));
        activityRepository.saveAll(activities);

        //Создаю Goal
        List<Goal> goals = List.of(
                new Goal(GoalTitle.LOSE_WEIGHT.toString(), 1, 1, 1),
                new Goal(GoalTitle.KEEP_WEIGHT.toString(), 2, 2, 2),
                new Goal(GoalTitle.GET_WEIGHT.toString(), 3, 3, 3),
                new Goal(GoalTitle.NO_DATA.toString(), 0, 0, 0)
        );
        goalRepository.saveAll(goals);


        //Создаю анкеты пользователей

        Person person1 = new Person();
        PersonInfo personInfo1 = new PersonInfo();
        personInfo1.setPerson(person1);
        person1.setPersonInfo(personInfo1);
        personRepository.save(person1);

        personInfo1.setEmail("admin@gmail.com");
        personInfo1.setCity("Москва");
        personInfo1.setFirstname("Сергей");
        personInfo1.setLastname("Петров");
        personInfo1.setIndex(127576);
        personInfo1.setStreet("Абрамцевская");
        personInfo1.setHouse("10");
        personInfo1.setApartment((short) 10);
        personInfo1.setPhoneNumber("+7-910-605-26-44");

        person1.setUsername("Admin");
        person1.setSex(Sex.MALE);
        person1.setGoal(goalRepository.findByTitle(GoalTitle.NO_DATA.toString()).get());
        person1.setActivity(activityRepository.findByTitle(ActivityTitle.NO_DATA.toString()).get());
        personRepository.save(person1);

        Person person2 = new Person();
        PersonInfo personInfo2 = new PersonInfo();
        personInfo2.setPerson(person2);
        person2.setPersonInfo(personInfo2);
        personRepository.save(person2);

        personInfo2.setEmail("revaz@gmail.com");
        personInfo2.setCity("Москва");
        personInfo2.setFirstname("Реваз");
        personInfo2.setSurname("Вахтангович");
        personInfo2.setLastname("Челебадзе");
        personInfo2.setIndex(125315);
        personInfo2.setStreet("Ленинградский пр-т");
        personInfo2.setHouse("76");
        personInfo2.setApartment((short) 102);
        personInfo2.setPhoneNumber("+7-985-715-82-26");

        person2.setUsername("Revaz");
        person2.setSex(Sex.MALE);
        person2.setGoal(goalRepository.findByTitle(GoalTitle.NO_DATA.toString()).get());
        person2.setActivity(activityRepository.findByTitle(ActivityTitle.NO_DATA.toString()).get());
        personRepository.save(person2);

        Person person3 = new Person();
        PersonInfo personInfo3 = new PersonInfo();
        personInfo3.setPerson(person3);
        person3.setPersonInfo(personInfo3);
        personRepository.save(person3);

        personInfo3.setEmail("basil@gmail.com");
        personInfo3.setCity("Москва");
        personInfo3.setFirstname("Василий");
        personInfo3.setLastname("Иванов");
        personInfo3.setStreet("Никольская");
        personInfo3.setPhoneNumber("+7-977-435-22-42");

        person3.setUsername("Basil");
        person3.setSex(Sex.MALE);
        person3.setBirthdate(LocalDate.of(1993,5,10));
        person3.setHeight(180);
        person3.setWeight(90);
        person3.setGoal(goalRepository.findByTitle(GoalTitle.KEEP_WEIGHT.toString()).get());
        person3.setActivity(activityRepository.findByTitle(String.valueOf(ActivityTitle.MIN_ACTIVITY)).get());
        personRepository.save(person3);



        Person person4 = new Person();
        PersonInfo personInfo4 = new PersonInfo();
        personInfo4.setPerson(person4);
        person4.setPersonInfo(personInfo4);
        personRepository.save(person4);

        personInfo4.setEmail("jeanne@gmail.com");
        personInfo4.setCity("Санкт-Петербург");
        personInfo4.setFirstname("Жанна");
        personInfo4.setLastname("Седунова");
        personInfo4.setStreet("Пушкинская");
        personInfo4.setPhoneNumber("+7-981-435-22-42");


        person4.setUsername("Jeanne");
        person4.setSex(Sex.FEMALE);
        person4.setBirthdate(LocalDate.of(2003,9,6));
        person4.setHeight(170);
        person4.setWeight(65);
        person4.setGoal(goalRepository.findByTitle(GoalTitle.LOSE_WEIGHT.toString()).get());
        person4.setActivity(activityRepository.findByTitle(ActivityTitle.MEDIUM_ACTIVITY.toString()).get());
        personRepository.save(person4);


    }
}
