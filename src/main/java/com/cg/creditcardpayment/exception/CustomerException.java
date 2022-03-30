package com.cg.creditcardpayment.exception;

/*
 *CustomerException class 
 */
public class CustomerException extends Exception {
	
	/*
	 * collecting the exception message from the exceptions and passing it to super
	 * class constructor
	 */
	public CustomerException(String errorMsg)
	{
		super(errorMsg);
	}
}