package io.api.person.core.usecase;

import io.api.person.core.domain.Person;

public interface UpdatePerson {
    public Person execute(Long id, Person person);
}
