package br.com.kleryton.bankingsystem.responseDto;

import java.util.Set;
import java.util.stream.Collectors;

import br.com.kleryton.bankingsystem.models.CardModel;
import br.com.kleryton.bankingsystem.models.enums.CardFlag;

public class CardResponseDto {

	private Long id;
	private String nameCard;
	private CardFlag flag;
	private String number;
	private String digitCode;
	private double limitBalance;
	private String typeCardModel;

	public CardResponseDto() {
	}

	public CardResponseDto(CardModel cardModel) {
		this.id = cardModel.getId();
		this.nameCard = cardModel.getNameCard();
		this.flag = cardModel.getFlag();
		this.number = cardModel.getNumber();
		this.digitCode = cardModel.getDigitCode();
		this.limitBalance = cardModel.getLimitBalance();
		this.typeCardModel = cardModel.getTypeCard().toString();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameCard() {
		return nameCard;
	}

	public void setNameCard(String nameCard) {
		this.nameCard = nameCard;
	}

	public CardFlag getFlag() {
		return flag;
	}

	public void setFlag(CardFlag flag) {
		this.flag = flag;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDigitCode() {
		return digitCode;
	}

	public void setDigitCode(String digitCode) {
		this.digitCode = digitCode;
	}

	public double getLimitBalance() {
		return limitBalance;
	}

	public String getTypeCardModel() {
		return typeCardModel;
	}

	public void setTypeCardModel(String typeCardModel) {
		this.typeCardModel = typeCardModel;
	}

	public void setLimitBalance(double limitBalance) {
		this.limitBalance = limitBalance;
	}

		// Coverte uma lista de cards em uma List de response DTO
	public Set<CardResponseDto> convertToDto(Set<CardModel> cards) {
		return cards.stream().map(CardResponseDto::new).collect(Collectors.toSet());
	}
}
