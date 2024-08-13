package io.api.person.infrastructure.controller;

import io.api.person.core.domain.Person;
import io.api.person.core.usecase.CreatePerson;
import io.api.person.core.usecase.FyndById;
import io.api.person.core.usecase.GetAllPerson;
import io.api.person.infrastructure.dto.PersonDto;
import io.api.person.infrastructure.mapper.EntityMapper;
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
    private final GetAllPerson getAllPersonImpl;
    private final FyndById fyndById;


    private final Mapper personDtoMapper;
    private final EntityMapper x;


    @PostMapping
    public PersonDto createPerson (@RequestBody PersonDto personDto){
        Person person = personDtoMapper.toPerson(personDto);
        return personDtoMapper.toDto(createPersonUseCase.execute(person));

    }
    @GetMapping
    public List<PersonDto> getAllPerson (){
        return personDtoMapper.toList(getAllPersonImpl.execute());

    }

    @GetMapping(value="/{id}")
    public Optional<PersonDto> getById (@PathVariable  Long id){
        return personDtoMapper.toOptiol(fyndById.execute(id));

    }

}
