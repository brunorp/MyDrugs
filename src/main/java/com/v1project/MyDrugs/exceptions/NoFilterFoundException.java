package com.v1project.MyDrugs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoFilterFoundException extends RuntimeException {
    public NoFilterFoundException(String message) {
        super(message);
    }
}
