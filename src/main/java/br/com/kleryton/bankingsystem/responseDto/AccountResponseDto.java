package br.com.kleryton.bankingsystem.responseDto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.kleryton.bankingsystem.models.AccountModel;
import br.com.kleryton.bankingsystem.requestDto.CardRequestDto;

public class AccountResponseDto {

	private Long id;
	private String nameOwner;
	private String agencyCode;
	private String accountCode;
	private String verificationDigital;
	private String registerId;
	private CardRequestDto cardRequestDto;	
	
	public AccountResponseDto() {
	}

	public AccountResponseDto(AccountModel accountModel) {
		super();
		this.id = accountModel.getId();
		this.nameOwner = accountModel.getNameOwner();
		this.agencyCode = accountModel.getAgencyCode();
		this.accountCode = accountModel.getAccountCode();
		this.verificationDigital = accountModel.getVerificationDigital();
		this.registerId = accountModel.getRegisterId();
		
	}
	public AccountResponseDto(AccountModel accountModel, CardRequestDto cardRequestDto) {
		this.id = accountModel.getId();
		this.nameOwner = accountModel.getNameOwner();
		this.agencyCode = accountModel.getAgencyCode();
		this.accountCode = accountModel.getAccountCode();
		this.verificationDigital = accountModel.getVerificationDigital();
		this.registerId = accountModel.getRegisterId();
		this.cardRequestDto = cardRequestDto;
		
		
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

	public CardRequestDto getCardModel() {
		return cardRequestDto;
	}
	
	//Coverte uma lista de account em uma List de response DTO
	public List<AccountResponseDto> convertToDto(List<AccountModel> accounts) {
		return accounts.stream().map(AccountResponseDto::new).collect(Collectors.toList());
	}

}
