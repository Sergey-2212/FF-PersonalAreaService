package ru.findfood.PersonalArea.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.findfood.PersonalArea.converters.PersonInfoConverter;
import ru.findfood.PersonalArea.dtos.EmailToNewEmail;
import ru.findfood.PersonalArea.dtos.PersonInfoDto;
import ru.findfood.PersonalArea.entities.PersonInfo;
import ru.findfood.PersonalArea.exceptions.NotFoundException;
import ru.findfood.PersonalArea.repositories.PersonInfoRepository;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonInfoService {

    private final PersonInfoRepository personInfoRepository;
    private final PersonInfoConverter personInfoConverter;

    public PersonInfo getById(Long id) {
        return personInfoRepository.findById(id).orElseThrow(
                () -> new NotFoundException("PersonInfo is not found by id - " + id));
    }
    public PersonInfo getByEmail(String email) {
        return personInfoRepository.findByEmail(email).orElseThrow(
                () -> new NotFoundException("PersonInfo is not found by email - " + email));
    }
    public PersonInfo getByTelegramName(String telegramName) {
        return personInfoRepository.findByTelegramName(telegramName).orElseThrow(
                () -> new NotFoundException("PersonInfo is not found by telegram name - " + telegramName)
        );
    }

    public void changePersonEmail(EmailToNewEmail emailToNewEmail){
        Optional<PersonInfo> personInfoOptional = personInfoRepository.findByEmail(emailToNewEmail.getEmail());
        if (personInfoOptional.isPresent()){
            PersonInfo personInfo = personInfoOptional.get();
            personInfo.setEmail(emailToNewEmail.getNewEmail());
            personInfoRepository.save(personInfo);
        }else {
            throw new NotFoundException("Информация с email " + emailToNewEmail.getEmail() + " не найдена");
        }
    }
    public void updateInfo(PersonInfoDto infoDto) {
        //обновление только данных профиля пользователя без анкеты
        log.info("updateProfilePerson + \n " + infoDto);

        PersonInfo personInfo = getPersonInfoWithCorrectUpdateValues(infoDto);

        personInfoRepository.save(personInfo);
    }
    private PersonInfo getPersonInfoWithCorrectUpdateValues(PersonInfoDto infoDto){
        PersonInfo personInfo = getById(infoDto.getId());

        if(infoDto.getFirstname() != null){
            personInfo.setFirstname(infoDto.getFirstname());
        }
        if(infoDto.getSurname() != null){
            personInfo.setSurname(infoDto.getSurname());
        }
        if(infoDto.getLastname() != null){
            personInfo.setLastname(infoDto.getLastname());
        }
        if(infoDto.getIndex() != null){
            personInfo.setIndex(infoDto.getIndex());
        }
        if(infoDto.getCity() != null){
            personInfo.setCity(infoDto.getCity());
        }
        if(infoDto.getStreet() != null){
            personInfo.setStreet(infoDto.getStreet());
        }
        if(infoDto.getHouse() != null){
            personInfo.setHouse(infoDto.getHouse());
        }
        if(infoDto.getApartment() != null){
            personInfo.setApartment(infoDto.getApartment());
        }
        if(infoDto.getPhoneNumber() != null){
            personInfo.setPhoneNumber(infoDto.getPhoneNumber());
        }
        if(infoDto.getEmail() != null){
            personInfo.setEmail(infoDto.getEmail());
        }
        if(infoDto.getTelegramName() != null){
            personInfo.setTelegramName(infoDto.getTelegramName());
        }

        return personInfo;
    }
}
