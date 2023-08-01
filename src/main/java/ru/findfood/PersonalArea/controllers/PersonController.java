package ru.findfood.PersonalArea.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.findfood.PersonalArea.converters.PersonConverter;
import ru.findfood.PersonalArea.dtos.PersonDto;
import ru.findfood.PersonalArea.exceptions.AppError;
import ru.findfood.PersonalArea.services.PersonService;

@Slf4j
@RestController
@RequestMapping("/api/v1/persons")
@RequiredArgsConstructor
@Tag(name = "Личный кабинет", description = "Набор методов для взаимодействия с сервисом Личный кабинет")
public class PersonController {
    private final PersonService personService;
    private final PersonConverter personConverter;

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
    public PersonDto createNewPerson(@RequestBody @Parameter(description = "Анкета пользователя", required = true) PersonDto dto,
                                     @RequestHeader @Parameter(description = "Логин пользователя", required = true)String username) {
            if(!dto.getUsername().equals(username)) {
                throw new SecurityException(String.format("Usernames of dto(%s) and header(%s) arn't match ", dto.getUsername(), username));
            }
        return personConverter.entityToDto(personService.create(dto));
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


    @PutMapping
    public PersonDto updatePerson(@RequestBody @Parameter(description = "Анкета пользователя", required = true) PersonDto dto,
                                  @RequestHeader @Parameter(description = "Логин пользователя", required = true)String username) {
            if(!dto.getUsername().equals(username)) {
                throw new SecurityException(String.format("Usernames of dto(%s) and header(%s) aren't match ", dto.getUsername(), username));
             }
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



}
