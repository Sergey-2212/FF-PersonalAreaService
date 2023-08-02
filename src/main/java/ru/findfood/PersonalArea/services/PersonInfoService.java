package ru.findfood.PersonalArea.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.findfood.PersonalArea.entities.PersonInfo;
import ru.findfood.PersonalArea.exceptions.NotFoundException;
import ru.findfood.PersonalArea.repositories.PersonInfoRepository;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonInfoService {

    private final PersonInfoRepository personInfoRepository;

    public PersonInfo getById(Long id) {
        return personInfoRepository.findById(id).orElseThrow(
                () -> new NotFoundException("PersonInfo is not found by id - " + id));
    }

    public PersonInfo getByTelegramName(String telegramName) {
        return personInfoRepository.findByTelegramName(telegramName).orElseThrow(
                () -> new NotFoundException("PersonInfo is not found by telegram name - " + telegramName)
        );
    }

    public PersonInfo findByTelegramName(String username) {
        return personInfoRepository.findByTelegramName(username).orElseThrow(
                () -> new NotFoundException("PersonInfo is not found by username - " + username));
    }
}
