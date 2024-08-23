package com.example.assingmenttecheazy.exceptions;

import com.example.assingmenttecheazy.dtos.ExceptionHandlerDTO;
import com.example.assingmenttecheazy.repositories.StudentRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleException {

    @ExceptionHandler({SubjectNotFoundException.class})
    public ResponseEntity handleSubjectNotFoundException(SubjectNotFoundException subjectNotFoundException){
        ExceptionHandlerDTO exceptionHandlerDTO = new ExceptionHandlerDTO( subjectNotFoundException.getMessage(),404);
        return new  ResponseEntity<>(exceptionHandlerDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({StudentNotFoundException.class})
    public ResponseEntity handleStudentNotFoundException(StudentNotFoundException studentNotFoundException){
        ExceptionHandlerDTO exceptionHandlerDTO = new ExceptionHandlerDTO(studentNotFoundException.getMessage(),404);
        return new  ResponseEntity<>(exceptionHandlerDTO, HttpStatus.NOT_FOUND);
    }
}
