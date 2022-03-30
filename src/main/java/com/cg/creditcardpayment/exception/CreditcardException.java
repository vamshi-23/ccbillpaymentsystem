package com.cg.creditcardpayment.exception;

/*
 * In this class we are Creating an Exception Handler called CreditCardEXception .It extends to the super class
 *  of Exception and check for exception and throws manual messages to the user using String errormsg.
 * 
 */
public class CreditcardException extends Exception {
	public CreditcardException (String errormsg) {
		super(errormsg);
	}

}
