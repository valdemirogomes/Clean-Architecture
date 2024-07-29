package infraestructure.persistense;

import com.person.api.core.enums.EnumPerson;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb-person")
public class PersonEntity {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String cpfCnpj;
	@Enumerated(EnumType.STRING)
	private EnumPerson typePerson;
	
	public PersonEntity(Long id, String name, String cpfCnpj, EnumPerson typePerson) {
		super();
		this.id = id;
		this.name = name;
		this.cpfCnpj = cpfCnpj;
		this.typePerson = typePerson;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public EnumPerson getTypePerson() {
		return typePerson;
	}

	public void setTypePerson(EnumPerson typePerson) {
		this.typePerson = typePerson;
	}

}
