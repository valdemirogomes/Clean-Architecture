package com.person.api.core.entity.usecase;

import java.util.List;

import com.person.api.core.entity.Person;
import com.person.api.core.gateways.PersonGateWay;

public class GetAllPersonImpl implements GetAllPersonUseCase{
	
	private final PersonGateWay personGateWay;
		
	public GetAllPersonImpl(PersonGateWay personGateWay) {
		this.personGateWay = personGateWay;
	}

	@Override
	public List<Person> execute() {
		return personGateWay.getAllPerson()	;	
	}

}
