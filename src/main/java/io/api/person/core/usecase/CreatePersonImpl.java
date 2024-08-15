package io.api.person.core.usecase;

import io.api.person.core.domain.Person;
import io.api.person.core.gateway.PersonGateWay;


public class CreatePersonImpl implements CreatePerson{

    private final PersonGateWay personGateWay;

    public CreatePersonImpl(PersonGateWay personGateWay) {
        this.personGateWay = personGateWay;
    }

    @Override
    public Person execute(Person person) {
        return personGateWay.createPerson(person);
    }
}
