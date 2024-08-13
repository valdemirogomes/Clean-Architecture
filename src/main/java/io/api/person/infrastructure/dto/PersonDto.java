package io.api.person.infrastructure.dto;

import java.util.Date;

public record PersonDto(
        String name,
        String surname,
        Integer age,
        Date birth,
        String individualRegistration,
        String nationalIdentityCard
) {
}
