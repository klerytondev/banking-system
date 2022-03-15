package br.com.kleryton.bankingsystem.responseDto;

import java.util.HashSet;
import java.util.Set;

import br.com.kleryton.bankingsystem.models.AccountModel;
import br.com.kleryton.bankingsystem.models.CardModel;

public class AccountResponseDto {

	private Long id;
	private String nameOwner;
	private String agencyCode;
	private String accountCode;
	private String verificationDigital;
	private String registerId;
	private Set<CardModel> cardModel = new HashSet<>();

	public AccountResponseDto() {
	}

	public AccountResponseDto(AccountModel accountModel) {
		this.id = accountModel.getId();
		this.nameOwner = accountModel.getNameOwner();
		this.agencyCode = accountModel.getAgencyCode();
		this.accountCode = accountModel.getAccountCode();
		this.verificationDigital = accountModel.getVerificationDigital();
		this.registerId = accountModel.getRegisterId();

		//TODO verificar getters e setter e contrutores 
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<CardModel> getCardModel() {
		return cardModel;
	}

	public void setCardModel(Set<CardModel> cardModel) {
		this.cardModel = cardModel;
	}

	public void setNameOwner(String nameOwner) {
		this.nameOwner = nameOwner;
	}

	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public void setVerificationDigital(String verificationDigital) {
		this.verificationDigital = verificationDigital;
	}

	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

	public Long getId() {
		return id;
	}

	public String getNameOwner() {
		return nameOwner;
	}

	public String getAgencyCode() {
		return agencyCode;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public String getVerificationDigital() {
		return verificationDigital;
	}

	public String getRegisterId() {
		return registerId;
	}

}
