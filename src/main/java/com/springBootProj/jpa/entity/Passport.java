package com.springBootProj.jpa.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@ToString
public class Passport {

    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @Getter @Setter
    @Column(nullable = false)
    private String number;

    @Getter@Setter
    @OneToOne(mappedBy = "passport")
    private Student student;

    public Passport(String number){
        this.number = number;
    }
}
