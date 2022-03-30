package com.cg.creditcardpayment.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.creditcardpayment.bean.Payment;
import com.cg.creditcardpayment.exception.PaymentException;
import com.cg.creditcardpayment.repository.IPaymentRepository;
import com.cg.creditcardpayment.service.IPaymentService;

@Service
public class PaymentImplementation implements IPaymentService {
	
	@Autowired
	private IPaymentRepository pRepository;

	@Override
	public Payment addPayment(Payment payment) throws PaymentException {
		if(pRepository.existsById(payment.getPaymentId())) {
	      throw new PaymentException("paymentID  already exsists");
		}
		else {
			Payment p = pRepository.save(payment);
			return p;
		}
	}

	@Override
	public Payment removePayment(long id) throws PaymentException {
		Integer status=  pRepository.removePayment(id);
	      if(status==1) {
	    	  throw new PaymentException("paymentID "+id+" is deleted");
	      }
	      else {
	    	  throw new PaymentException("paymentID "+id+" not found");
	      }
	}

	@Override
	public Payment updatePayment(long id, Payment payment) throws PaymentException {
		if(pRepository.existsById(id)) {
		Payment p=pRepository.save(payment);
		return p;
		}
		else {
			throw new PaymentException("PaymentId "+id+ "not found");
		}
		
	}

	@Override
	public Payment getPayment(long id) throws PaymentException {
		if(id<=0) {
			throw new PaymentException(" PaymentId should not be zero or negative");
		}
		else if(!pRepository.existsById(id)) {
			throw new PaymentException("paymentID "+id+" doesnot exists");
		}
		else {
		Payment p=pRepository.getPayment(id);
		return p;
		}
		
	}

}
