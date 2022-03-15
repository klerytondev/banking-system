package br.com.kleryton.bankingsystem.requestDto;

import java.util.Objects;

import javax.validation.constraints.Pattern;

public class TypeCardRequestDto {
	
	
	@Pattern(regexp = "[a-zA-Z]", message = "Campo nulo! não foi possível inserir o typo de cartão.")
	private String name;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeCardRequestDto other = (TypeCardRequestDto) obj;
		return name == other.name;
	}

}
