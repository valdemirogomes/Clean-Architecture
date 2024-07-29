package infraestructure.gateways;

import org.springframework.stereotype.Component;

import com.person.api.core.entity.Person;

import infraestructure.persistense.PersonEntity;

@Component
public class PersonEntityMapper {
	
	public PersonEntity toEntity (Person person) {
		return new PersonEntity(person.id(),person.name(),person.cpfCnpj(),person.typePerson());
		
	}
	
	
	public Person toPerson (PersonEntity personEntity) {
		return new Person(personEntity.getId(), personEntity.getName(),personEntity.getCpfCnpj(),personEntity.getTypePerson());
		
	}

}
