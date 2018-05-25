package com.core.service;

import java.util.List;

import com.core.entity.Person;

public interface HelloPersonService {

    Person getPerson(Long id);

    List<Person> getPeople();

    Person savePerson(Person person);

    void deletePerson(Long id);

}
