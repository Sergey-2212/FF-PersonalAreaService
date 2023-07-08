package ru.findfood.PersonalArea.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.findfood.PersonalArea.repositories.PersonRepository;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;



}
