package br.com.kleryton.bankingsystem.requestDto;

import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import br.com.kleryton.bankingsystem.models.AccountModel;
import br.com.kleryton.bankingsystem.models.CardModel;

public class AccountRequestDto {

	@NotEmpty(message = "{campo.nameowner.obrigatorio}")
	@Length(max = 50, message = "{campo.nameowner.caracteres}")
	private String nameOwner;

	@NotEmpty(message = "{campo.agencyCode.obrigatorio}")
	@Length(max = 4, message = "{campo.agencyCode.digitos}")
	private String agencyCode;

	@NotEmpty(message = "{campo.accountCode.obrigatorio}")
	@Length(max = 8, message = "{campo.accountCode.digitos}")
	private String accountCode;

	@NotEmpty(message = "{campo.verificationDigital.obrigatorio}")
	@Length(max = 1, message = "{campo.verificationDigital.digitos}")
	private String verificationDigital;

	@CPF(message = "{campo.accountcpf.nulo}")
	private String registerId;
	
	private Set<CardModel> cardModel;

	public AccountRequestDto() {
	}

	public AccountRequestDto(AccountModel accountModel) {
		super();
		this.nameOwner = accountModel.getNameOwner();
		this.agencyCode = accountModel.getAgencyCode();
		this.accountCode = accountModel.getAccountCode();
		this.verificationDigital = accountModel.getVerificationDigital();
		this.registerId = accountModel.getRegisterId();
		this.cardModel = accountModel.getCard();
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
	
	public Set<CardModel> getCardModel() {
		return cardModel;
	}

	public void setCardModel(Set<CardModel> cardModel) {
		this.cardModel = cardModel;
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
		AccountRequestDto other = (AccountRequestDto) obj;
		return Objects.equals(accountCode, other.accountCode) && Objects.equals(agencyCode, other.agencyCode)
				&& Objects.equals(nameOwner, other.nameOwner) && Objects.equals(registerId, other.registerId)
				&& Objects.equals(verificationDigital, other.verificationDigital);
	}

}
