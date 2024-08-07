package com.example.Students.ATDev.Services.Repositories;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import com.example.Students.ATDev.Services.Entities.Student;
import com.example.Students.ATDev.Services.Exceptions.StudentWithGivenIdNotFoundException;

import jakarta.validation.ConstraintViolationException;

@SpringBootTest
public class StudentRepositoryTest {
    
	@Autowired
	private StudentsRepository studentsRepository;

	@Test
	void studentAdd()
	{
		Student s = new Student();
		s.setName("Chittadeep");
		s.setPhoneNumber("8967149075");
		s.setEmail("mailchittadeep@gmail.com");
		studentsRepository.save(s);
		assertEquals(studentsRepository.count(), 1);
	}

	@Test
	void studentAddDuplicatePhoneNumber()
	{
		Student s1 = new Student();
		s1.setName("Chittadeep");
		s1.setPhoneNumber("8967149075");
		s1.setEmail("mailchittadeep@gmail.com");
		studentsRepository.save(s1);
		Student s2 = new Student();
		s2.setName("Chittadeep");
		s2.setPhoneNumber("8967149075");
		s2.setEmail("mailchittadeep@gmail.com");
		assertThrows(DataIntegrityViolationException.class, ()->studentsRepository.save(s2));
	}
	
	@Test
	void studentAddWrongMailFormat()
	{
		Student s = new Student();
		s.setName("Chittadeep");
		s.setPhoneNumber("8967149075");
		s.setEmail("mailchittadeepgmail.com");
		assertThrows(ConstraintViolationException.class, ()->studentsRepository.save(s));
	}

	@Test
	void studentAddWrongPhoneFormat()
	{
		Student s = new Student();
		s.setName("Chittadeep");
		s.setPhoneNumber("896714907589");
		s.setEmail("mailchittadeep@gmail.com");
		assertThrows(ConstraintViolationException.class, ()->studentsRepository.save(s));
	}

	
	@Test
	void studentAddDuplicateMail()
	{
		Student s1 = new Student();
		s1.setName("Chittadeep");
		s1.setPhoneNumber("8967149075");
		s1.setEmail("mailchittadeep@gmail.com");
		studentsRepository.save(s1);
		Student s2 = new Student();
		s2.setName("Rahul Kumar Singh ");
		s2.setPhoneNumber("1234567890");
		s2.setEmail("mailchittadeep@gmail.com");
		assertThrows(DataIntegrityViolationException.class, ()->studentsRepository.save(s2));
	}

	@Test
	void checkStudentExistsByIdOrNotWhenStudentActuallyDoesNotExists()
	{
		assertThrows(StudentWithGivenIdNotFoundException.class, ()->studentsRepository.findById(5).orElseThrow(()->new StudentWithGivenIdNotFoundException())); 
	}

	@Test
	void checkStudentExistsByIdOrNotWhenStudentActuallyExists()
	{
		Student s = new Student();
		s.setName("Chittadeep");
		s.setPhoneNumber("8967149075");
		s.setEmail("mailchittadeep@gmail.com");
		studentsRepository.save(s);
		assertDoesNotThrow(()->studentsRepository.findById(1));
	}

	@Test
	void getAllStudentsAddedToDatabase()
	{
		Student s1 = new Student();
		s1.setName("Chittadeep");
		s1.setPhoneNumber("8967149075");
		s1.setEmail("mailchittadeep@gmail.com");
		studentsRepository.save(s1);
		Student s2 = new Student();
		s2.setName("Rahul Kumar Singh");
		s2.setPhoneNumber("1234567890");
		s2.setEmail("mailrahul@gmail.com");
		studentsRepository.save(s2);
		Student s3 = new Student();
		s3.setName("Piyush Raj");
		s3.setPhoneNumber("0123456789");
		s3.setEmail("mailpiyush@gmail.com");
		studentsRepository.save(s3);
		List<Student> list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		assertEquals(studentsRepository.findAll(), list);
	}

	@Test
	void getStudentAddedToDatabase()
	{
		Student s = new Student();
		s.setName("Chittadeep");
		s.setPhoneNumber("8967149075");
		s.setEmail("mailchittadeep@gmail.com");
		studentsRepository.save(s);
		s.setId(1);
		assertEquals(studentsRepository.findById(1).get(), s);
	}

	@AfterEach
	void teardown()
	{
		studentsRepository.deleteAll();
	}

}
