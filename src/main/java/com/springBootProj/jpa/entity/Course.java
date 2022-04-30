package com.springBootProj.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Cacheable
@NamedQueries(value = {
        @NamedQuery(name = "query_find_all_course", query = "Select c From Course c"),
        @NamedQuery(name = "query_find_all_course_where_condn", query = "Select c from Course c where name Like '% 100 steps'")
})
public class Course {

    @Getter
    @Id
    @GeneratedValue
    private Long id;

    @Getter @Setter
    @Column(nullable = false)
    private String name;

    @Getter
    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList<>();

    @Getter
    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

    public void setStudent(Student student) {
        this.students.add(student);
    }

    public void setReviews(Review review) {
        this.reviews.add(review);
    }

    public void removeReview(Review review) {
        this.reviews.remove(review);
    }

    @UpdateTimestamp
    private LocalDateTime updatedTimeStamp;

    @CreationTimestamp
    private LocalDateTime createdTimeStamp;

    public Course (String name) {
        this.name = name;
    }
}
