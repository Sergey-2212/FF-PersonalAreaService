package ru.findfood.PersonalArea.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.findfood.PersonalArea.converters.PersonInfoConverter;
import ru.findfood.PersonalArea.repositories.PersonRepository;
import ru.findfood.PersonalArea.validators.EntityValidator;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonInfoService {

    private PersonRepository personRepository;
    private EntityValidator validator;
    private PersonInfoConverter converter;
}
