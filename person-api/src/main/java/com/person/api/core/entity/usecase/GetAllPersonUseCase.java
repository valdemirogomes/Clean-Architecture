package com.person.api.core.entity.usecase;

import java.util.List;

import com.person.api.core.entity.Person;

public interface GetAllPersonUseCase {
	public List<Person> execute();

}
