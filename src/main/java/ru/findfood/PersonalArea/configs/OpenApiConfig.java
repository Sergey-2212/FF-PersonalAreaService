package ru.findfood.PersonalArea.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Личный кабинет пользователя",
                description = "Микросервис сервиса FindFood отвечающий за управление анкетными данными пользователя",
                version = "1.0.0"
        )
)
public class OpenApiConfig {

}
