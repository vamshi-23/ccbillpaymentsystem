package com.cg.creditcardpayment.service;

import java.util.List;

import com.cg.creditcardpayment.bean.CreditCard;
import com.cg.creditcardpayment.exception.CreditcardException;


public interface ICreditCardService {
	
	/*
	 * In this service Interface we are performing the behaviors which we are going to serve in the application.
	 * We are implementing all this services with help of Dao class.
	 * here we are importing the bean package and Exception package to access the properties and exceptions .
	 */

	public CreditCard addCreditCard(CreditCard creditCard) throws CreditcardException;
	public CreditCard removeCreditCard(long cardId) throws CreditcardException;
	public CreditCard updateCreditCard(long cardId, CreditCard card) throws CreditcardException;
	public CreditCard getCreditCard(long cardId) throws CreditcardException;
	public List<CreditCard> getAllCreditCards(); 
}
