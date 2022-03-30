package com.cg.creditcardpayment.bean;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/*
 * With the help of @Entity annotation we are making this class as an entity
 * and mapping it to a database table
 * Providing the table name with the help of @Table(name="")
*/
@Entity
@Table(name = "statement")
public class Statement {
	/*
	 * specifies the primary key of an entity and the @GeneratedValue provides for
	 * the specification of generation strategies for the values of primary keys.
	 */
	@Id
	@Column(name = "statement_id")
	@SequenceGenerator(name = "statementIdGen", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "statementIdGen")
	private long statementId;
	/*
	 * @Column annotation is used for Adding the column name in the table of a
	 * particular database
	 * 
	 * @NotNull-a constrained CharSequence, Collection, Map, or Array is valid as
	 * long as it's not null, but it can be empty
	 */
	@Column(name = "due_amount")
	@NotNull(message = "due amount cannot be null")
	private double dueAmount;

	@Column(name = "billing_date")
	@NotNull(message = "bill date cannot be null")
	private LocalDate billingDate;

	@Column(name = "due_date")
	@NotNull(message = "due date cannot be null")
	private LocalDate dueDate;
	/*
	 * JPA allows you to define Many-to-one relationships between entity classes
	 * using the @ManyToOne annotation
	 */
	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	private Customer customer;

	/*
	 * Adding getters and setters for retrieving and updating the values.
	 */

	public long getStatementId() {
		return statementId;
	}

	public void setStatementId(long statementId) {
		this.statementId = statementId;
	}

	public double getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(double dueAmount) {
		this.dueAmount = dueAmount;
	}

	public LocalDate getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
