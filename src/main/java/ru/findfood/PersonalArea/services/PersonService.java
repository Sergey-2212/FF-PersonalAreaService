package ru.findfood.PersonalArea.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.findfood.PersonalArea.converters.PersonConverter;
import ru.findfood.PersonalArea.dtos.PersonDto;
import ru.findfood.PersonalArea.entities.Person;
import ru.findfood.PersonalArea.exceptions.NotFoundException;
import ru.findfood.PersonalArea.repositories.PersonInfoRepository;
import ru.findfood.PersonalArea.repositories.PersonRepository;
import ru.findfood.PersonalArea.validators.EntityValidator;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonInfoRepository personInfoRepository;
    private final EntityValidator validator;
    private final PersonConverter personConverter;


    public Person getPersonByUsername(String username) {
        log.info("getPersonByUsername + " + username);
        return personRepository.findPersonByUsername(username).orElseThrow(
                        () -> new NotFoundException("Person is not found by username - " + username));
    }

    public Person getPersonById(Long id) {
        log.info("getPersonById + " + id);
        return personRepository.findPersonById(id).orElseThrow(
                        () -> new NotFoundException("Person is not found by Id - " + id));
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person updatePerson(PersonDto dto) {
        log.info("updatePerson + \n " + dto);
        validator.checkPersonDto(dto);
        return personRepository.save(
                        personConverter.dtoToEntity(dto));
    }

    public Person createNewPerson(PersonDto dto) {
        dto.setId(null);
        log.info("createPerson + \n " + dto);
        validator.checkPersonDto(dto);
        log.info("createPerson + personConverter.dtoToEntity(dto).toString()" + personConverter.dtoToEntity(dto).toString());
        return personRepository.save(
                        personConverter.dtoToEntity(dto));
    }

    public void removePersonById(Long id) {
        personRepository.deleteById(id);
    }

    public void removePersonByUsername(String username) {
        personRepository.deletePersonByUsername(username);

    }

}
