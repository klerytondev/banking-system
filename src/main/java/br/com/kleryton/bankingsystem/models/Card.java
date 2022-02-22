package br.com.kleryton.bankingsystem.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.kleryton.bankingsystem.models.enums.CardFlag;
import lombok.Data;

@Entity
@Data

@Table(name = "TB_CARD")

public class Card {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String nameCard;
	@Column(nullable = false, unique = true)
	private CardFlag flag;
	@Column(nullable = false, unique = true)
	private String typeCard;
	@Column(nullable = false, unique = true)
	private String number;
	@Column(nullable = false, unique = true)
	private String digitCode;
	@Column(nullable = false, unique = true)
	private double limitBalance;
	
	
	
	

}
