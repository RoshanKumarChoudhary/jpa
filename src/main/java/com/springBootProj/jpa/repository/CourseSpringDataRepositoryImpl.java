package com.springBootProj.jpa.repository;

import com.springBootProj.jpa.entity.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class CourseSpringDataRepositoryImpl {

    @Autowired
    CourseSpringDataRepository repository;
    public void findCourseById(){
        Optional<Course> coursePresent = repository.findById(1000L);
        if(coursePresent.isPresent()) log.info("Present");
    }

    public void sortByNameDesc() {
        repository.findAll(Sort.by(Sort.Direction.DESC, "name"));
    }

    public void pagination() {
        PageRequest pageRequest = PageRequest.of(0,3);
        Page<Course> firstPage = repository.findAll(pageRequest);
        List<Course> content = firstPage.getContent();
        Pageable secondPage = firstPage.nextPageable();

    }
}
