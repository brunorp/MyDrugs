package com.v1project.MyDrugs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoProductFoundException extends RuntimeException {
    public NoProductFoundException(String message){
        super(message);
    }
}
