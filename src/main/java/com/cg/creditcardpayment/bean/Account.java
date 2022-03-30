package com.cg.creditcardpayment.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * AccountEntity The Account program implements an application such that the
 * data of the account is sent to the database
 */
@Entity
@Table(name = "account_info")
public class Account {

	/**
	 * making the accountNumber as the primary key using @Id annotation generating
	 * the primary key value using @generatedValue and generation type is the
	 * sequence
	 */
	@Id
	@SequenceGenerator(name = "accNum_seq", initialValue = 1000000000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accNum_seq")
	@Column(name = "ac_number")
	private long accountNumber;
	/**
	 * This a local variable: {@link #accountName} defines the name of the Bank
	 * 
	 * @HasGetter
	 * @HasSetter
	 */
	@NotNull(message = "Account name should not be null")
	@Column(name = "account_name")
	private String accountName;
	/**
	 * This a local variable: {@link #balance} defines the balance amount remaining
	 * in the Bank account
	 * 
	 * @HasGetter
	 * @HasSetter
	 */
	@NotNull(message = "Account balance should not be null")
	@Column(name = "account_balance")
	private double balance;
	/**
	 * this local variable defines the type of the bank account
	 */
	@NotNull(message = "Account type should not be null")
	@Column(name = "account_type")
	private String type;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Customer> customer;

	/**
	 * Setters and Getters for all the local variable
	 */

	public long getAccountNumber() {
		return accountNumber;
	}

//	public List<Customer> getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(List<Customer> customer) {
//		this.customer = customer;
//	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
