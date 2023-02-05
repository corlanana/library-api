package com.corlan.exception;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class BookExceptionDto implements Serializable{
    private HttpStatus status;
    private String message;

    public BookExceptionDto(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }
}
