package io.api.person.core.usecase;

import io.api.person.core.domain.Person;

import java.util.List;

public interface GetAllPerson {
    public List<Person> execute();

}
