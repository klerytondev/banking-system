package br.com.kleryton.bankingsystem.dtos;

import java.util.Objects;

import javax.persistence.Column;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;

import br.com.kleryton.bankingsystem.models.TypeCard;
import br.com.kleryton.bankingsystem.models.enums.CardFlag;

public class CardDto {

	@NotEmpty(message = "{campo.nameCard.obrigatorio}")
	@Length(max = 128, message = "{campo.nameCard.caracteres}")
	@NotNull(message = "{campo.nameCard.nulo}")
	@NotBlank
	@Column(nullable = false, unique = true)
	private String nameCard;

	@NotEmpty(message = "{campo.flag.obrigatorio}")
	@NotNull(message = "{campo.flag.nulo}")
	@NotBlank
	@Column(nullable = false)
	private CardFlag flag;

	@NotEmpty(message = "{campo.typeCard.obrigatorio}")
	@Length(max = 128, message = "{campo.typeCard.caracteres}")
	@NotNull(message = "{campo.typeCard.nulo}")
	@NotBlank
	@Column(nullable = false)
	private TypeCard typeCard;

	@NotEmpty(message = "{campo.number.obrigatorio}")
	@NotNull(message = "{campo.number.nulo}")
	@NotBlank
	@Pattern(regexp = "[0-9]{4}[\\.][0-9]{4}[\\.][0-9]{4}[\\.][0-9]{4}", message = "{campo.number.invalido}")
	@Column(nullable = false, unique = true)
	private Integer number;

	@NotEmpty(message = "{campo.digitCode.obrigatorio}")
	@NotNull(message = "{campo.digitCode.nulo}")
	@NotBlank
	@Column(nullable = false)
	@Pattern(regexp = "[0-9]{1}", message = "{campo.digit.obrigatorio}")
	private Integer digitCode;

	@NotEmpty(message = "{campo.limitBalance.obrigatorio}")
	@NotNull(message = "{campo.limitBalance.nulo}")
	@Digits(integer = 14, fraction = 2)
	@PositiveOrZero(message = "{campo.positiveorzero.postivo}")
	@Column(nullable = false)
	private double limitBalance;

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

	public TypeCard getTypeCard() {
		return typeCard;
	}

	public void setTypeCard(TypeCard typeCard) {
		this.typeCard = typeCard;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getDigitCode() {
		return digitCode;
	}

	public void setDigitCode(Integer digitCode) {
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
		CardDto other = (CardDto) obj;
		return Objects.equals(digitCode, other.digitCode) && flag == other.flag
				&& Double.doubleToLongBits(limitBalance) == Double.doubleToLongBits(other.limitBalance)
				&& Objects.equals(nameCard, other.nameCard) && Objects.equals(number, other.number)
				&& Objects.equals(typeCard, other.typeCard);
	}

}
