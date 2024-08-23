package com.example.assingmenttecheazy.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SubjectNotFoundException extends RuntimeException{

    public SubjectNotFoundException() {
        super();
    }
    public SubjectNotFoundException(String message) {
        super(message);
    }


}
