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
import ru.findfood.PersonalArea.converters.ActivityConverter;
import ru.findfood.PersonalArea.dtos.ActivityDto;
import ru.findfood.PersonalArea.dtos.ListResponse;
import ru.findfood.PersonalArea.exceptions.AppError;
import ru.findfood.PersonalArea.services.ActivityService;

import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/activities")
@Tag(name = "Уровень физической активности",
        description = "Набор методов для получения данных о коэффициенте физической активности и списка степеней активности")
public class ActivityController {

    private final ActivityService activityService;
    private final ActivityConverter activityConverter;

    @Operation(
            summary = "Получения полного списка наименований уровней физической активности",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = String.class)))}
                    )
            }
    )
    @GetMapping("/titles/all")
    public ListResponse<String> getAllActivityTitles() {
        ListResponse<String> list = new ListResponse<>();
        list.setList(activityService.listOfActivityTitles());
        return list;
    }

    @Operation(
            summary = "Получения полного списка уровней физической активности",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = ActivityDto.class)))}
                    )
            }
    )
    @GetMapping("/all")
    public ListResponse<ActivityDto> getAllActivities() {
        ListResponse<ActivityDto> list = new ListResponse<>();
        list.setList(activityService.getAllActivities().stream().map(activityConverter::entityToDto).collect(Collectors.toList()));
        return list;
    }

    @Operation(
            summary = "Запрос на получение полного описания уровня активности по наименованию",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = {@Content(schema = @Schema(implementation = ActivityDto.class))}
                    ),
                    @ApiResponse(
                            description = "Уровень не найден", responseCode = "404",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @GetMapping("/{title}")
    public ActivityDto getActivityByTitle(@PathVariable @Parameter(name = "Имя активности", required = true) String title) {
        return activityConverter.entityToDto(activityService.getActivityByTitle(title));
    }

}
