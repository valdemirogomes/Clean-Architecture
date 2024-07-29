package infraestructure.gateways;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.person.api.core.entity.Person;
import com.person.api.core.gateways.PersonGateWay;

import infraestructure.persistense.PersonEntity;
import infraestructure.persistense.PersonRepository;
@Component
public class PersonRepositoryGateWay implements PersonGateWay {
	
	private final PersonRepository personRepository;
	private final PersonEntityMapper personEntityMapper;
	
	

	public PersonRepositoryGateWay(PersonRepository personRepository, PersonEntityMapper personEntityMapper) {
		this.personRepository = personRepository;
		this.personEntityMapper = personEntityMapper;
	}



	@Override
	public Person createPerson(Person person) {
		PersonEntity entity = personEntityMapper.toEntity(person);
		PersonEntity newPerson = personRepository.save(entity);
		return personEntityMapper.toPerson(newPerson);
		 
	}



	@Override
	public List<Person> getAllPerson() {
		
		return personRepository
				.findAll()
				.stream()
				.map(personEntityMapper::toPerson)
				.collect(Collectors.toList());
	}

}
