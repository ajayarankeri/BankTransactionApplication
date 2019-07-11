package com.hcl.DemoBank.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Transactions")
public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long transactionNo;
	private Date transactionDate;
	private long accountNumber;
	private String transactionType;
	private double transactionAmount;
	
	
	public long getTransactionNo() {
		return transactionNo;
	}
	public void setTransactionNo(long transactionNo) {
		this.transactionNo = transactionNo;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
	
	
	
}
