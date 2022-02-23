package br.com.kleryton.bankingsystem.models.enums;

public enum TypeCardsEnum {

	DEBIT_CARD("cartao de debito"), CREDIT_CARD("cartao de credito"), MEAL_CARD("cartao de metal"),
	GIFT_CARD("cartao de presente");

	private String type;

	private TypeCardsEnum(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
