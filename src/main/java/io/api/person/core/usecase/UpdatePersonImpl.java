package io.api.person.core.usecase;

import io.api.person.core.domain.Person;
import io.api.person.core.gateway.PersonGateWay;
import org.springframework.stereotype.Service;

@Service
public class UpdatePersonImpl implements UpdatePerson {
    private final PersonGateWay personGateWay;

    public UpdatePersonImpl(PersonGateWay personGateWay) {
        this.personGateWay = personGateWay;
    }


    @Override
    public Person execute(Long id, Person person) {
        personGateWay.update(id,person);
        return null;
    }
}
