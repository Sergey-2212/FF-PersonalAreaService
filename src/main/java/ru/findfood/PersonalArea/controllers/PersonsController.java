package ru.findfood.PersonalArea.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.findfood.PersonalArea.services.PersonService;

@Slf4j
@RestController
@RequestMapping("/api/v1/persons")
@RequiredArgsConstructor
@Tag(name = "Личный кабинет", description = "Набор методов для взаимодействия с сервисом Личный кабинет")
public class PersonsController {

    private final PersonService personService;

}
