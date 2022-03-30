package com.cg.creditcardpayment.exception;

/*
 * In this class we are creating an ExceptionHandler called StatementException. It extends
 * to the super class of Exception and check for Exception and throw manual message to the user using String error message.
*/
public class StatementException extends Exception {
	public StatementException(String exp) {
		super(exp);
	}
}
