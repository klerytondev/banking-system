package br.com.kleryton.bankingsystem.dtos;

import java.util.Objects;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.kleryton.bankingsystem.models.enums.TypeCardsEnum;

public class TypeCardDto {

	@NotEmpty(message = "{campo.TypeCards.obrigatorio}")
	@NotNull(message = "{campo.TypeCards.nulo}")
	@NotBlank
	@Column(nullable = false)
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
		TypeCardDto other = (TypeCardDto) obj;
		return name == other.name;
	}

}
