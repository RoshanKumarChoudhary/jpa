package com.springBootProj.jpa.repository;

import com.springBootProj.jpa.JpaApplication;
import com.springBootProj.jpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = JpaApplication.class)
public class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void findById(){
       assertEquals("React Course",courseRepository.findById(1001L).getName());
    }

    @Test
    @DirtiesContext
    public void deleteById() {
        assertTrue(courseRepository.deleteById(1002L));
    }

    @Test
    @DirtiesContext
    public void saveCourse() {
        //find the course by id
        Course course = courseRepository.findById(1001L);
        assertEquals("React Course", course.getName());

        //Update;
        course.setName("java course");
        courseRepository.saveCourse(course);


        assertEquals("java course", courseRepository.findById(1001l).getName());
    }

}
