package br.com.kleryton.bankingsystem.dtos;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.kleryton.bankingsystem.models.enums.CardFlag;

public class CardDto {
	
	@NotEmpty(message = "{campo.nameCard.obrigatorio}")
	@Length(max = 128, message = "{campo.nameOwner.caracteres}")
	@NotNull(message = "{campo.nameOwner.nulo}")
	@NotBlank
	@Column(nullable = false, unique = true)
	private String nameCard;
	@NotEmpty(message = "{campo.flag.obrigatorio}")
	@NotNull(message = "{campo.flag.nulo}")
	@NotBlank
	@Column(nullable = false, unique = true)
	private CardFlag flag;
	@NotEmpty(message = "{campo.nameCard.obrigatorio}")
	@Length(max = 128, message = "{campo.nameOwner.caracteres}")
	@NotNull(message = "{campo.nameOwner.nulo}")
	@NotBlank
	@Column(nullable = false, unique = true)
	private String typeCard;
	@Column(nullable = false, unique = true)
	private String number;
	@Column(nullable = false, unique = true)
	private String digitCode;
	@Column(nullable = false, unique = true)
	private double limitBalance;

}
