package com.cg.creditcardpayment.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * @author vpadaga
 *
 */
@Entity
@Table(name = "User_Info")
public class User {

	/**
	 * changing column name to user_id in the database. using unique constraint to
	 * avoid data data redundancy
	 */
	@Id
	@Column(name = "user_id", unique = true)
	private long userId;

	/**
	 * changing column name to User_password in the database using pattern
	 * annotation to validate the password in certain pattern. using NotNull to
	 * avoid null values as input. using NotBlank to avoid blank values as input.
	 */
	@Column(name = "User_Password", nullable = false)
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message = "Password must be at least 8 characters with a special character, upper case, and lower case combination")
	@NotNull(message = "Please enter a password")
	@NotBlank(message = "Password cannot be null")
//	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

	/*
	 * Changing the name of the role as User_Role in the database with the help of
	 * column annotation. 
	 * Using NotBlank and NotNull annotations to avoid the blank
	 * and null values as input.
	 */
	@Column(name = "User_Role", nullable = false)
	@NotNull(message = "Please enter a role name")
	@NotBlank(message = "User role cannot be blank")
	private String role;

	/*
	 * Default constructor
	 */
	public User() {
		super();
	}

	/*
	 * Getter and setter methods for user class properties
	 */
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
