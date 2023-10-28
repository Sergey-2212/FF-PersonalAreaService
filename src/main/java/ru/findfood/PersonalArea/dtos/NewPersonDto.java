package ru.findfood.PersonalArea.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Модель нового пользователя")
public class NewPersonDto {
    @Schema(description = "username пользователя для авторизации в сервисе", requiredMode = Schema.RequiredMode.REQUIRED,maxLength = 255)
    private String username;

    @Schema(description = "Электронная почта", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String email;


}
