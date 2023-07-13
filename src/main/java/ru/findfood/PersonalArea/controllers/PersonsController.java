package ru.findfood.PersonalArea.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.findfood.PersonalArea.dtos.PersonDto;
import ru.findfood.PersonalArea.services.PersonService;

@Slf4j
@RestController
@RequestMapping("/api/v1/persons")
@RequiredArgsConstructor
@Tag(name = "Личный кабинет", description = "Набор методов для взаимодействия с сервисом Личный кабинет")
public class PersonsController {
    private final PersonService personService;

    @GetMapping("/person")
    public PersonDto getPerson(@RequestHeader String username) {
        return personService.getPersonByUsername(username);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDto createNewPerson(@RequestBody PersonDto dto, @RequestHeader String username) {
            if(!dto.getUsername().equals(username)) {
                throw new SecurityException(String.format("Usernames of dto(%s) and header(%s) arn't match ", dto.getUsername(), username));
            }
        return personService.createPerson(dto);
    }


}
