package br.com.kleryton.bankingsystem.dtos;

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

}
