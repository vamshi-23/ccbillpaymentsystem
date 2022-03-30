package com.cg.creditcardpayment.exception;

/*
 * UserIdDoesNotExistException class
 */
public class UserIdDoesNotExistException extends Exception {
	
	/*
	 * collecting the exception message from the exceptions and passing it to super
	 * class constructor
	 */
	public UserIdDoesNotExistException(String message) {
		super(message);
	}
}
