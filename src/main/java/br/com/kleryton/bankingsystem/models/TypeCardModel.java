package br.com.kleryton.bankingsystem.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.kleryton.bankingsystem.models.enums.TypeCardsEnum;

@Entity
@Table(name = "TB_TYPE_CARD")

public class TypeCardModel implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private TypeCardsEnum typeCardsEnum;

	public  TypeCardModel() {

	}

	public TypeCardModel(TypeCardsEnum name) {
		this.typeCardsEnum = name;
	}

	public TypeCardsEnum getName() {
		return typeCardsEnum;
	}

	public void setName(TypeCardsEnum name) {
		this.typeCardsEnum = name;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
