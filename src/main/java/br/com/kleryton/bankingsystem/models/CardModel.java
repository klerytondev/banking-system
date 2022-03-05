package br.com.kleryton.bankingsystem.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.kleryton.bankingsystem.models.enums.CardFlag;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "TB_CARD")

public class CardModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nameCard;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private CardFlag flag;

	@Column(nullable = false, unique = true)
	private String number;

	@Column(nullable = false)
	private String digitCode;

	@Column(nullable = false)
	private double limitBalance;
		
	@Enumerated(EnumType.STRING)
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "type_card_id")
	private TypeCardModel typeCardModel;

	public CardModel() {
	}

	public CardModel(String nameCard, CardFlag flag, String number, String digitCode, double limitBalance,
			AccountModel account, TypeCardModel tyCard) {
		this.nameCard = nameCard;
		this.flag = flag;
		this.number = number;
		this.digitCode = digitCode;
		this.limitBalance = limitBalance;
		this.typeCardModel = tyCard;
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

	public void setLimitBalance(double limitBalance) {
		this.limitBalance = limitBalance;
	}

	public TypeCardModel getTyCard() {
		return typeCardModel;
	}

	public void setTyCard(TypeCardModel tyCard) {
		this.typeCardModel = tyCard;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(digitCode, flag, id, limitBalance, nameCard, number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CardModel other = (CardModel) obj;
		return Objects.equals(digitCode, other.digitCode) && flag == other.flag && Objects.equals(id, other.id)
				&& Double.doubleToLongBits(limitBalance) == Double.doubleToLongBits(other.limitBalance)
				&& Objects.equals(nameCard, other.nameCard) && Objects.equals(number, other.number);
	}

}
