package io.api.person.infrastructure.config;

import io.api.person.core.gateway.PersonGateWay;
import io.api.person.core.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    @Bean
    public CreatePerson createPerson(PersonGateWay personGateWay){
        return new CreatePersonImpl(personGateWay);
    }
    @Bean
    public GetAllPerson getAllPerson(PersonGateWay personGateWay){
        return new GetAllPersonImpl(personGateWay);
    }
    @Bean
    public FyndById fyndById(PersonGateWay personGateWay){
        return new FyndByIdImpl(personGateWay);
    }
    @Bean
    public DeletePerson deletePerson(PersonGateWay personGateWay){
        return  new DeletePersonImpl(personGateWay);
    }
}
