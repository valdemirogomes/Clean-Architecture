package com.person.api.core.gateways;

import java.util.List;

import com.person.api.core.entity.Person;

public interface PersonGateWay {
	 Person createPerson(Person person);
	 List<Person> getAllPerson();

}
