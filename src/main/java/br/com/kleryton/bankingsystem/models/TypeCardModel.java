package br.com.kleryton.bankingsystem.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TYPE_CARD", indexes = {
        @Index(name = "type_card_name_index", columnList = "name", unique = true)})

public class TypeCardModel implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
    @Column(name = "name")
	private String name;

	public  TypeCardModel() {

	}

	public TypeCardModel(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public TypeCardModel(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
