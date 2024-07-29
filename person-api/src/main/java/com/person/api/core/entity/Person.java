package com.person.api.core.entity;

import com.person.api.core.enums.EnumPerson;

public record Person(
		Long id,
		String name,
		String cpfCnpj,
		EnumPerson typePerson) {

}
