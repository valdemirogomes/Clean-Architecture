package io.api.person.infrastructure.controller;

import io.api.person.core.domain.Person;
import io.api.person.core.usecase.*;
import io.api.person.infrastructure.dto.PersonDto;
import io.api.person.infrastructure.mapper.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/person")
@AllArgsConstructor
public class PersonController {

    private final CreatePerson createPerson;
    private final GetAllPerson getAllPerson;
    private final FyndById fyndById;
    private final UpdatePerson updatePerson;
    private final DeletePerson deletePerson;
    private final Mapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDto createPerson (@RequestBody PersonDto personDto){
        Person person = mapper.toPerson(personDto);
        return mapper.toDto(createPerson.execute(person));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PersonDto> getAllPerson (){
        return mapper.toList(getAllPerson.execute());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="/{id}")
    public Optional<PersonDto> getById (@PathVariable  Long id){
        return mapper.toOptiol(fyndById.execute(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value="/{id}")
    public PersonDto updatePerson (@PathVariable Long id, @RequestBody PersonDto personDto){
        Person person = mapper.toPerson(personDto);
        Person newPerson = updatePerson.execute(id,person);
        return mapper.toDto(newPerson);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value="/{id}")
    public void deletePerson(@PathVariable Long id){
         deletePerson.execute(id);
    }

}
