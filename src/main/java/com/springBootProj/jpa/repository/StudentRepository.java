package com.springBootProj.jpa.repository;

import com.springBootProj.jpa.entity.Course;
import com.springBootProj.jpa.entity.Passport;
import com.springBootProj.jpa.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Slf4j
@Transactional
public class StudentRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void mapStudentToPassport() {
        Passport passport = new Passport("Z235");
        entityManager.persist(passport);

        Student student = new Student("Zike");
        student.setPassport(passport);
        entityManager.persist(student);

//        Student student1 = entityManager.find(Student.class,2001L);
//        log.info("Student found -> {}", student1);

    }

    public Student retrieveStudentAndPassport() {
        Student student = entityManager.find(Student.class,2001L);
        return student;
    }

    public void retrieveStudentAndCourse(){
        Student student = entityManager.find(Student.class,2000L);
        log.info("Student -> {}", student);
        log.info("Course -> {}", student.getCourses());
    }

    public void insertStudentAndCourse(Student student, Course course) {
        entityManager.persist(student);
        entityManager.persist(course);
        course.setStudent(student);
        student.setCourse(course);
    }
}
