package br.com.kleryton.bankingsystem.dtos;

import java.util.Objects;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

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

	public String getNameOwner() {
		return nameOwner;
	}

	public void setNameOwner(String nameOwner) {
		this.nameOwner = nameOwner;
	}

	public Integer getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode(Integer agencyCode) {
		this.agencyCode = agencyCode;
	}

	public Integer getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(Integer accountCode) {
		this.accountCode = accountCode;
	}

	public Integer getVerificationDigital() {
		return verificationDigital;
	}

	public void setVerificationDigital(Integer verificationDigital) {
		this.verificationDigital = verificationDigital;
	}

	public String getRegister_id() {
		return register_id;
	}

	public void setRegister_id(String register_id) {
		this.register_id = register_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountCode, agencyCode, nameOwner, register_id, verificationDigital);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountDto other = (AccountDto) obj;
		return Objects.equals(accountCode, other.accountCode) && Objects.equals(agencyCode, other.agencyCode)
				&& Objects.equals(nameOwner, other.nameOwner) && Objects.equals(register_id, other.register_id)
				&& Objects.equals(verificationDigital, other.verificationDigital);
	}

}
