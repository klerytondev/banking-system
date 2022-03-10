package br.com.kleryton.bankingsystem.models.enums;

import javax.validation.constraints.Pattern;

public enum CardFlag {

	MASTERCARD("mastercard"), VISA("visa"), ELO("elo");
	
	@Pattern(regexp = "MASTERCARD|VISA|ELO")
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
