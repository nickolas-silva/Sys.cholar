package br.edu.ufersa.sys_scholar.api.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;
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

        System.out.println(e.getMessage());

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

        System.out.println(e.getMessage());

        return new ResponseEntity<>(apiException, badRequest);
    }
}
