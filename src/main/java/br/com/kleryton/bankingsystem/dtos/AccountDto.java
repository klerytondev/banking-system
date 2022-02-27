package br.com.kleryton.bankingsystem.dtos;

import java.util.Objects;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import br.com.kleryton.bankingsystem.models.AccountModel;

public class AccountDto {

	@NotEmpty(message = "{campo.nameOwner.obrigatorio}")
	@Length(max = 50, message = "{campo.nameOwner.caracteres}")
	@NotNull(message = "{campo.nameOwner.nulo}")
	private String nameOwner;

	@NotEmpty(message = "{campo.agencyCode.obrigatorio}")
	@Length(max = 4, message = "{campo.agencyCode.digitos}")
	@NotNull(message = "{campo.agencyCode.nulo}")
	private String agencyCode;

	@NotEmpty(message = "{campo.accountCode.obrigatorio}")
	@Length(max = 8, message = "{campo.accountCode.digitos}")
	@NotNull(message = "{campo.accountCode.nulo}")
	@Column(nullable = false, unique = true)
	private String accountCode;

	@NotEmpty(message = "{campo.verificationDigital.obrigatorio}")
	@Length(max = 1, message = "{campo.verificationDigital.digitos}")
	@NotNull(message = "{campo.verificationDigital.nulo}")
	@Column(nullable = false, unique = true)
	private String verificationDigital;

	@CPF(message = "{campo.accountcpf.invalido}")
	private String registerId;

	public AccountDto() {
	}

	public AccountDto(AccountModel accountModel) {
		super();
		this.nameOwner = accountModel.getNameOwner();
		this.agencyCode = accountModel.getAgencyCode();
		this.accountCode = accountModel.getAccountCode();
		this.verificationDigital = accountModel.getVerificationDigital();
		this.registerId = accountModel.getRegisterId();
	}

	public String getNameOwner() {
		return nameOwner;
	}

	public void setNameOwner(String nameOwner) {
		this.nameOwner = nameOwner;
	}

	public String getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getVerificationDigital() {
		return verificationDigital;
	}

	public void setVerificationDigital(String verificationDigital) {
		this.verificationDigital = verificationDigital;
	}

	public String getRegisterId() {
		return registerId;
	}

	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountCode, agencyCode, nameOwner, registerId, verificationDigital);
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
				&& Objects.equals(nameOwner, other.nameOwner) && Objects.equals(registerId, other.registerId)
				&& Objects.equals(verificationDigital, other.verificationDigital);
	}

}
