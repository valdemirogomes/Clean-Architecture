package io.api.person.core.usecase;

import io.api.person.core.domain.Person;

import java.util.Optional;

public interface FyndById {
    public Optional<Person> execute(Long id);
}
