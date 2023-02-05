package com.corlan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookExceptionHandler {

    @ExceptionHandler(value = BookException.class)
    protected ResponseEntity<Object> handleRegistrationError(BookException ex){
                BookExceptionDto bookExceptionDto = new BookExceptionDto(HttpStatus.BAD_REQUEST, ex.getMessage());

        return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(bookExceptionDto);
    }
}

