package br.com.kleryton.bankingsystem.models.enums;

public enum CardFlag {

	MASTERCARD("mastercard"), VISA("visa"), ELO("elo");

	private String flag;

	private CardFlag(String flag) {
		this.flag = flag;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}
