package ru.findfood.PersonalArea.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.findfood.PersonalArea.converters.PersonConverter;
import ru.findfood.PersonalArea.dtos.NewPersonDto;
import ru.findfood.PersonalArea.dtos.PersonDto;
import ru.findfood.PersonalArea.entities.Person;
import ru.findfood.PersonalArea.entities.PersonInfo;
import ru.findfood.PersonalArea.enums.ActivityTitle;
import ru.findfood.PersonalArea.enums.GoalTitle;
import ru.findfood.PersonalArea.enums.Sex;
import ru.findfood.PersonalArea.exceptions.NotFoundException;
import ru.findfood.PersonalArea.repositories.ActivityRepository;
import ru.findfood.PersonalArea.repositories.GoalRepository;
import ru.findfood.PersonalArea.repositories.PersonRepository;
import ru.findfood.PersonalArea.services.specifications.PersonSpecifications;
import ru.findfood.PersonalArea.validators.EntityValidator;


import java.util.*;


@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {
    private final GoalRepository goalRepository;
    private final ActivityRepository activityRepository;

    private final PersonRepository personRepository;
    private final EntityValidator validator;
    private final PersonConverter personConverter;

    private final PersonInfoService personInfoService;

    public Person getByUsername(String username) {
        log.info("getPersonByUsername + " + username);
        return personRepository.findPersonByUsername(username).orElseThrow(
                () -> new NotFoundException("Person is not found by username - " + username));
    }
    public Boolean isUserNameFree(String username){
        Optional<Person> person = personRepository.findPersonByUsername(username);
        return person.isEmpty();
    }

    public Person getById(Long id) {
        log.info("getPersonById + " + id);
        return personRepository.findPersonById(id).orElseThrow(
                () -> new NotFoundException("Person is not found by Id - " + id));
    }

    public List<Person> getAllPersons(String partUsername, String partEmail, String partLastname, Collection<String> emailList) {
        Specification<Person> spec = Specification.where(null);

        if (partUsername != null) {
            spec = spec.and(PersonSpecifications.usernameLike(partUsername));
        }

        if (partEmail != null) {
            spec = spec.and(PersonSpecifications.emailLike(partEmail));
        }

        if (partLastname != null) {
            spec = spec.and(PersonSpecifications.lastnameLike(partLastname));
        }

        if (emailList != null) {
            spec = spec.and(PersonSpecifications.getByEmailFromEmailList(emailList));
        }
        return personRepository.findAll(spec);
    }

    public Person updateQuestionnaire(PersonDto dto) {
        //обновление только анкетных данных пользователя без профиля
        log.info("updatePerson + \n " + dto);
        validator.checkPersonDto(dto);

        Person person = getPersonWithCorrectUpdateValues(dto);

        return personRepository.save(person);
    }

    public Person update(PersonDto dto) {
        log.info("updatePerson + \n " + dto);
        validator.checkPersonDto(dto);
        return personRepository.save(personConverter.dtoToEntity(dto));
    }

    @Transactional
    public Person create(NewPersonDto dto) {

//        log.info("createPerson + \n " + dto);
        Person person = new Person();
        PersonInfo personInfo = new PersonInfo();

        person.setUsername(dto.getUsername());
        person.setSex(Sex.NO_DATA);
        person.setGoal(goalRepository.findByTitle(GoalTitle.NO_DATA.toString()).get());
        person.setActivity(activityRepository.findByTitle(ActivityTitle.NO_DATA.toString()).get());

        personInfo.setPerson(person);
        personInfo.setEmail(dto.getEmail());
        person.setPersonInfo(personInfo);

        return personRepository.save(person);
    }

    public void removeById(Long id) {
        personRepository.deleteById(id);
    }

    public void removeByUsername(String username) {
        personRepository.deletePersonByUsername(username);

    }

    public Person getByTelegramName(String username) {
        PersonInfo info = personInfoService.getByTelegramName(username);
        return personRepository.findByPersonInfo(info).orElseThrow(
                () -> new NotFoundException("Person is not found by Telegram name - " + username));
    }

    public Person findByEmail(String email) {
        PersonInfo info = personInfoService.getByEmail(email);
        return personRepository.findByPersonInfo(info).orElseThrow(
                () -> new NotFoundException("Person is not found by email - " + email));
    }
    private Person getPersonWithCorrectUpdateValues(PersonDto dto){

        Person person = getById(dto.getId());

        if(dto.getUsername() != null){
            person.setUsername(dto.getUsername());
        }
        if(dto.getSex() != null){
            person.setSex(Sex.getBySex(dto.getSex()));
        }
        if(dto.getBirthdate() != null){
            person.setBirthdate(dto.getBirthdate());
        }
        if(dto.getWeight() != null){
            person.setWeight(dto.getWeight());
        }
        if(dto.getHeight() != null){
            person.setHeight(dto.getHeight());
        }
        if(dto.getActivity_title() != null){
            person.setActivity(activityRepository.findByTitle(dto.getActivity_title()).get());
        }
        if(dto.getGoal_title() != null){
            person.setGoal(goalRepository.findByTitle(dto.getGoal_title()).get());
        }

        return person;
    }




}
