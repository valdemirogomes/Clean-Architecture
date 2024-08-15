package io.api.person.infrastructure.controller;

import io.api.person.core.domain.Person;
import io.api.person.core.usecase.CreatePerson;
import io.api.person.core.usecase.FyndById;
import io.api.person.core.usecase.GetAllPerson;
import io.api.person.core.usecase.UpdatePerson;
import io.api.person.infrastructure.dto.PersonDto;
import io.api.person.infrastructure.mapper.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/person")
@AllArgsConstructor
public class PersonController {

    private final CreatePerson createPersonUseCase;
    private final GetAllPerson getAllPerson;
    private final FyndById fyndById;
    private final UpdatePerson updatePerson;
    private final Mapper personDtoMapper;


    @PostMapping
    public PersonDto createPerson (@RequestBody PersonDto personDto){
        Person person = personDtoMapper.toPerson(personDto);
        return personDtoMapper.toDto(createPersonUseCase.execute(person));

    }
    @GetMapping
    public List<PersonDto> getAllPerson (){
        return personDtoMapper.toList(getAllPerson.execute());

    }

    @GetMapping(value="/{id}")
    public Optional<PersonDto> getById (@PathVariable  Long id){
        return personDtoMapper.toOptiol(fyndById.execute(id));

    }
    @PutMapping(value="/{id}")
    public PersonDto updatePerson (@PathVariable Long id, @RequestBody PersonDto personDto){
        Person person = personDtoMapper.toPerson(personDto);
        Person newPerson = updatePerson.execute(id,person);
        return personDtoMapper.toDto(newPerson);

    }

}
