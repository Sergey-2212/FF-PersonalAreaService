package ru.findfood.PersonalArea.converters;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.findfood.PersonalArea.dtos.PersonDto;
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

    public PersonDto entityToDto (Person person) {
        log.info("entityToDTOConverter - " + person.toString());
        return new PersonDto(
                person.getId(),
                person.getUsername(),
                person.getSex().toString(),
                person.getBirthdate(),
                person.getWeight(),
                person.getHeight(),
                person.getActivity().toString(),
                person.getGoal().getTitle().toString(),
                person.getPersonInfo().getId());

    }

    public Person dtoToEntity (PersonDto personDto) {
        return new Person (
                personDto.getId(),
                personDto.getUsername(),
                Sex.valueOf(personDto.getSex()), //throws IllegalArgumentException if isn't found.
                personDto.getBirthdate(),
                personDto.getWeight(),
                personDto.getHeight(),
                activityRepository.findByTitle(personDto.getActivity_title()).orElseThrow(
                        () -> new NotFoundException("Activity is not found by title - " + personDto.getActivity_title())),
                goalRepository.findByTitle(personDto.getGoal_title()).orElseThrow(
                        () -> new NotFoundException("Goal is not found by title - " + personDto.getGoal_title())),
                personInfoRepository.findById(personDto.getInfo_id()).orElseThrow(
                        () -> new NotFoundException("PersonInfoRepository isn't found by id - " + personDto.getInfo_id())
                )
        );
    }

}
