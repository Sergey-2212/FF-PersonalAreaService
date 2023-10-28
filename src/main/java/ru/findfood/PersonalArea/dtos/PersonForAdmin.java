package ru.findfood.PersonalArea.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Модель пользователя для администратора")
public class PersonForAdmin {
    @Schema(description = "Id пользователя", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "username пользователя для авторизации в сервисе", requiredMode = Schema.RequiredMode.REQUIRED,maxLength = 255)
    private String username;

    @Schema(description = "Электронная почта (login)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String email;

    @Schema(description = "Дата добавления",  requiredMode = Schema.RequiredMode.AUTO)
    private LocalDateTime createdAt;

    @Schema(description = "Дата последнего обновления",  requiredMode = Schema.RequiredMode.AUTO)
    private LocalDateTime updatedAt;
}
