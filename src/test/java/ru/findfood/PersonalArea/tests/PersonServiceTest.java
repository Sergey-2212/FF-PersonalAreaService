package ru.findfood.PersonalArea.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.findfood.PersonalArea.converters.PersonConverter;
import ru.findfood.PersonalArea.dtos.PersonDto;
import ru.findfood.PersonalArea.entities.Activity;
import ru.findfood.PersonalArea.entities.Goal;
import ru.findfood.PersonalArea.entities.Person;
import ru.findfood.PersonalArea.entities.PersonInfo;
import ru.findfood.PersonalArea.exceptions.NotFoundException;
import ru.findfood.PersonalArea.repositories.PersonRepository;
import ru.findfood.PersonalArea.services.PersonService;
import ru.findfood.PersonalArea.validators.EntityValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = {PersonService.class})
public class PersonServiceTest {

    @Autowired
    private PersonService personService;
    @MockBean
    private PersonRepository personRepository;
    @MockBean
    private EntityValidator validator;
    @MockBean
    private PersonConverter personConverter;

    private Person getTestEntity(Long id, String username) {
        PersonInfo personInfo = new PersonInfo();
        personInfo.setId(id);
        Person person = new Person();
        person.setPersonInfo(personInfo);
        person.setId(id);
        person.setUsername(username);
        person.setActivity(new Activity());
        person.setGoal(new Goal());
        return person;
    }

    private List<Person> getTestEntityList(Integer size) {
        List<Person> list = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            list.add(getTestEntity((long) i+1, "test" + i+1));
        }
        return list;
    }

    @Test
    public void getPersonByUsernameTest() {
        Person person = getTestEntity(1L, "test");
        Mockito.doReturn(Optional.of(person)).when(personRepository).findPersonByUsername("test");
        Mockito.doThrow(new NotFoundException("getPersonByUsernameTest")).when(personRepository).findPersonByUsername("test1");
        Person getByUsernamePerson = personService.getByUsername("test");
        Assertions.assertEquals("test", getByUsernamePerson.getUsername());
        Assertions.assertThrows(NotFoundException.class, () -> personService.getByUsername("test1"), "getPersonByUsernameTesttest1");
    }

    @Test
    public void getPersonByIdTest() {
        Person person = getTestEntity(1L, "test");
        Mockito.doReturn(Optional.of(person)).when(personRepository).findPersonById(1L);
        Mockito.doThrow(new NotFoundException("getPersonByIdTest")).when(personRepository).findPersonById(2L);
        person = personService.getById(1L);
        Assertions.assertEquals("test", person.getUsername());
        Assertions.assertThrows(NotFoundException.class,() -> personService.getById(2L),String.format("getPersonByIdTest%s" , 2L));
    }

    @Test
    public void getAllPersonsTest() {
        Mockito.doReturn(getTestEntityList(5)).when(personRepository).findAll();
        Assertions.assertEquals( 5L, personService.getAllPersons().get(4).getId());
    }

    @Test
    public void updatePersonTest() {
        PersonDto dto = new PersonDto();
        Person person = getTestEntity(1L, "test");
        Mockito.doReturn(person).when(personConverter).dtoToEntity(dto);
        Mockito.doReturn(person).when(personRepository).save(person);
        Person updatedPerson = personService.update(dto);
        Assertions.assertEquals("test", updatedPerson.getUsername());
    }

    @Test
    public void createNewPersonTest() {
        Person person = getTestEntity(1L, "test");
        PersonDto inputDto = new PersonDto();
        inputDto.setId(1L);
        Mockito.doReturn(person).when(personConverter).dtoToEntity(new PersonDto());
        Mockito.doReturn(person).when(personRepository).save(person);
        Person newPerson = personService.create(inputDto);
        Assertions.assertEquals(1L, newPerson.getId());
    }
    @Test
    public void removePersonByIdTest() {
        personService.removeById(1L);
        Mockito.verify(personRepository, Mockito.times(1)).deleteById(1L);
    }

    @Test
    public void removePersonByUsernameTest() {
        personService.removeByUsername("test");
        Mockito.verify(personRepository, Mockito.times(1)).deletePersonByUsername("test");
    }
}
