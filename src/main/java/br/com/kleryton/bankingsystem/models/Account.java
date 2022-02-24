package br.com.kleryton.bankingsystem.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

@Table(name = "TB_ACCOUNT")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String nameOwner;

	@Column(nullable = false, unique = true)
	private Integer agencyCode;

	@Column(nullable = false, unique = true)
	private Integer accountCode;

	@Column(nullable = false, length = 1)
	private Integer verificationDigital;

	@Column(nullable = false, unique = true)
	private String register_id;

	@ManyToOne
	@JoinColumn(name = "card_id")
	private Set<Card> cards = new HashSet<>();

	public Long getId() {
		return id;
	}

	public String getNameOwner() {
		return nameOwner;
	}

	public void setNameOwner(String nameOwner) {
		this.nameOwner = nameOwner;
	}

	public Integer getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode(Integer agencyCode) {
		this.agencyCode = agencyCode;
	}

	public Integer getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(Integer accountCode) {
		this.accountCode = accountCode;
	}

	public Integer getVerificationDigital() {
		return verificationDigital;
	}

	public void setVerificationDigital(Integer verificationDigital) {
		this.verificationDigital = verificationDigital;
	}

	public String getRegister_id() {
		return register_id;
	}

	public void setRegister_id(String register_id) {
		this.register_id = register_id;
	}

	public Set<Card> getCards() {
		return cards;
	}

	public void setCards(Card cards) {
		this.cards.add(cards);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountCode, agencyCode, cards, id, nameOwner, register_id, verificationDigital);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(accountCode, other.accountCode) && Objects.equals(agencyCode, other.agencyCode)
				&& Objects.equals(cards, other.cards) && Objects.equals(id, other.id)
				&& Objects.equals(nameOwner, other.nameOwner) && Objects.equals(register_id, other.register_id)
				&& Objects.equals(verificationDigital, other.verificationDigital);
	}

}
