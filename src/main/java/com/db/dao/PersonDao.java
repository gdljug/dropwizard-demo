package com.db.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.core.entity.Person;

import io.dropwizard.hibernate.AbstractDAO;

public class PersonDao extends AbstractDAO<Person> {

    public PersonDao(SessionFactory factory) {
        super(factory);
    }

    public Person findById(Long id) {
        return get(id);
    }

    public Person create(Person person) {
        return persist(person);
    }

    public List<Person> findAll() {
        return list(namedQuery("com.core.entity.Person.findAll"));
    }

    public void delete(Person person){
        currentSession().delete(person  );
    }
}
