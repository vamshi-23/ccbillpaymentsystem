package com.cg.creditcardpayment.bean;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author vpadaga
 *
 */

@Entity
@Table(name = "Customer_Info")
public class Customer {

	/*
	 * Using GeneratedValue annotation to generate the custId with the help of
	 * SequenceGenerator annotation with an initialValue of 600001.
	 */
	@Id
	@SequenceGenerator(name = "custId_seq", initialValue = 600001, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custId_seq")
	private long custId;

	/*
	 * Using Pattern annotation to validate the size & characters in the name.
	 * Changing Column name in the Database to Customer_Name
	 */
	@Column(name = "Customer_Name")
	@Pattern(regexp = "[a-zA-Z\\s]{4,40}", message = "Name should be minimum 4 & maximum 40 characters")
	private String name;

	/*
	 * Using Pattern annotation to validate the proper pattern of the email &
	 * characters in the email id. Using Column annotation to change Column name in
	 * the Database to Customer_Email_Id also adding unique & NotNull constraints to
	 * the column Using NotNull annotation to avoid null value as input
	 */
	@Column(name = "Customer_Email_Id", unique = true, nullable = false)
	@NotNull(message = "Please Enter Email Id")
	@Pattern(regexp = "[A-Za-z0-9._-]+[@]{1}[a-zA-Z]{1,}[.]{1}[A-Za-z]{2,4}", message = "Please Enter valid Email Id")
	private String email;

	/*
	 * Using Pattern annotation to validate the numeric & size of the contact
	 * number. Using Column annotation to change Column name in the Database to
	 * Customer_Contact_Number also adding unique & NotNull constraints to the
	 * column. Using NotNull annotation to avoid null value as input
	 */
	@Column(name = "Customer_Contact_Number", unique = true, nullable = false)
	@Pattern(regexp = "[0-9]{10}", message = "Please Enter valid Mobile Number")
	@NotNull(message = "Please Enter Mobile Number")
	private String contactNo;

	/*
	 * Using Column annotation to change the column name in the Database to
	 * Date_Of_Birth Using NotNull annotation to avoid null value as input Using
	 * Past annotation to allow only previous dates.
	 */
	@Column(name = "Date_Of_Birth", nullable = false)
	@NotNull(message = "Please enter your Date of birth")
	private LocalDate dob;

	/*
	 * Injecting the Address class using Autowired annotation
	 */
	@Autowired
	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> address;

	/*
	 * Mapping the User class with help of OneToOne annotation joining the User_Id
	 * column with the help JoinColumn annotation
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	/*
	 * JPA allows you to define Many-to-one relationships between entity classes
	 * using the @ManyToOne annotation
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cardId")
	private CreditCard card;

	/*
	 * JPA allows you to define Many-To-Many relationships between entity classes
	 * using the @ManyToMany annotation
	 */
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Account> account;

	/*
	 * JPA allows you to define Many-to-one relationships between entity classes
	 * using the @ManyToOne annotation
	 */
	@ManyToOne
	@JoinColumn(name = "transaction_id")
	private Transaction transaction;
	
	
	/*
	 * Default constructor
	 */
	public Customer() {
		super();
	}

	/**
	 * Getter & Setter Methods for the Customer class properties
	 */

//	public String getPassword() {
//		return user.getPassword();
//	}

	public List<Account> getAccount() {
		return account;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

	public CreditCard getCard() {
		return card;
	}

	public void setCard(CreditCard card) {
		this.card = card;
	}

	public long getUserId() {
		return user.getUserId();
	}

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
}
