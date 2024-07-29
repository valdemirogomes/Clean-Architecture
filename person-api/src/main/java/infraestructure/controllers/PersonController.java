package infraestructure.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.person.api.core.entity.Person;
import com.person.api.core.entity.usecase.CreatePersonImpl;

import infraestructure.dto.PersonDto;

@RestController
@RequestMapping("api/person")
public class PersonController {
	
	public final CreatePersonImpl createPerson;
	public final PersonDtoMapper personDtoMapper;


	public PersonController(CreatePersonImpl createPerson, PersonDtoMapper personDtoMapper) {
		this.createPerson = createPerson;
		this.personDtoMapper = personDtoMapper;
	}

	@PostMapping
	public PersonDto createPerson(@RequestBody PersonDto personDto) {
		Person person = createPerson.execute(personDtoMapper.toEntity(personDto));
		return personDtoMapper.toDto(person);
		
	}

}
