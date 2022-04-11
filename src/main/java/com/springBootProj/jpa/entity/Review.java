package com.springBootProj.jpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@ToString
public class Review {

    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @Getter @Setter
    @Column(nullable = false)
    private String rating;


    @Getter @Setter
    @ManyToOne
    private Course course;

    @Getter @Setter
    private String description;

    public Review(String rating, String description){
        this.rating = rating;
        this.description = description;
    }
}
