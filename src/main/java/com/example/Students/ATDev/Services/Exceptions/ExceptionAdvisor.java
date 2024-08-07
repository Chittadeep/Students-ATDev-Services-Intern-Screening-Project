package com.example.Students.ATDev.Services.Exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionAdvisor {
    @ExceptionHandler(StudentWithGivenIdNotFoundException.class)
    public ResponseEntity<String> handleStudentWithGivenIdNotFoundException(StudentWithGivenIdNotFoundException studentWithGivenIdNotFoundException)
    {
        return new ResponseEntity<String>(studentWithGivenIdNotFoundException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException constraintViolationException)
    {
        return new ResponseEntity<String>(constraintViolationException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StudentWithGivenIdDoesNotContainProfilePhoto.class)
    public ResponseEntity<String> handleStudentWithGivenIdDoesNotContainProfilePhotoException(StudentWithGivenIdDoesNotContainProfilePhoto studentWithGivenIdDoesNotContainProfilePhoto)
    {
        return new ResponseEntity<String>(studentWithGivenIdDoesNotContainProfilePhoto.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException dataIntegrityViolationException)
    {
        return new ResponseEntity<String>(dataIntegrityViolationException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
