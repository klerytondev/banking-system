package br.com.kleryton.bankingsystem.requestDto;

import java.util.Objects;

public class TypeCardRequestDto {

//	@NotEmpty(message = "{campo.TypeCards.obrigatorio}")
//	@NotNull(message = "{campo.TypeCards.nulo}")
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
