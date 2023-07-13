package ru.findfood.PersonalArea.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.findfood.PersonalArea.converters.PersonConverter;
import ru.findfood.PersonalArea.dtos.PersonDto;
import ru.findfood.PersonalArea.exceptions.NotFoundException;
import ru.findfood.PersonalArea.repositories.PersonRepository;
import ru.findfood.PersonalArea.validators.EntityValidator;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
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
        log.info("createPerson + \n " + dto.toString());
        validator.checkPersonDto(dto);
        log.info("createPerson + personConverter.dtoToEntity(dto).toString()" + personConverter.dtoToEntity(dto).toString());
        return personConverter.entityToDto(
                personRepository.save(
                        personConverter.dtoToEntity(dto)));
    }
}
