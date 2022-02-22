package br.com.kleryton.bankingsystem.dtos;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Data
public class AccountDto {

	@NotEmpty(message = "{campo.nameOwner.obrigatorio}")
	@Length(max = 50, message = "{campo.nameOwner.caracteres}")
	@NotNull(message = "{campo.nameOwner.nulo}")
	@NotBlank
	private String nameOwner;

	@NotEmpty(message = "{campo.agencyCode.obrigatorio}")
	@Length(max = 4, message = "{campo.agencyCode.digitos}")
	@NotNull(message = "{campo.agencyCode.nulo}")
	@NotBlank
	private Integer agencyCode;

	@NotEmpty(message = "{campo.accountCode.obrigatorio}")
	@Length(max = 8, message = "{campo.accountCode.digitos}")
	@NotNull(message = "{campo.accountCode.nulo}")
	@NotBlank
	@Column(nullable = false, unique = true)
	private Integer accountCode;

	@NotEmpty(message = "{campo.verificationDigital.obrigatorio}")
	@Length(max = 1, message = "{campo.verificationDigital.digitos}")
	@NotNull(message = "{campo.verificationDigital.nulo}")
	@NotBlank
	@Column(nullable = false, unique = true)
	private Integer verificationDigital;

	@CPF(message = "{campo.OwnerCpf.invalido}")
	@NotNull(message = "{campo.OwnerCpf.nulo}")
	@NotEmpty(message = "{campo.OwnerCpf.obrigatorio}")
	private String register_id;

}
