package com.cg.creditcardpayment.bean;

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

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "Customer_Address")
public class Address {

	/*
	 * using GeneratedValue annotaion to generate the addressId with the help of
	 * SequenceGenerator annotation with an initialValue of 400001.
	 */
	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 400001, name = "add_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "add_seq")
	private long addressId;

	/*
	 * changing the name of the doorNo as Door_Number in the database with the help
	 * of column annotation. 
	 * Using NotBlank and NotNull annotations to avoid the
	 * blank and null values as input.
	 */
	@Column(name = "Door_Number")
	@NotBlank(message = "Please enter valid door number")
	@NotNull(message = "Door number cannot be null")
	private String doorNo;

	/*
	 * Changing the name of the street as Street_Name in the database with the help
	 * of column annotation. Using NotBlank and NotNull annotations to avoid the
	 * blank and null values as input.
	 */
	@Column(name = "Street_Name")
	@NotNull(message = "Street name cannot be null")
	@NotBlank(message = "Please enter valid street name")
	private String street;

	/*
	 * Changing the name of the area as Area_Name in the database with the help of
	 * column annotation. Using NotBlank and NotNull annotations to avoid the blank
	 * and null values as input.
	 */
	@Column(name = "Area_Name")
	@NotNull(message = "Area name cannot be null")
	@NotBlank(message = "Please enter valid area name")
	private String area;

	/*
	 * Changing the name of the city as City_Name in the database with the help of
	 * column annotation. Using NotBlank and NotNull annotations to avoid the blank
	 * and null values as input.
	 */
	@Column(name = "City_Name")
	@NotNull(message = "City name cannot be null")
	@NotBlank(message = "Please enter valid city name")
	private String city;

	/*
	 * Changing the name of the state as State_Name in the database with the help of
	 * column annotation. Using NotBlank and NotNull annotations to avoid the blank
	 * and null values as input.
	 */
	@Column(name = "State_Name")
	@NotNull(message = "State Name cannot be null")
	@NotBlank(message = "Please enter valid state name")
	private String state;

	/*
	 * Changing the name of the pincode as Pincode in the database with the help of
	 * column annotation. Using Pattern annotation to validate the input.
	 */
	@Column(name = "Pincode")
//	@Pattern(regexp = "[0-9]{6}", message = "pincode can only be 6 digit numeric input")
	private Integer pincode;

	/*
	 * Default constructor
	 */
	public Address() {
		super();
	}

	/*
	 * Parameter constructor
	 */
	public Address(
			@NotBlank(message = "Please enter valid door number") @NotNull(message = "Door number cannot be null") String doorNo,
			@NotNull(message = "Street name cannot be null") @NotBlank(message = "Please enter valid street name") String street,
			@NotNull(message = "Area name cannot be null") @NotBlank(message = "Please enter valid area name") String area,
			@NotNull(message = "City name cannot be null") @NotBlank(message = "Please enter valid city name") String city,
			@NotNull(message = "State Name cannot be null") @NotBlank(message = "Please enter valid state name") String state,
			int pincode) {
		super();
		this.doorNo = doorNo;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	/*
	 * Getter & setter Methods for Address Class Properties
	 */
	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

}
