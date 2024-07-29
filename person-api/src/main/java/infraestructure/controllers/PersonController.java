package infraestructure.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.person.api.core.entity.Person;
import com.person.api.core.entity.usecase.CreatePersonImpl;
import com.person.api.core.entity.usecase.CreatePersonUseCase;
import com.person.api.core.entity.usecase.GetAllPersonImpl;
import com.person.api.core.entity.usecase.GetAllPersonUseCase;

import infraestructure.dto.PersonDto;

@RestController
@RequestMapping("api/person")
public class PersonController {
	
	public final CreatePersonUseCase createPerson;
	public final GetAllPersonUseCase getAllPersonImpl;

	public final PersonDtoMapper personDtoMapper;




	public PersonController(CreatePersonImpl createPerson, GetAllPersonImpl getAllPersonImpl,
			PersonDtoMapper personDtoMapper) {
		this.createPerson = createPerson;
		this.getAllPersonImpl = getAllPersonImpl;
		this.personDtoMapper = personDtoMapper;
	}
	
	@PostMapping
	public PersonDto createPerson(@RequestBody PersonDto personDto) {
		Person person = createPerson.execute(personDtoMapper.toEntity(personDto));
		return personDtoMapper.toDto(person);
		
	}
	
	@GetMapping
	public List<PersonDto> getAll (){
		return getAllPersonImpl.execute()
				.stream()
				.map(personDtoMapper::toDto)
				.collect(Collectors.toList());
		
	}

}
