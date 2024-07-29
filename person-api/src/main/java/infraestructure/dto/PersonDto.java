package infraestructure.dto;

import com.person.api.core.enums.EnumPerson;

public record PersonDto(
		String name,
		String cpfCnpj,
		EnumPerson typePerson){}
