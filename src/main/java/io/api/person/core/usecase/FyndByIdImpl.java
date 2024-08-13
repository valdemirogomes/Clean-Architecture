package io.api.person.core.usecase;

import io.api.person.core.domain.Person;
import io.api.person.core.gateway.PersonGateWay;
import java.util.Optional;

public class FyndByIdImpl implements FyndById{
    private final PersonGateWay personGateWay;

    public FyndByIdImpl(PersonGateWay personGateWay) {
        this.personGateWay = personGateWay;
    }

    @Override
    public Optional<Person> execute(Long id) {
       return personGateWay.fyndById(id);
    }
}
