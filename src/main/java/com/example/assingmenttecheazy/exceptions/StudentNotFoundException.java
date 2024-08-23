package com.example.assingmenttecheazy.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException() {
        super("Student not found");
    }

    public StudentNotFoundException(String message) {
        super(message);
    }
}
