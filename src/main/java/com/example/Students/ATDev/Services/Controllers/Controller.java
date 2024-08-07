package com.example.Students.ATDev.Services.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Students.ATDev.Services.Entities.Student;
import com.example.Students.ATDev.Services.Services.StudentService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
public class Controller {
    @Autowired
    private StudentService studentService;

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<List<Student>>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/getStudentById/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        return new ResponseEntity<Student>(studentService.getStudent(id), HttpStatus.OK);
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return new ResponseEntity<Student>(studentService.addStudent(student), HttpStatus.CREATED);
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        return new ResponseEntity<Student>(studentService.updateStudent(student), HttpStatus.OK);
    }

    @PatchMapping("/uploadProfilePhoto/{id}")
    public ResponseEntity<InputStreamResource> uploadProfilePhoto(@PathVariable int id, @RequestParam MultipartFile file) throws IOException
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=studentProfilePic.jpg");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.IMAGE_JPEG).body(studentService.uploadProfilePicture(id, file));
    }

    @GetMapping("/getProfilePhoto/{id}")
    public ResponseEntity<InputStreamResource> getProfilePhoto(@PathVariable int id) throws IOException{
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=studentProfilePic.jpg");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.IMAGE_JPEG).body(studentService.getProfilePicture(id));
    }
    
    
    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable int id)
    {
        return new ResponseEntity<Boolean>(studentService.deleteStudent(id), HttpStatus.OK);
    }
}
