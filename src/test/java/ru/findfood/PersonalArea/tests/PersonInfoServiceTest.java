package ru.findfood.PersonalArea.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.findfood.PersonalArea.entities.PersonInfo;
import ru.findfood.PersonalArea.exceptions.NotFoundException;
import ru.findfood.PersonalArea.repositories.PersonInfoRepository;
import ru.findfood.PersonalArea.services.PersonInfoService;

import java.util.Optional;

@SpringBootTest(classes = PersonInfoService.class)
public class PersonInfoServiceTest {
    @Autowired
    private PersonInfoService personInfoService;
    @MockBean
    private PersonInfoRepository personInfoRepository;

    @Test
    public void getByIdTest() {
        PersonInfo personInfo = new PersonInfo();
        personInfo.setId(2L);
        personInfo.setEmail("12345@gb.com");
        Mockito.doReturn(Optional.of(personInfo)).when(personInfoRepository).findById(2L);
        Mockito.doThrow(NotFoundException.class).when(personInfoRepository).findById(3L);
        Assertions.assertEquals("12345@gb.com", personInfoService.getById(2L).getEmail());
        Assertions.assertThrows(NotFoundException.class,() -> personInfoService.getById(3L));

    }
    @Test
    public void getByTelegramName() {
        PersonInfo personInfo = new PersonInfo();
        personInfo.setId(2L);
        personInfo.setTelegramName("NML_22");
        Mockito.doReturn(Optional.of(personInfo)).when(personInfoRepository).findByTelegramName("NML_22");
        Mockito.doThrow(NotFoundException.class).when(personInfoRepository).findByTelegramName("Empty");
        Assertions.assertEquals(2L, personInfoService.getByTelegramName("NML_22").getId());
        Assertions.assertThrows(NotFoundException.class, () -> personInfoService.getByTelegramName("Empty"));
    }
}
