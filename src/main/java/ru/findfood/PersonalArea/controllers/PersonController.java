package ru.findfood.PersonalArea.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.findfood.PersonalArea.converters.PersonConverter;
import ru.findfood.PersonalArea.converters.PersonInfoConverter;
import ru.findfood.PersonalArea.dtos.*;
import ru.findfood.PersonalArea.entities.Person;
import ru.findfood.PersonalArea.enums.Sex;
import ru.findfood.PersonalArea.exceptions.AppError;
import ru.findfood.PersonalArea.services.PersonInfoService;
import ru.findfood.PersonalArea.services.PersonService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/persons")
@RequiredArgsConstructor
@Tag(name = "Личный кабинет", description = "Набор методов для взаимодействия с сервисом Личный кабинет")
public class PersonController {
    private final PersonService personService;
    private final PersonInfoService personInfoService;
    private final PersonConverter personConverter;

    @Operation(
            summary = "Получение полного списка значений полов",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = String.class)))}
                    )
            }
    )
    @GetMapping("/sexes/titles/all")
    public ListResponse<String> getAllSexTitles() {
        ListResponse<String> list = new ListResponse<>();
        List<String> sexList = new ArrayList<>();

        for (Sex value : Sex.values()) {
            sexList.add(value.toString());
        }
        list.setList(sexList);
        return list;
    }
    @Operation(
            summary = "Запрос на получение полного списка сотрудников",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = PersonDto.class)))}
                    )
            }
    )
    @GetMapping("/employees")
    public List<PersonDto> getEmployees(
            @Parameter(description = "Список email пользователей для получения данных")
            @RequestParam(name = "list_email", required = false) Collection<String> emailList,
            @Parameter(description = "Часть или полностью email пользователя")
            @RequestParam(name = "part_email", required = false) String partEmail,
            @Parameter(description = "Часть или полностью email пользователя")
            @RequestParam(name = "part_lastname", required = false) String partLastname
    ) {
        List<Person> personsList = personService.getAllPersons(null, partEmail, partLastname, emailList);
        List<PersonDto> personDtoList = new ArrayList<>();
        for (Person p: personsList) {
            PersonDto personDto = personConverter.entityToDto(p);
            personDtoList.add(personDto);
        }
        return personDtoList;
    }
    @Operation(
            summary = "Запрос на получение полного списка пользователей для администратора",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = PersonDto.class)))}
                    )
            }
    )
    @GetMapping("/all")
    public List<PersonForAdmin> getAllPersonsForAdmin(
            @Parameter(description = "Часть или полное имени пользователя")
            @RequestParam(name = "part_username", required = false) String partUsername,
            @Parameter(description = "Часть или полностью email пользователя")
            @RequestParam(name = "part_email", required = false) String partEmail
    ) {
        List<Person> personsList = personService.getAllPersons(partUsername, partEmail, null, null);
        List<PersonForAdmin> personDtoList = new ArrayList<>();
        for (Person p: personsList) {
            PersonForAdmin personForAdmin = personConverter.entityToAdminResponse(p);
            personDtoList.add(personForAdmin);
        }
        return personDtoList;
    }

    @Operation(
            summary = "Запрос на проверку использования имени пользователя",
            responses = {
                    @ApiResponse(
                            description = "Имя свободно", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Boolean.class))
                    ),
                    @ApiResponse(
                            description = "Имя занято", responseCode = "404",
                            content = @Content(schema = @Schema(implementation = Boolean.class))
                    )
            }
    )
    @GetMapping("/check/{username}")
    public Boolean isUserNameFree(@PathVariable @Parameter(description = "имя пользователя", required = true) String username){

        return personService.isUserNameFree(username);
    }

    @Operation(
            summary = "Запрос на получение анкеты пользователя по его логину",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = {@Content(schema = @Schema(implementation = PersonDto.class))}
                    ),
                    @ApiResponse(
                            description = "Анкета не найдена", responseCode = "404",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @GetMapping()
    public PersonDto getPerson(@RequestHeader @Parameter(description = "Логин пользователя", required = true) String username) {

        return personConverter.entityToDto(personService.getByUsername(username));
    }
    @Operation(
            summary = "Запрос на получение пользователя по email",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonDto.class))
                    ),
                    @ApiResponse(
                            description = "Ресторан не найден", responseCode = "404",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @GetMapping("/email/{email}")
    public PersonDto getPersonByEmail(@PathVariable @Parameter(description = "адрес электронной почты пользователя", required = true) String email){

        return personConverter.entityToDto(personService.findByEmail(email));
    }
    @Operation(
            summary = "Запрос на создание новой анкеты пользователя",
            responses = {
                    @ApiResponse(
                            description = "Анкета успешно создана", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonDto.class))
                    ),
                    @ApiResponse(
                            description = "Ошибка создания анкеты",responseCode = "400",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewPerson(@RequestBody @Parameter(description = "Анкета пользователя", required = true) NewPersonDto dto) {

        personService.create(dto);
    }

    @Operation(
            summary = "Запрос на изменение email пользователя",
            responses = {
                    @ApiResponse(
                            description = "Email успешно обновлен", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonDto.class))
                    ),
                    @ApiResponse(
                            description = "Ошибка обновления email",responseCode = "400",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @PutMapping("/change/email")
    @ResponseStatus(HttpStatus.OK)
    public void updatePersonEmail(@RequestBody @Parameter(description = "Новый email пользователя", required = true) EmailToNewEmail emailToNewEmail){
        personInfoService.changePersonEmail(emailToNewEmail);
    }


    @Operation(
            summary = "Запрос на обновление данных анкеты пользователя",
            responses = {
                    @ApiResponse(
                            description = "Анкета успешно обновлена", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonDto.class))
                    ),
                    @ApiResponse(
                            description = "Ошибка обновления анкеты",responseCode = "400",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @PutMapping("/questionnaire")
    public PersonDto updatePersonQuestionnaire(@RequestBody @Parameter(description = "Анкета пользователя", required = true) PersonDto dto){
        return personConverter.entityToDto(personService.updateQuestionnaire(dto));
    }

    @Operation(
            summary = "Запрос на обновление данных профиля пользователя",
            responses = {
                    @ApiResponse(
                            description = "Анкета успешно обновлена", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonDto.class))
                    ),
                    @ApiResponse(
                            description = "Ошибка обновления анкеты",responseCode = "400",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @PutMapping("/info")
    public void updatePersonInfo(@RequestBody @Parameter(description = "Профиль пользователя", required = true) PersonInfoDto infoDto){
        personInfoService.updateInfo(infoDto);
    }

    @Operation(
            summary = "Запрос на обновление данных информации пользователя",
            responses = {
                    @ApiResponse(
                            description = "Анкета успешно обновлена", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonDto.class))
                    ),
                    @ApiResponse(
                            description = "Ошибка обновления анкеты",responseCode = "400",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @PutMapping
    public PersonDto updatePerson(@RequestBody @Parameter(description = "Анкета пользователя", required = true) PersonDto dto){

        return personConverter.entityToDto(personService.update(dto));
    }

    @Operation(
            summary = "Запрос на удаление анкеты пользователя",
            responses = {
                    @ApiResponse(
                            description = "Анкета успешно удалена", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonDto.class))
                    ),
                    @ApiResponse(
                            description = "Ошибка удаления анкеты",responseCode = "400",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @DeleteMapping()
    public void removePersonByUsername(@RequestHeader @Parameter(description = "Логин пользователя", required = true) String username) {
        personService.removeByUsername(username);
    }

    @Operation(
            summary = "Запрос на удаление анкеты пользователя по Id",
            responses = {
                    @ApiResponse(
                            description = "Анкета успешно удалена по Id", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonDto.class))
                    ),
                    @ApiResponse(
                            description = "Ошибка удаления анкеты по Id",responseCode = "400",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removePersonById(@PathVariable @Parameter(description = "Идентификатор пользователя", required = true) Long id) {

        personService.removeById(id);
    }

    @GetMapping("/byTelegramName")
    public PersonDto getByTelegramName(@RequestHeader String username) {
        return personConverter.entityToDto(personService.getByTelegramName(username));
    }

}
