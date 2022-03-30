package com.cg.creditcardpayment.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.creditcardpayment.bean.Payment;
import com.cg.creditcardpayment.dao.PaymentImplementation;
import com.cg.creditcardpayment.exception.PaymentException;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentImplementation pservice;
	
	Logger log=LoggerFactory.getLogger(PaymentController.class);
	
	@PostMapping("/addPayment")
	public Payment addPayment(@Valid @RequestBody Payment payment) throws PaymentException {
		Payment p=pservice.addPayment(payment);
		if(p!=null) {
			log.info("Payment is added");
		}
		else {
			log.error("Payment is not added");
		}
		return p;
	}
	@GetMapping("/getPayment/{paymentId}")
	public Payment getPayment(@PathVariable long paymentId) throws PaymentException {
		log.info("fetched payment Id:"+paymentId+" details");
		return pservice.getPayment(paymentId);
	}
	
	@PutMapping("/update/{paymentId}")
	public Payment updatePayment(@PathVariable long paymentId, @Valid @RequestBody Payment payment) throws PaymentException {
		log.info("updated details of paymentId"+paymentId);
		return pservice.updatePayment(paymentId, payment);
	}
	
	@DeleteMapping("/delete/{paymentId}")
	public Payment removePayment(@PathVariable long paymentId) throws PaymentException {
		log.info("deleted payment details of "+paymentId);
		return pservice.removePayment(paymentId);
	}
	

}
