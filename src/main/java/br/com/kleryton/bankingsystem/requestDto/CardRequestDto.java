package br.com.kleryton.bankingsystem.requestDto;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;

import br.com.kleryton.bankingsystem.models.CardModel;
import br.com.kleryton.bankingsystem.models.enums.CardFlag;
import br.com.kleryton.bankingsystem.models.enums.TypeCardsEnum;

public class CardRequestDto {

	@Length(max = 128, message = "{campo.nameCard.caracteres}")
	@NotNull(message = "{campo.nameCard.nulo}")
	private String nameCard;

	@NotNull(message = "{campo.flag.nulo}")
	private CardFlag flag;
	
	@NotNull(message = "{campo.typeCard.nulo}")
	private TypeCardsEnum typeCard;

	@Pattern(regexp = "[0-9]{4}[\\ ][0-9]{4}[\\ ][0-9]{4}[\\ ][0-9]{4}", message = "{campo.number.invalido}")
	@NotNull(message = "{campo.typeCard.nulo}")
	private String number;

	@Pattern(regexp = "[0-9]{3}", message = "{campo.digitCode.invalido")
	@NotNull(message = "{campo.typeCard.nulo}")
	private String digitCode;

	@NotNull(message = "{campo.limitBalance.nulo}")
	@PositiveOrZero(message = "{campo.positiveorzero.postivo}")
	private double limitBalance;

	public CardRequestDto() {
	}

	public CardRequestDto(CardModel card) {
		super();
		this.nameCard = getNameCard();
		this.flag = getFlag();
		this.typeCard = getTypeCard();
		this.number = getNumber();
		this.digitCode = getDigitCode();
		this.limitBalance = getLimitBalance();
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

	public TypeCardsEnum getTypeCard() {
		return typeCard;
	}

	public void setTypeCard(TypeCardsEnum typeCard) {
		this.typeCard = typeCard;
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

	public void setLimitBalance(double limitBalance) {
		this.limitBalance = limitBalance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(digitCode, flag, limitBalance, nameCard, number, typeCard);
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
				&& Objects.equals(nameCard, other.nameCard) && Objects.equals(number, other.number)
				&& Objects.equals(typeCard, other.typeCard);
	}

}