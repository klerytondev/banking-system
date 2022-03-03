package br.com.kleryton.bankingsystem.requestDto;

import java.util.Objects;

import javax.validation.constraints.NotBlank;

import br.com.kleryton.bankingsystem.models.enums.TypeCardsEnum;

public class TypeCardRequestDto {

//	@NotEmpty(message = "{campo.TypeCards.obrigatorio}")
//	@NotNull(message = "{campo.TypeCards.nulo}")
	@NotBlank
	private TypeCardsEnum name;
	
	
	public TypeCardsEnum getName() {
		return name;
	}

	public void setName(TypeCardsEnum name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeCardRequestDto other = (TypeCardRequestDto) obj;
		return name == other.name;
	}

}
