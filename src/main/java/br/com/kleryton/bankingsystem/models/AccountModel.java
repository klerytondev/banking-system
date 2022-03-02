package br.com.kleryton.bankingsystem.models;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

@Table(name = "TB_ACCOUNT")
public class AccountModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nameOwner;

	@Column(nullable = false)
	private String agencyCode;

	@Column(nullable = false, unique = true)
	private String accountCode;

	@Column(nullable = false, length = 1)
	private String verificationDigital;

	@Column(nullable = false, unique = true)
	private String registerId;

	@JsonManagedReference
	@OneToMany(mappedBy = "accountModel", cascade = CascadeType.ALL)
	private Set<CardModel> cardModel;

	public AccountModel() {
	}

	public AccountModel(String nameOwner, String agencyCode, String accountCode, String verificationDigital,
			String registerId) {
		this.nameOwner = nameOwner;
		this.agencyCode = agencyCode;
		this.accountCode = accountCode;
		this.verificationDigital = verificationDigital;
		this.registerId = registerId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameOwner() {
		return nameOwner;
	}

	public void setNameOwner(String nameOwner) {
		this.nameOwner = nameOwner;
	}

	public String getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getVerificationDigital() {
		return verificationDigital;
	}

	public void setVerificationDigital(String verificationDigital) {
		this.verificationDigital = verificationDigital;
	}

	public String getRegisterId() {
		return registerId;
	}

	public void setRegisterId(String register_id) {
		this.registerId = register_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<CardModel> getCard() {
		return cardModel;
	}

	public void setCard(CardModel cards) {
		this.cardModel.add(cards);
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountCode, agencyCode, id, nameOwner, registerId, verificationDigital);
	}

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
				&& Objects.equals(id, other.id) && Objects.equals(nameOwner, other.nameOwner)
				&& Objects.equals(registerId, other.registerId)
				&& Objects.equals(verificationDigital, other.verificationDigital);
	}

	@Override
	public String toString() {
		return "AccountModel [id=" + id + ", nameOwner=" + nameOwner + ", agencyCode=" + agencyCode + ", accountCode="
				+ accountCode + ", verificationDigital=" + verificationDigital + ", registerId=" + registerId
				+ ", cardModel=";
	}
	
	

}
