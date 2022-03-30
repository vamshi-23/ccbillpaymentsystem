package com.cg.creditcardpayment.exception;

public class TransactionException extends Exception {

	/*
	 * create the transaction Exception collecting the exception message from the
	 * exception and passing it to super class constructor
	 */

	public TransactionException(String exp) {
		super(exp);

	}

}
