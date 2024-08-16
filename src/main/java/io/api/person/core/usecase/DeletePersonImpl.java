package io.api.person.core.usecase;

import io.api.person.core.gateway.PersonGateWay;

public class DeletePersonImpl implements DeletePerson{
    private final PersonGateWay personGateWay;

    public DeletePersonImpl(PersonGateWay personGateWay) {
        this.personGateWay = personGateWay;
    }

    @Override
    public void execute(Long id) {
        personGateWay.deletePerson(id);

    }
}
