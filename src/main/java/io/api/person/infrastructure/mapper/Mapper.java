package io.api.person.infrastructure.mapper;

import io.api.person.core.domain.Person;
import io.api.person.infrastructure.dto.PersonDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class Mapper {

    public PersonDto toDto(Person person){
        return new PersonDto(
                person.name(),
                person.surname(),
                person.age(),
                person.birth(),
                person.individualRegistration(),
                person.nationalIdentityCard());

    }
    public Person toPerson(PersonDto personDto){
        return new Person(
                null,
                personDto.name(),
                personDto.surname(),
                personDto.age(),
                personDto.birth(),
                personDto.individualRegistration(),
                personDto.nationalIdentityCard());

    }
    public List<PersonDto> toList(List<Person> person){
           return person.stream().map(
                    result -> new PersonDto(
                            result.name(),
                            result.surname(),
                            result.age(),
                            result.birth(),
                            result.individualRegistration(),
                            result.nationalIdentityCard())).toList();

        }

    public Optional<PersonDto> toOptiol(Optional<Person> person){
        return Optional.of(new PersonDto(
                person.get().name(),
                person.get().surname(),
                person.get().age(),
                person.get().birth(),
                person.get().individualRegistration(),
                person.get().nationalIdentityCard()));

    }
}

