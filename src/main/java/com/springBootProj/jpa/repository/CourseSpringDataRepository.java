package com.springBootProj.jpa.repository;

import com.springBootProj.jpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

@RepositoryRestResource(path = "course")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {
    public List<Course> findByNameAndId(String name, Long id);
    public List<Course> findByName(String name);
    public List<Course> countByName(String name);
    public List<Course> findByNameOrderByIdDesc(String name);
    public List<Course> deleteByName(String name);

    @Query("Select c from Course c where name like '%100 step'")
    public List<Course> courseWith100Steps();

    @Query(value = "Select * from Course where name like '%100 step'",nativeQuery = true)
    public List<Course> courseWith100StepsNativeQuery();

    @Query(name = "query_find_all_course")
    public List<Course> courseWith100StepsNamedQuery();
}
