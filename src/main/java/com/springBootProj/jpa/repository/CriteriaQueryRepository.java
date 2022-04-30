package com.springBootProj.jpa.repository;

import com.springBootProj.jpa.entity.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Slf4j
public class CriteriaQueryRepository {

    @PersistenceContext
    EntityManager entityManager;
    public void getAllCourses(){

        //1st Step -> using criteria builder to create a query returning expected result object.
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> query = criteriaBuilder.createQuery(Course.class);

        //2nd Step --> Defining a root i.e which all entity are involved in the query
        Root<Course> from = query.from(Course.class);

        //3rd and 4th is not required as we re not using where or any other condn.

        //5th Build the typed query
        TypedQuery<Course> typedQuery = entityManager.createQuery(query.select(from));
        List<Course> resultList = typedQuery.getResultList();
        log.info("Course {}", resultList);
    }

    public void getAllCoursesWhereNameLike100Steps(){

        //1st Step -> using criteria builder to create a query returning expected result object.
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> query = criteriaBuilder.createQuery(Course.class);

        //2nd Step --> Defining a root i.e which all entity are involved in the query
        Root<Course> from = query.from(Course.class);

        //3rd Step --> Define what all condn is required
        Predicate like100Step = criteriaBuilder.like(from.get("name"), "%100Steps%");

        //4th Step --> Add predicate to the criteria builder.
        query.where(like100Step);

        //5th Build the typed query
        TypedQuery<Course> typedQuery = entityManager.createQuery(query.select(from));
        List<Course> resultList = typedQuery.getResultList();
        log.info("Course {}", resultList);
    }

    public void getAllCoursesWhereStudentIsEmpty(){

        //1st Step -> using criteria builder to create a query returning expected result object.
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> query = criteriaBuilder.createQuery(Course.class);

        //2nd Step --> Defining a root i.e which all entity are involved in the query
        Root<Course> from = query.from(Course.class);

        //3rd Step --> Define what all condn is required
        Predicate studentsIsEmpty = criteriaBuilder.isEmpty(from.get("students"));

        //4th Step --> Add predicate to the criteria builder.
        query.where(studentsIsEmpty);

        //5th Build the typed query
        TypedQuery<Course> typedQuery = entityManager.createQuery(query.select(from));
        List<Course> resultList = typedQuery.getResultList();
        log.info("Course {}", resultList);
    }

    public void joinCourseStudent(){

        //1st Step -> using criteria builder to create a query returning expected result object.
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> query = criteriaBuilder.createQuery(Course.class);

        //2nd Step --> Defining a root i.e which all entity are involved in the query
        Root<Course> from = query.from(Course.class);

        //3rd Step --> Define what all condn is required
        Join<Object, Object> students = from.join("students");

        //4th Step --> Add predicate to the criteria builder.


        //5th Build the typed query
        TypedQuery<Course> typedQuery = entityManager.createQuery(query.select(from));
        List<Course> resultList = typedQuery.getResultList();
        log.info("Course {}", resultList);
    }

    public void leftJoinCourseStudent(){

        //1st Step -> using criteria builder to create a query returning expected result object.
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> query = criteriaBuilder.createQuery(Course.class);

        //2nd Step --> Defining a root i.e which all entity are involved in the query
        Root<Course> from = query.from(Course.class);

        //3rd Step --> Define what all condn is required
        Join<Object, Object> students = from.join("students", JoinType.LEFT);

        //4th Step --> Add predicate to the criteria builder.


        //5th Build the typed query
        TypedQuery<Course> typedQuery = entityManager.createQuery(query.select(from));
        List<Course> resultList = typedQuery.getResultList();
        log.info("Course {}", resultList);
    }
}
