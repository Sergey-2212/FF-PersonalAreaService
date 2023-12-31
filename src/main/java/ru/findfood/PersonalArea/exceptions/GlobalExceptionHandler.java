package ru.findfood.PersonalArea.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<AppError> catchNotFoundException (NotFoundException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(), exception.getMessage()), HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler
//    public ResponseEntity<AppError> catchIllegalArgumentException (IllegalArgumentException exception) {
//        log.error(exception.getMessage());
//        return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(), exception.getMessage()), HttpStatus.NOT_FOUND);
//    }
    @ExceptionHandler
    public ResponseEntity<AppError> catchValidationErrorException (ValidationErrorException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<AppError> catchSecurityErrorException (SecurityErrorException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(new AppError(HttpStatus.FORBIDDEN.value(), exception.getMessage()), HttpStatus.FORBIDDEN);
    }
}
