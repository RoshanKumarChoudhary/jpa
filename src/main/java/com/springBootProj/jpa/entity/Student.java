package com.springBootProj.jpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @Getter @Setter
    private Passport passport;

    @Getter @Setter
    @Column(nullable = false)
    private String name;

    @Getter
    @ManyToMany
    @JoinTable(name = "Student_Course", joinColumns = @JoinColumn(name = "Student_ID"), inverseJoinColumns = @JoinColumn(name = "Course_ID"))
    private List<Course> courses = new ArrayList<>();

    @Getter @Setter
    private Address address;

    public void setCourse(Course course) {
        this.courses.add(course);
    }

    public Student (String name) {
        this.name = name;
    }
}
