package br.com.kleryton.bankingsystem.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "TB_TYPE_CARD")

public class TypeCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private TypeCard name;

	public Long getId() {
		return id;
	}

	public TypeCard getName() {
		return name;
	}

	public void setName(TypeCard name) {
		this.name = name;
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
		TypeCard other = (TypeCard) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

}
