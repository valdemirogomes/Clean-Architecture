package com.person.api.core.entity.usecase;

import com.person.api.core.entity.Person;
import com.person.api.core.gateways.PersonGateWay;

public class CreatePersonImpl implements CreatePersonUseCase{

	private final PersonGateWay personGateWay;
	
	public CreatePersonImpl(PersonGateWay personGateWay) {
		this.personGateWay = personGateWay;
	}

	@Override
	public Person execute(Person person) {
		return personGateWay.createPerson(person);
	}

}
