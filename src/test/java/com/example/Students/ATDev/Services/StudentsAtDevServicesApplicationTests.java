package com.example.Students.ATDev.Services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.ArrayList;
import org.assertj.core.util.Arrays;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import com.example.Students.ATDev.Services.Entities.Student;
import com.example.Students.ATDev.Services.Exceptions.StudentWithGivenIdNotFoundException;
import com.example.Students.ATDev.Services.Repositories.StudentsRepository;

@SpringBootTest
class StudentsAtDevServicesApplicationTests {

	@Test
	void contextLoads() {
	}



}
