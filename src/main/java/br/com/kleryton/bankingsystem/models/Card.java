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
	
	@Column(nullable = false)
	private CardFlag flag;
	
	@Column(nullable = false)
	private TypeCard typeCard;
	
	@Column(nullable = false, unique = true)
	private Integer number;
	
	@Column(nullable = false)
	private Integer digitCode;
	
	@Column(nullable = false)
	private double limitBalance;
	
	
	
	

}
