package com.example.Students.ATDev.Services.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.Students.ATDev.Services.Entities.Student;
import com.example.Students.ATDev.Services.Repositories.StudentsRepository;


public class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentsRepository studentsRepository;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldSuccesfullySaveAStudent()
    {
        Student student = new Student();
        student.setName("Chittadeep");
        student.setEmail("mailchittadeep@gmail.com");
        student.setPhoneNumber("8967149075");
        student.setBloodGroup("B+");
        
        Student savedStudent = new Student();
        savedStudent.setName("Chittadeep");
        savedStudent.setEmail("mailchittadeep@gmail.com");
        savedStudent.setPhoneNumber("8967149075");
        savedStudent.setBloodGroup("B+");
        
        when(studentsRepository.save(student)).thenReturn(null);

        Student saveStudentResult = studentService.addStudent(student);
        
        assertEquals(savedStudent.getId(), saveStudentResult.getId());
    }
}
