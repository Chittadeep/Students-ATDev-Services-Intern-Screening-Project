package com.example.Students.ATDev.Services.Exceptions;

public class StudentWithGivenIdNotFoundException extends RuntimeException {
    @Override
    public String getMessage() {
        return "No Student with the given ID exists";
    }
    
}
