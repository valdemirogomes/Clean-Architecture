package io.api.person.core.gateway;

import io.api.person.core.domain.Person;
import java.util.List;
import java.util.Optional;

public interface PersonGateWay {
    Person createPerson(Person person);
    List<Person> getAllPerson();
    Optional<Person> fyndById(Long id);
    Person update(Long id, Person person);
    Void deletePerson(Long id);



}
