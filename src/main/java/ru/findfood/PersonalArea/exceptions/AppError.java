package ru.findfood.PersonalArea.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppError {

    private Integer status;
    private String message;
}
