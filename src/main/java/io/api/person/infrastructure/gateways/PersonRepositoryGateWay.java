package io.api.person.infrastructure.gateways;

import io.api.person.core.domain.Person;
import io.api.person.core.gateway.PersonGateWay;
import io.api.person.infrastructure.mapper.EntityMapper;
import io.api.person.infrastructure.persistence.PersonEntity;
import io.api.person.infrastructure.persistence.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class PersonRepositoryGateWay implements PersonGateWay {

    private final PersonRepository repository;
    private final EntityMapper mapper;

    @Override
    public Person createPerson(Person person) {
        PersonEntity entity = mapper.toEntity(person);
        PersonEntity newperson = repository.save(entity);
        return mapper.toPerson(newperson);

    }

    @Override
    public List<Person> getAllPerson() {
    List<PersonEntity> personList= repository.findAll();
    return mapper.toList(personList);
    }

    @Override
    public Optional<Person> fyndById(Long id) {

        Optional<PersonEntity> result = repository.findById(id);

        return mapper.toOptional(result);
    }

    @Override
    public Person update(Long id, Person person) {
        Optional<PersonEntity> isPresentPerson = repository.findById(id);
        if (!isPresentPerson.isPresent()){
            return null;
              }

        PersonEntity entity = mapper.toEntity(person);
        entity.setId(id);
        PersonEntity newperson = repository.save(entity);
        return mapper.toPerson(newperson);                                                                              }


}
