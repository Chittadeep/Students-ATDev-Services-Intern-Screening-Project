package com.example.Students.ATDev.Services.Exceptions;

public class StudentWithGivenIdDoesNotContainProfilePhoto extends RuntimeException {
    @Override
    public String getMessage()
    {
        return "Student with the given ID does not contain any profile photo";
    }
}
