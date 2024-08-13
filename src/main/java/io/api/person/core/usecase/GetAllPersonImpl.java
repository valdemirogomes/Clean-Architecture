package io.api.person.core.usecase;

import io.api.person.core.domain.Person;
import io.api.person.core.gateway.PersonGateWay;
import java.util.List;

public class GetAllPersonImpl implements GetAllPerson {
    private final PersonGateWay personGateWay;

    public GetAllPersonImpl(PersonGateWay personGateWay) {
        this.personGateWay = personGateWay;
    }


    @Override
    public List<Person> execute() {
        return personGateWay.getAllPerson();
    }
}
