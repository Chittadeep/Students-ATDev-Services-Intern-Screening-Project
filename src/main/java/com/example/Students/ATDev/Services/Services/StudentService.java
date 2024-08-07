package com.example.Students.ATDev.Services.Services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Students.ATDev.Services.Entities.Student;
import com.example.Students.ATDev.Services.Exceptions.StudentWithGivenIdNotFoundException;
import com.example.Students.ATDev.Services.Repositories.StudentsRepository;

@Service
public class StudentService {
    @Autowired
    private StudentsRepository studentsRepository;

    public StudentService(StudentsRepository studentsRepository)
    {
        this.studentsRepository=studentsRepository;
    }

    public Student addStudent(Student student)
    {
        studentsRepository.save(student);
        return student;
    }

    public Student getStudent(int id)
    {
        return studentsRepository.findById(id).orElseThrow(()-> new StudentWithGivenIdNotFoundException());
    }

    public List<Student> getAllStudents()
    {
        return (ArrayList<Student>) studentsRepository.findAll();
    }

    public Student updateStudent(Student student)
    {
        getStudent(student.getId());
        studentsRepository.save(student);
        return getStudent(student.getId());
    }

    public boolean deleteStudent(int id)
    {
        getStudent(id);
        studentsRepository.deleteById(id);
        return true;
    }

    public InputStreamResource uploadProfilePicture(int id, MultipartFile file) throws IOException
    {
        Student student = getStudent(id);
        student.setPhoto(file.getBytes());
        studentsRepository.save(student);
        InputStream stream = new ByteArrayInputStream(file.getBytes());
        InputStreamResource resource = new InputStreamResource(stream);
        return resource;
    }

    public InputStreamResource getProfilePicture(int id) throws IOException
    {
        Student student = getStudent(id);
        if(student.getPhoto()==null)
        throw new StudentWithGivenIdNotFoundException();
        InputStream stream = new ByteArrayInputStream(student.getPhoto());
        InputStreamResource resource = new InputStreamResource(stream);
        return resource;
    }
}