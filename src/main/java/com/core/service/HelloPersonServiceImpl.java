package com.core.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.core.entity.Person;
import com.db.dao.PersonDao;

import io.dropwizard.hibernate.UnitOfWork;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloPersonServiceImpl implements HelloPersonService {

    @Inject
    private PersonDao dao;

    @Override
    @UnitOfWork
    public Person getPerson(Long id) {
        return dao.findById(id);
    }

    @Override
    @UnitOfWork
    public List<Person> getPeople() {
        return dao.findAll();
    }

    @Override
    @UnitOfWork
    public Person savePerson(Person person) {
        return dao.create(person);

    }

    @Override
    @UnitOfWork
    public void deletePerson(Long id) {
        Person person = dao.findById(id);
        dao.delete(person);
    }
}
