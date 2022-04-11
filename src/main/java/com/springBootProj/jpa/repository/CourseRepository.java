package com.springBootProj.jpa.repository;


import com.springBootProj.jpa.entity.Course;
import com.springBootProj.jpa.entity.Passport;
import com.springBootProj.jpa.entity.Review;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class CourseRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Course findById(Long id){
       return entityManager.find(Course.class, id);
    }

    public boolean deleteById(Long id) {
        Course course = findById(id);
        if(course != null) {
            entityManager.remove(course);
            return true;
        }
        return false;
    }

    public void saveCourse(Course course){
        if (course.getId() == null){
            entityManager.persist(course);
        }
        else {
            entityManager.merge(course);
        }
    }

    // named query
    //Without Typed query
    public void findByIdJpql(Long id) {
//        Query query = entityManager.createQuery("Select c From Course c");
        Query query = entityManager.createNamedQuery("query_find_all_course");
        List resultList = query.getResultList();
    }

    // named query
    // With Typed one
    public void findByIdJpqlTyped(Long id){
        //TypedQuery<Course> query = entityManager.createQuery("Select c from Course C", Course.class);
        TypedQuery<Course> query = entityManager.createNamedQuery("query_find_all_course", Course.class);
        List<Course> resultList = query.getResultList();
    }

    //Where condn
    public void whereCondn() {
   //     TypedQuery<Course> query = entityManager.createQuery("Select c from Course c where name Like '% 100 steps'",Course.class);

        TypedQuery<Course> query = entityManager.createNamedQuery("query_find_all_course_where_condn",Course.class);
        List<Course> resultList = query.getResultList();
    }

    public void nativeQueriesWithParameter() {
        Query query = entityManager.createNativeQuery("Select * from Courese where id = ?", Course.class);
        query.setParameter(1,1000L);
        List<Course> resultList = query.getResultList();
    }

    public void nativeQueriesWithNamedParameter() {
        Query query = entityManager.createNativeQuery("Select * from Course where id = :id",Course.class);
        query.setParameter("id",1000L);
        List<Course> resultList = query.getResultList();
    }

    public void updateTimeStampOfAllRow() {
        Query query = entityManager.createNativeQuery("Update Course Set updated_time_stamp=sysdate()");
        int noOfRowsUpdated = query.executeUpdate();
    }

    public void someStudentOperations(){
        Passport passport = entityManager.find(Passport.class, 40001L);
        passport.getStudent();
    }

    public void addReviewsForCourse(Long id, List<Review> reviews) {
        Course course = entityManager.find(Course.class, id);

        for(Review review: reviews) {
            review.setCourse(course);
            course.setReviews(review);
            entityManager.persist(review);
        }

    }
}
