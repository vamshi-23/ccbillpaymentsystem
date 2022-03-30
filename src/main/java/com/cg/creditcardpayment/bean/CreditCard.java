package com.cg.creditcardpayment.bean;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
//@Entity annotation defined as an object of the given class.

@Table(name = "creditcard_info")
//@Table annotation is used to give the name to the table which we have creating in PgAdmin database

public class CreditCard {
	@Id
	/*
	 * The @Id annotation specifies the primary key of an entity.
	 */
	@SequenceGenerator(name = "cardIdGen", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cardIdGen")
	/*
	 * The @GeneratedValue provides for the specification of generation strategies
	 * for the values of primary keys.
	 * 
	 * The @SequenceGenrator we are giving name, size and starting from 1000 .
	 */
	private long cardId;

	@Pattern(regexp = "[0-9]{16}", message = "Card number should be 16 digits")
	@NotBlank(message = "Bank name should not be empty")
	@Column(unique = true)
	/*
	 * @Column(unique=true) The annotation type Column is used to specify the mapped
	 * column for a persistent property or field.
	 */
	private String cardNumber;

	@Size(min = 3, message = "Bank name should be more Than 3")
	/*
	 * @Size annotation is used to restrict the filed length to a specified value.
	 * It has attributes such as max and min which are used to set the maximum and
	 * minimum range of values.
	 */
	@NotBlank(message = "Bank name should not be empty")
	/*
	 * @NotNull annotation is used for string variables should not hold null values.
	 */
	private String bankName;
	@Size(min = 3, message = "card Type should be more Than 3")
	@NotBlank(message = "Card type should not be empty")
	private String cardType;
	@Size(min = 5, message = "Card name should be more Than 5")
	@NotBlank(message = "Card name should not be empty")
	private String cardName;

	@NotNull(message = "date should be not null")
	private LocalDate cardExpiry;

	
	/*
	 * The @NotNull Annotation is, actually, an explicit contract declaring the
	 * following A variable and method should not hold null value.
	 */
	@NotNull(message = "cvv should be empty")
	private int cvv;

	/*
	 * for all the properties use getter setter methods to initialize and fetch the
	 * values.
	 */

	public long getCardId() {
		return cardId;
	}

	public void setCardId(long cardId) {
		this.cardId = cardId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(LocalDate cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

}
