package com.workintech.s18d2.exceptions;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(PlantException exception) {
        ErrorResponse response = new ErrorResponse(exception.getMessage());
        log.error("Plant exception occured: ", exception);
        return new ResponseEntity<>(response, exception.getHttpStatus());
    }



    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        ErrorResponse response = new ErrorResponse(exception.getMessage());
        log.error("An unexpected plant exception occured: ", exception);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
