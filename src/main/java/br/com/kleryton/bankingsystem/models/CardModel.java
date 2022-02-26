package br.com.kleryton.bankingsystem.models;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.kleryton.bankingsystem.models.enums.CardFlag;

@Entity

@Table(name = "TB_CARD")

public class CardModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(nullable = false, unique = true)
	private String nameCard;

	@Column(nullable = false)
	private CardFlag flag;

	@Column(nullable = false, unique = true)
	private Integer number;

	@Column(nullable = false)
	private Integer digitCode;

	@Column(nullable = false)
	private double limitBalance;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AccountModel_id")
	private AccountModel accountModel;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "typeCard_id")
	private TypeCardModel tyCard;

	public CardModel() {
	}

	public CardModel(String nameCard, CardFlag flag, Integer number, Integer digitCode, double limitBalance,
			AccountModel account, TypeCardModel tyCard) {
		this.nameCard = nameCard;
		this.flag = flag;
		this.number = number;
		this.digitCode = digitCode;
		this.limitBalance = limitBalance;
		this.accountModel = account;
		this.tyCard = tyCard;
	}

	public UUID getId() {
		return id;
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

	public AccountModel getAccount() {
		return accountModel;
	}

	public void setAccount(AccountModel account) {
		this.accountModel = account;
	}

	public TypeCardModel getTyCard() {
		return tyCard;
	}

	public void setTyCard(TypeCardModel tyCard) {
		this.tyCard = tyCard;
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
