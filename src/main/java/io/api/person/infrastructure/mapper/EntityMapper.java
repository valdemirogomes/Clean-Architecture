package io.api.person.infrastructure.mapper;

import io.api.person.core.domain.Person;
import io.api.person.infrastructure.dto.PersonDto;
import io.api.person.infrastructure.persistence.PersonEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EntityMapper {
    public PersonEntity toEntity(Person person){
        return new PersonEntity(
                person.id(),
                person.name(),
                person.surname(),
                person.age(),
                person.birth(),
                person.individualRegistration(),
                person.nationalIdentityCard());

    }

    public Person toPerson(PersonEntity person){
        return new Person(
                person.getId(),
                person.getName(),
                person.getSurname(),
                person.getAge(),
                person.getBirth(),
                person.getIndividualRegistration(),
                person.getNationalIdentityCard());

    }


    public List<Person> toList(List<PersonEntity> person){
        List<Person> list = person.stream().map(p -> new Person(
                p.getId(),
                p.getName(),
                p.getSurname(),
                p.getAge(),
                p.getBirth(),
                p.getIndividualRegistration(),
                p.getNationalIdentityCard())).toList();

        return list;
    }
    public Optional<Person> toOptional(Optional<PersonEntity> person){
        return Optional.of(new Person(
                person.get().getId(),
                person.get().getName(),
                person.get().getSurname(),
                person.get().getAge(),
                person.get().getBirth(),
                person.get().getIndividualRegistration(),
                person.get().getNationalIdentityCard()));

    }



}
