package com.cg.creditcardpayment.exception;

/*
 * UserException class
 */
public class UserException extends Exception {

	/*
	 * collecting the exception message from the exceptions and passing it to super
	 * class constructor
	 */
	public UserException(String errorMessage) {
		super(errorMessage);
	}
}
