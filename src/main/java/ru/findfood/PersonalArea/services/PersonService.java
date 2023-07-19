package ru.findfood.PersonalArea.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.findfood.PersonalArea.converters.PersonConverter;
import ru.findfood.PersonalArea.dtos.GoalDto;
import ru.findfood.PersonalArea.dtos.PersonDto;
import ru.findfood.PersonalArea.entities.PersonInfo;
import ru.findfood.PersonalArea.exceptions.NotFoundException;
import ru.findfood.PersonalArea.repositories.PersonInfoRepository;
import ru.findfood.PersonalArea.repositories.PersonRepository;
import ru.findfood.PersonalArea.validators.EntityValidator;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonInfoRepository personInfoRepository;
    private final EntityValidator validator;
    private final PersonConverter personConverter;


    public PersonDto getPersonByUsername(String username) {
        log.info("getPersonByUsername + " + username);
        return personConverter.entityToDto(
                personRepository.findPersonByUsername(username).orElseThrow(
                        () -> new NotFoundException("Person is not found by username - " + username)
                ));
    }

    public PersonDto getPersonById(Long id) {
        log.info("getPersonById + " + id);
        return personConverter.entityToDto(
                personRepository.findPersonById(id).orElseThrow(
                        () -> new NotFoundException("Person is not found by Id - " + id)
                ));

    }

    public List<PersonDto> getAllPersons() {
        return personRepository.findAll().stream().map(s -> personConverter.entityToDto(s)).collect(Collectors.toList());
    }

    public PersonDto updatePerson(PersonDto dto) {
        log.info("updatePerson + \n " + dto.toString());
        validator.checkPersonDto(dto);
        return personConverter.entityToDto(
                personRepository.save(
                        personConverter.dtoToEntity(dto)));
    }

    public PersonDto createPerson(PersonDto dto) {
        dto.setId(null);
        log.info("createPerson + \n " + dto);
        validator.checkPersonDto(dto);
        log.info("createPerson + personConverter.dtoToEntity(dto).toString()" + personConverter.dtoToEntity(dto).toString());
        return personConverter.entityToDto(
                personRepository.save(
                        personConverter.dtoToEntity(dto)));
    }

    public GoalDto getGoalByTelegramName(String username) {
        PersonInfo info = personInfoRepository.findByTelegramName(username)
                .orElseThrow(() -> new NotFoundException("PersonInfo is not found by telegram name - " + username));
        return personConverter.entityToGoalDto(
                personRepository.findByPersonInfo(info)
                        .orElseThrow(() -> new NotFoundException("Person is not found by personInfo - " + info))
        );
    }

    public GoalDto getGoalByName(String username) {
        return personConverter.entityToGoalDto(
                personRepository.findPersonByUsername(username)
                        .orElseThrow(() -> new NotFoundException("PersonInfo is not found by telegram name - " + username))
        );
    }
}
