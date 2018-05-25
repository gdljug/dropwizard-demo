package com.core.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@NamedQueries(
        {
                @NamedQuery(
                        name = "com.core.entity.Person.findAll",
                        query = "SELECT p FROM Person p"
                )
        })
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private int age;

}
