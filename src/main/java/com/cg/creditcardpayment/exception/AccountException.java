package com.cg.creditcardpayment.exception;

public class AccountException extends Exception {

   /*
    * create the AccountException 
    * collecting the exception message from the exception and passing it to super
    * class constructor
    */

	public AccountException(String exp) {
		super(exp);
	}
}
