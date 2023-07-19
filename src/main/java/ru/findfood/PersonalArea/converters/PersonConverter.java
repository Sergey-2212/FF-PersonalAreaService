package ru.findfood.PersonalArea.converters;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.findfood.PersonalArea.dtos.GoalDto;
import ru.findfood.PersonalArea.dtos.PersonDto;
import ru.findfood.PersonalArea.entities.Goal;
import ru.findfood.PersonalArea.entities.Person;
import ru.findfood.PersonalArea.enums.Sex;
import ru.findfood.PersonalArea.exceptions.NotFoundException;
import ru.findfood.PersonalArea.repositories.ActivityRepository;
import ru.findfood.PersonalArea.repositories.PersonInfoRepository;
import ru.findfood.PersonalArea.repositories.GoalRepository;

@Slf4j
@Component
@RequiredArgsConstructor
public class PersonConverter {
    private final ActivityRepository activityRepository;
    private final GoalRepository goalRepository;
    private final PersonInfoRepository personInfoRepository;
    private final PersonInfoConverter personInfoConverter;

    public PersonDto entityToDto(Person person) {
        log.info("entityToDTOConverter - " + person.toString());
        return new PersonDto(
                person.getId(),
                person.getUsername(),
                person.getSex().toString(),
                person.getBirthdate(),
                person.getWeight(),
                person.getHeight(),
                person.getActivity().getTitle().toString(),
                person.getGoal().getTitle().toString(),
                personInfoConverter.entityToDto(person.getPersonInfo()));
    }

    public Person dtoToEntity(PersonDto personDto) {
        log.info("Person dtoToEntity");
        Person person = new Person(
                personDto.getId(),
                personDto.getUsername(),
                Sex.getBySex(personDto.getSex()), //throws IllegalArgumentException if isn't found.
                personDto.getBirthdate(),
                personDto.getWeight(),
                personDto.getHeight(),
                activityRepository.findByTitle(personDto.getActivity_title()).orElseThrow(
                        () -> new NotFoundException("Activity is not found by title - " + personDto.getActivity_title())),
                goalRepository.findByTitle(personDto.getGoal_title()).orElseThrow(
                        () -> new NotFoundException("Goal is not found by title - " + personDto.getGoal_title())),
                personInfoConverter.dtoToEntity(personDto.getInfo_dto())
        );
        log.info("Person dtoToEntity - " + person);
        return person;
    }


    public GoalDto entityToGoalDto(Person person) {
        Goal goal = person.getGoal();
        return new GoalDto(
                goal.getTitle(),
                goal.getCalories(),
                goal.getProtein(),
                goal.getFat(),
                goal.getCarbohydrate(),
                goal.getTimesToEat()
        );
    }
}
