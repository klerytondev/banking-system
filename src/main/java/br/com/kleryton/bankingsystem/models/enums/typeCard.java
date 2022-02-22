package br.com.kleryton.bankingsystem.models.enums;

public enum typeCard {

	CREDITO("credito"), DEBITO("debito");

	private String typeCard;

	private typeCard(String typeCard) {
		this.typeCard = typeCard;
	}

	public String getTypeCard() {
		return typeCard;
	}

	public void setTypeCard(String typeCard) {
		this.typeCard = typeCard;
	}

}
