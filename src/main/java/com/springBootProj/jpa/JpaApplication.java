package com.springBootProj.jpa;

import com.springBootProj.jpa.entity.*;
import com.springBootProj.jpa.repository.CourseRepository;
import com.springBootProj.jpa.repository.EmployeeRepository;
import com.springBootProj.jpa.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		logger.info("Course by 1000 --> {}", courseRepository.findById(1001L));
//		logger.info("Delete operation on course 1002 --> {}", courseRepository.deleteById(1002L));
//		courseRepository.saveCourse(new Course("Learning Java"));
//		List reviews = new ArrayList<>();
//		reviews.add(new Review("5","Great stuff"));
//		reviews.add(new Review("3","Normal stuff"));
//		studentRepository.mapStudentToPassport();
//		courseRepository.addReviewsForCourse(1001l,reviews);
//		studentRepository.retrieveStudentAndCourse();
//		logger.info("Student -> {}",studentRepository.retrieveStudentAndPassport());
//		logger.info("Passport -> {}",studentRepository.retrieveStudentAndPassport().getPassport());
		employeeRepository.insertEmployee(new FullTimeEmployee("Abc",new BigDecimal("10000")));
		employeeRepository.insertEmployee(new PartTimeEmployee("XYZ", new BigDecimal("10")));
		List<Employee> employees = employeeRepository.retrieveAllEmployees();
		logger.info("employees -> {}", employees);
	}
}
