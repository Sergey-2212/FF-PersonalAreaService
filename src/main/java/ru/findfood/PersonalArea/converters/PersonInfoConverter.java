package ru.findfood.PersonalArea.converters;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.findfood.PersonalArea.dtos.PersonInfoDto;
import ru.findfood.PersonalArea.entities.PersonInfo;
import ru.findfood.PersonalArea.repositories.PersonRepository;

@Component
@Data
@Slf4j
@RequiredArgsConstructor
public class PersonInfoConverter {

    public PersonInfoDto entityToDto (PersonInfo personInfo) {
        PersonInfoDto dto = new PersonInfoDto();
        dto.setId(personInfo.getId());
        dto.setFirstname(personInfo.getFirstname());
        dto.setSurname(personInfo.getSurname());
        dto.setLastname(personInfo.getLastname());
        dto.setCity(personInfo.getCity());
        dto.setStreet(personInfo.getStreet());
        dto.setHouse(personInfo.getHouse());
        dto.setApartment(personInfo.getApartment());
        dto.setIndex(personInfo.getIndex());
        dto.setPhoneNumber(personInfo.getPhoneNumber());
        dto.setEmail(personInfo.getEmail());
        dto.setTelegramName(personInfo.getTelegramName());
        dto.setCreatedAt(personInfo.getCreatedAt());
        dto.setUpdatedAt(personInfo.getUpdatedAt());
//        log.info("PersonInfo entityToDto - " + dto);
        return dto;

    }

    public PersonInfo dtoToEntity (PersonInfoDto dto) {
        PersonInfo personInfo = new PersonInfo();
        personInfo.setId(dto.getId());
        personInfo.setFirstname(dto.getFirstname());
        personInfo.setSurname(dto.getSurname());
        personInfo.setLastname(dto.getLastname());
        personInfo.setCity(dto.getCity());
        personInfo.setStreet(dto.getStreet());
        personInfo.setHouse(dto.getHouse());
        personInfo.setApartment(dto.getApartment());
        personInfo.setIndex(dto.getIndex());
        personInfo.setPhoneNumber(dto.getPhoneNumber());
        personInfo.setEmail(dto.getEmail());
        personInfo.setTelegramName(dto.getTelegramName());
        return personInfo;
    }
}
