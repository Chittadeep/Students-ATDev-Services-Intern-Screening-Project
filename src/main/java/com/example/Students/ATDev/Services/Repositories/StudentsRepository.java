package com.example.Students.ATDev.Services.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Students.ATDev.Services.Entities.Student;

@Repository
public interface StudentsRepository extends CrudRepository<Student, Integer> {
    
}
