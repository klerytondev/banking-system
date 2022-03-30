package br.com.kleryton.bankingsystem.requestDto;

import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;

import br.com.kleryton.bankingsystem.models.CardModel;
import br.com.kleryton.bankingsystem.models.TypeCardModel;
import br.com.kleryton.bankingsystem.models.enums.CardFlag;


public class CardRequestDto {

	@Length(max = 128, message = "{campo.nameCard.caracteres}")
	@NotEmpty(message = "{campo.namecard.nulo}")
	private String nameCard;

	private CardFlag flag;
	
	private TypeCardModel typeCard;

	@Pattern(regexp = "[0-9]{4}[\\ ][0-9]{4}[\\ ][0-9]{4}[\\ ][0-9]{4}", message = "{campo.number.invalido}")
	private String numberCard;

	@Pattern(regexp = "[0-9]{3}", message = "{campo.digitCode.invalido}")
	private String digitCode;

	@PositiveOrZero(message = "{campo.positiveorzero.postivo}")
	private double limitBalance;

	public CardRequestDto() {
	}

	public CardRequestDto(CardModel card) {
		this.nameCard = card.getNameCard();
		this.flag = card.getFlag();
		this.typeCard = card.getTypeCard();
		this.numberCard = card.getNumber();
		this.digitCode = card.getDigitCode();
		this.limitBalance = card.getLimitBalance();
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

	public TypeCardModel getTypeCard() {
		return typeCard;
	}

	public void setTypeCard(TypeCardModel typeCard) {
		this.typeCard = typeCard;
	}

	public String getNumber() {
		return numberCard;
	}

	public void setNumber(String number) {
		this.numberCard = number;
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

	public void setLimitBalance(double limitBalance) {
		this.limitBalance = limitBalance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(digitCode, flag, limitBalance, nameCard, numberCard, typeCard);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CardRequestDto other = (CardRequestDto) obj;
		return Objects.equals(digitCode, other.digitCode) && flag == other.flag
				&& Double.doubleToLongBits(limitBalance) == Double.doubleToLongBits(other.limitBalance)
				&& Objects.equals(nameCard, other.nameCard) && Objects.equals(numberCard, other.numberCard)
				&& Objects.equals(typeCard, other.typeCard);
	}

}
