package infraestructure.controllers;

import org.springframework.stereotype.Component;

import com.person.api.core.entity.Person;

import infraestructure.dto.PersonDto;

@Component
public class PersonDtoMapper {
	
	public PersonDto toDto(Person person) {
		return new PersonDto(person.name(),person.cpfCnpj(),person.typePerson());
		
	}
	
	public Person toEntity(PersonDto personDto) {
		return new Person(null,personDto.name(),personDto.cpfCnpj(),personDto.typePerson());
		
	}

}
