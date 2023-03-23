package br.edu.ufersa.sys_scholar.api.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.validation.constraints.Null;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = { EntityNotExistsException.class })
    public ResponseEntity<Object> handleApiRequestException(EntityNotExistsException e) {

        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        ApiException apiException = new ApiException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(apiException, badRequest);
    }

    @ExceptionHandler(value = { UserRegistredException.class })
    public ResponseEntity<Object> handleApiRequestException(UserRegistredException e) {

        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        ApiException apiException = new ApiException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(apiException, badRequest);
    }

    @ExceptionHandler(value = { NullFieldsException.class })
    public ResponseEntity<Object> handleApiRequestException(NullFieldsException e) {

        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        ApiException apiException = new ApiException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(apiException, badRequest);
    }

    @ExceptionHandler(value = { InvalidCredencialsException.class })
    public ResponseEntity<Object> handleApiRequestException(InvalidCredencialsException e) {

        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        ApiException apiException = new ApiException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(apiException, badRequest);
    }

    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    public ResponseEntity<Object> handleApiRequestException(MethodArgumentNotValidException e) {

        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        String message = "Mais de um campo estão inválidos";

        if (e.getAllErrors().size() <= 1) {
            message = e.getAllErrors().get(0).getDefaultMessage();
        }

        ApiException apiException = new ApiException(
                message,
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(apiException, badRequest);
    }
}
