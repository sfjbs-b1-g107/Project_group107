package com.tcs.entity;

public class PensionDetail {

	private Long bankCharges;
	private Long pensionAmount;

	public Long getBankCharges() {
		return bankCharges;
	}

	public void setBankCharges(Long bankCharges) {
		this.bankCharges = bankCharges;
	}

	public Long getPensionAmount() {
		return pensionAmount;
	}

	public void setPensionAmount(Long pensionAmount) {
		this.pensionAmount = pensionAmount;
	}

	@Override
	public String toString() {
		return "PensionDetail [bankCharges=" + bankCharges + ", pensionAmount=" + pensionAmount + "]";
	}

}
