package br.com.kleryton.bankingsystem.models;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

@Table(name = "TB_TYPE_CARD")

public class TypeCardModel implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(nullable = false)
	private TypeCardModel name;

//	@OneToOne(mappedBy = "tyCard", cascade = CascadeType.ALL)
	
	private CardModel card;

	public TypeCardModel() {

	}

	public TypeCardModel(TypeCardModel name, CardModel card) {
		this.name = name;
		this.card = card;
	}

	public UUID getId() {
		return id;
	}

	public TypeCardModel getName() {
		return name;
	}

	public void setName(TypeCardModel name) {
		this.name = name;
	}

	public CardModel getCard() {
		return card;
	}

	public void setCard(CardModel card) {
		this.card = card;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeCardModel other = (TypeCardModel) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

}
