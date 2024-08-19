package io.api.person.infrastructure.mapper;

import io.api.person.core.domain.Person;
import io.api.person.infrastructure.dto.PersonDto;
import io.api.person.infrastructure.persistence.PersonEntity;
import org.springframework.beans.BeanUtils;
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

    public PersonEntity toEntity (Person person){
       PersonEntity entity = new PersonEntity();
       BeanUtils.copyProperties(person,entity);
        return entity;
    }

    public Person toEntityPerson (PersonEntity entity){
        Person person = new Person(entity.getId(), entity.getName(),
                entity.getSurname(),
                entity.getAge(),
                entity.getBirth(),
                entity.getIndividualRegistration(),
                entity.getNationalIdentityCard());
        BeanUtils.copyProperties(entity, person);
        return person;
    }

    public Optional<Person> toEntityOptional (Optional<PersonEntity> entity){
        Optional<Person> optionalPerson = Optional.of(new Person(
                entity.get().getId(),
                entity.get().getName(),
                entity.get().getSurname(),
                entity.get().getAge(),
                entity.get().getBirth(),
                entity.get().getIndividualRegistration(),
                entity.get().getNationalIdentityCard()));
        BeanUtils.copyProperties(entity,optionalPerson);
        return optionalPerson;
    }

    public List<Person> toEntityPerson(List<PersonEntity> listEntity){
        List<Person> list = listEntity.stream().map(person -> new Person(
                person.getId(),
                person.getName(),
                person.getSurname(),
                person.getAge(),
                person.getBirth(),
                person.getIndividualRegistration(),
                person.getNationalIdentityCard())).toList();

        return list;
    }

}

