package com.cg.creditcardpayment.service;

import com.cg.creditcardpayment.bean.Payment;
import com.cg.creditcardpayment.exception.PaymentException;

public interface IPaymentService {
	
	public Payment addPayment(Payment payment) throws PaymentException;
	public Payment removePayment(long id) throws PaymentException;
	public Payment updatePayment(long id, Payment payment) throws PaymentException;
	public Payment getPayment(long id) throws PaymentException;


}
