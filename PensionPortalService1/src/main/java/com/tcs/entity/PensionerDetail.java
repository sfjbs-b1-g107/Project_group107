package com.tcs.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "PENSIONER_DETAIL")
public class PensionerDetail {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "DOB")
	private String dob;
	@Column(name = "PAN")
	private String pan;
	@Column(name = "SALARY")
	private String salaryEarned;
	@Column(name = "ALLOWANCE")
	private String allowance;
	@Column(name = "PENSION_CLASSIFICATION")
	private String pensionClassification;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BANK_ID")
	private BankDetail bankDetail;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getSalaryEarned() {
		return salaryEarned;
	}
	public void setSalaryEarned(String salaryEarned) {
		this.salaryEarned = salaryEarned;
	}
	public String getAllowance() {
		return allowance;
	}
	public void setAllowance(String allowance) {
		this.allowance = allowance;
	}
	public String getPensionClassification() {
		return pensionClassification;
	}
	public void setPensionClassification(String pensionClassification) {
		this.pensionClassification = pensionClassification;
	}
	public BankDetail getBankDetail() {
		return bankDetail;
	}
	public void setBankDetail(BankDetail bankDetail) {
		this.bankDetail = bankDetail;
	}
	
	

}
