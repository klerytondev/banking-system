package br.com.kleryton.bankingsystem.models;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity

@Table(name = "TB_ACCOUNT")
public class AccountModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

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

//	@OneToMany(mappedBy = "cardModel")
//	private Set<CardModel> cards;

	public AccountModel() {
	}

	public AccountModel(AccountModel account) {
		this.nameOwner = getNameOwner();
		this.agencyCode = getAgencyCode();
		this.accountCode = getAgencyCode();
		this.verificationDigital = getVerificationDigital();
		this.register_id = getRegister_id();
//		this.cards = getCards();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

//	public Set<CardModel> getCards() {
//		return cards;
//	}
//
//	public void setCards(CardModel cards) {
//		this.cards.add(cards);
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(accountCode, agencyCode, cards, id, nameOwner, register_id, verificationDigital);
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountModel other = (AccountModel) obj;
		return Objects.equals(accountCode, other.accountCode) && Objects.equals(agencyCode, other.agencyCode)
//				&& Objects.equals(cards, other.cards) && Objects.equals(id, other.id)
				&& Objects.equals(nameOwner, other.nameOwner) && Objects.equals(register_id, other.register_id)
				&& Objects.equals(verificationDigital, other.verificationDigital);
	}

}
