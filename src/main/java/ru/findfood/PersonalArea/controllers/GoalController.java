package ru.findfood.PersonalArea.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.findfood.PersonalArea.converters.GoalConverter;
import ru.findfood.PersonalArea.dtos.GoalDto;
import ru.findfood.PersonalArea.dtos.ListResponse;
import ru.findfood.PersonalArea.entities.Person;
import ru.findfood.PersonalArea.exceptions.AppError;
import ru.findfood.PersonalArea.services.GoalService;
import ru.findfood.PersonalArea.services.PersonInfoService;
import ru.findfood.PersonalArea.services.PersonService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/goals")
@Tag(name = "Цель пользователя и коэффициенты КБЖУ", description = "Методы работы с целью пользования сервисом и коэффициентами КБЖУ")
public class GoalController {

    private final GoalService goalService;
    private final PersonService personService;
    private final PersonInfoService personInfoService;
    private final GoalConverter goalConverter;

    @Operation(
            summary = "Получение полного списка имен целей",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = String.class)))}
                    )
            }
    )
    @GetMapping("/titles/all")
    public ListResponse<String> getAllGoalTitles() {
        ListResponse<String> list = new ListResponse<>();
        list.setList(goalService.getAllTitles());
        return list;
    }


    @Operation(
            summary = "Получение коэффициентов КБЖУ по названию цели",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = GoalDto.class))
                            ),
                    @ApiResponse(
                            description = "Цель не найдена", responseCode = "400",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @GetMapping("/{title}")
    public GoalDto getGoalByTitle(@PathVariable @Parameter(name = "Имя цели", required = true) String title) {
        return goalConverter.entityToDto(
                goalService.getByTitle(title));
    }

    @Operation(
            summary = "Получение коэффициентов КБЖУ по username пользователя в сервисе",
            responses = {
            @ApiResponse(
                    description = "Успешный ответ", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = GoalDto.class))
            ),
            @ApiResponse(
                    description = "Цель не найдена", responseCode = "400",
                    content = @Content(schema = @Schema(implementation = AppError.class))
            )
    }
    )
    @GetMapping("/app/{username}")
    public GoalDto getGoalByUsername(@PathVariable String username) {
        Person person = personService.getByUsername(username);
        return goalConverter.entityToDto(person.getGoal());

    }

    @Operation(
            summary = "Получение коэффициентов КБЖУ по имени пользователя в Telegram",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = GoalDto.class))
                    ),
                    @ApiResponse(
                            description = "Цель не найдена", responseCode = "400",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @GetMapping("/telegram/{username}")
    public GoalDto getGoalByTelegramName(@PathVariable String username) {
        Person person = personInfoService.getByTelegramName(username).getPerson();
        return goalConverter.entityToDto(person.getGoal());
    }
}
