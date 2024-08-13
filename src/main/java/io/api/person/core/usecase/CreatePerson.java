package io.api.person.core.usecase;

import io.api.person.core.domain.Person;

public interface CreatePerson {
    public Person execute(Person person);
}
