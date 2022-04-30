package com.springBootProj.jpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "EmployeeType")
public abstract class Employee {
    String name;

    @Id
    @GeneratedValue
    @Getter
    Long id;

    public Employee(String name) {
        this.name = name;
    }

}

//So we have 3 different strategy
//1. Single table -> It will create 1 table with part time employee and full time employee.
//The disadvantage of using it is that the table might have some null values and DB integrity will nbe lost as someone can push null in the value.
//2. Table per class --> It will give two separate tables for all the inherited class.
// Disadvantage will be it will create two different table and the common columns will be there.
//3.Joined --> it will create 3 tables Employee, partTimeEmployee, FullTime Employee. Employee will have a common table Which will store the name and the id.
//Other two table will only have what is different.Disadvantage of this is that for fetching employee it has to perform long db query execution.

// 4th option is to not use @Inheritance and use @MappedSuperClass. This will remove entity. And we will have two table same as table per class.
//Disadvantage of this is for retrieving we have to do it per class.
