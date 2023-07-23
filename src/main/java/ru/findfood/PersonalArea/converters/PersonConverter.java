package ru.findfood.PersonalArea.converters;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.findfood.PersonalArea.dtos.PersonDto;
import ru.findfood.PersonalArea.dtos.PersonInfoDto;
import ru.findfood.PersonalArea.entities.Person;
import ru.findfood.PersonalArea.entities.PersonInfo;
import ru.findfood.PersonalArea.enums.Sex;
import ru.findfood.PersonalArea.services.ActivityService;
import ru.findfood.PersonalArea.services.GoalService;
import ru.findfood.PersonalArea.services.PersonInfoService;

@Slf4j
@Component
@RequiredArgsConstructor
public class PersonConverter {
    private final ActivityService activityService;
    private final GoalService goalService;
    private final PersonInfoService personInfoService;
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
        Person person = new Person();
            person.setId(personDto.getId());
                person.setUsername(personDto.getUsername());
                person.setSex(Sex.getBySex(personDto.getSex()));//throws IllegalArgumentException if isn't found.
                person.setBirthdate(personDto.getBirthdate());
                person.setWeight(personDto.getWeight());
                person.setHeight(personDto.getHeight());
                person.setActivity(
                        activityService.getActivityByTitle(personDto.getActivity_title()));
                person.setGoal(
                        goalService.getGoalByTitle(personDto.getGoal_title()));
                person.setPersonInfo(checkPersonInfoOnNull(personDto.getInfo_dto(), person));
        log.info("Person dtoToEntity - " + person);
        return person;
    }

    private PersonInfo checkPersonInfoOnNull (PersonInfoDto personInfoDto, Person person) {
        if(personInfoDto == null) {
            PersonInfo personInfo = new PersonInfo();
            return personInfo;
        } else {
            return personInfoConverter.dtoToEntity(personInfoDto);
        }
    }


}
