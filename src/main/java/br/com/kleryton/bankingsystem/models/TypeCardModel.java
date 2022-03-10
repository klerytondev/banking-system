package br.com.kleryton.bankingsystem.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "TB_TYPE_CARD")

public class TypeCardModel implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Pattern(regexp = "MEAL_CARD|CRED_CARD|DEBI_CARD|GIFT_CARD", message = "So e permitido entradas do tipo MEAL_CARD, CRED_CARD, DEBI_CARD, GIFT_CARD")
    @Column(name = "typeCard")
	private String typeCard;

	public  TypeCardModel() {

	}

	public TypeCardModel(String name) {
		this.typeCard = name;
	}

	public String getName() {
		return typeCard;
	}

	public void setName(String name) {
		this.typeCard = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
