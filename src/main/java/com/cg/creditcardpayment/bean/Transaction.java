package com.cg.creditcardpayment.bean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * transaction The Transaction program implements an application such that the
 * data of the transaction is sent to the database
 */

@Entity
@Table(name = "Transaction_info")
public class Transaction {

	/**
	 * making the transactionNumber as the primary key using @Id annotation
	 * generating the primary key value using @generatedValue and generation type is
	 * the sequence
	 */
	@Id
	@SequenceGenerator(name = "trans_seq", initialValue = 10000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "trans_seq")
	@Column(name = "transaction_id")
	private Long transactionId;

	@Column(name = "card_number")
	@NotNull(message = "CardNumber Cannot to be Null")
	private String cardNumber;

	@Column(name = "trans_date")
	@NotNull(message = "date Cannot to be Null")
	private LocalDate transactionDate;

	@Column(name = "trans_time")
	private LocalTime transactionTime;

	@Column(name = "amount")
	private Double amount;

	@Column(name = "status")
	@NotNull(message = "status Cannot to be Null")
	@Enumerated(EnumType.STRING)
	private TranscationStatus status;

	@Column(name = "description")
	@NotNull(message = "description Cannot to be Null")
	private String description;

	/**
	 * Setters and Getters for all the local variable
	 */

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public LocalTime getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(LocalTime transactionTime) {
		this.transactionTime = transactionTime;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public TranscationStatus getStatus() {
		return status;
	}

	public void setStatus(TranscationStatus status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
