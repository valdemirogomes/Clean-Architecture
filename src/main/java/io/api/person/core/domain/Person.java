package io.api.person.core.domain;


import java.util.Date;
public record Person(Long id,
                     String name,
                     String surname,
                     Integer age,
                     Date birth,
                     String individualRegistration,
                     String nationalIdentityCard) {

}
