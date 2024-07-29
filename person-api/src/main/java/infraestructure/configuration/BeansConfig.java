package infraestructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.person.api.core.entity.usecase.CreatePersonImpl;
import com.person.api.core.entity.usecase.CreatePersonUseCase;
import com.person.api.core.gateways.PersonGateWay;

@Configuration
public class BeansConfig {
	
	@Bean
	public CreatePersonUseCase createPersonUseCase(PersonGateWay personGateWay) {
	return new CreatePersonImpl(personGateWay);
	}
}
