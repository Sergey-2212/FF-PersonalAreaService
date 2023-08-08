package ru.findfood.PersonalArea.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode
@Schema(description = "Модель анкеты пользователя")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class PersonDto {

    @Schema(description = "Id пользователя", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "username пользователя для авторизации в сервисе", requiredMode = Schema.RequiredMode.REQUIRED,maxLength = 255)
    private String username;

    @Schema(description = "Пол пользователя", requiredMode = Schema.RequiredMode.REQUIRED)
    private String sex;

    @Schema(description = "Дата рождения", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDate birthdate;

    @Schema(description = "Вес пользователя в килограммах", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer weight;

    @Schema(description = "Рост пользователя", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer height;

    @Schema(description = "Уровень физической нагрузки", requiredMode = Schema.RequiredMode.REQUIRED)
    private String activity_title;

    @Schema(description = "Цель ползователя с точки зрения его веса", requiredMode = Schema.RequiredMode.REQUIRED)
    private GoalDto goal;

    @Schema(description = "Расширенная анкета пользователя")
    private PersonInfoDto info_dto;

  public PersonDto() {
    }


}
