package com.person.api.core.entity.usecase;

import com.person.api.core.entity.Person;
import com.person.api.core.exception.BusinessException;
import com.person.api.core.gateways.PersonGateWay;

public class CreatePersonImpl implements CreatePersonUseCase{

	private final PersonGateWay personGateWay;
	
	public CreatePersonImpl(PersonGateWay personGateWay) {
		this.personGateWay = personGateWay;
	}

	@Override
	public Person execute(Person person) {
		Person existPerson = personGateWay.getById(person.id());
		if(existPerson!=null) {
			throw new BusinessException("Person existe");
			
			
		}
		return personGateWay.createPerson(person);
	}

}
