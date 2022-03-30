package com.cg.creditcardpayment;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.creditcardpayment.exception.AccountException;
import com.cg.creditcardpayment.exception.CreditcardException;
import com.cg.creditcardpayment.exception.CustomerException;
import com.cg.creditcardpayment.exception.ErrorInfo;
import com.cg.creditcardpayment.exception.PaymentException;
import com.cg.creditcardpayment.exception.StatementException;
import com.cg.creditcardpayment.exception.TransactionException;
import com.cg.creditcardpayment.exception.UserException;

@ControllerAdvice
public class GlobalExceptionHandler {

	/*
	 * In CreditcardException.class we are handling and throw the exception of the
	 * methods annotation with
	 * 
	 * @RequestMapping It shows the error with message , url, date in the console.
	 */
	@ExceptionHandler(CreditcardException.class)
	public @ResponseBody ErrorInfo checkCardAlreadyExistsException(CreditcardException e, HttpServletRequest request) {
		ErrorInfo error1 = new ErrorInfo(e.getMessage(), request.getRequestURI(), LocalDateTime.now());
		return error1;
	}

	/**
	 * This function handles exception related to Statement
	 * 
	 * @param except which is object of AccountException
	 * @return ResponseEntity with HTTP status code request with localDatetime
	 */
	@ExceptionHandler(TransactionException.class)
	public @ResponseBody ErrorInfo checkTransactionException(TransactionException e, HttpServletRequest request) {
		ErrorInfo error = new ErrorInfo(e.getMessage(), request.getRequestURI(), LocalDateTime.now());
		return error;
	}

	/**
	 * This function handles exception related to Statement
	 * 
	 * @param except which is object of AccountException
	 * @return ResponseEntity with HTTP status code request with localDatetime
	 */
	@ExceptionHandler(AccountException.class)
	public @ResponseBody ErrorInfo checkAccountException(AccountException e, HttpServletRequest request) {
		ErrorInfo error = new ErrorInfo(e.getMessage(), request.getRequestURI(), LocalDateTime.now());
		return error;
	}

	@ExceptionHandler(StatementException.class)
	public @ResponseBody ErrorInfo checkStatementException(StatementException e, HttpServletRequest request) {
		ErrorInfo error1 = new ErrorInfo(e.getMessage(), request.getRequestURI(), LocalDateTime.now());
		return error1;
	}

	@ExceptionHandler(PaymentException.class)
	public @ResponseBody ErrorInfo checkPaymentIdAlreadyExistsException(PaymentException e,
			HttpServletRequest request) {
		ErrorInfo error2 = new ErrorInfo(e.getMessage(), request.getRequestURI(), LocalDateTime.now());
		return error2;
	}

	@ExceptionHandler(CustomerException.class)
	public @ResponseBody ErrorInfo checkCustomerException(CustomerException e, HttpServletRequest request) {
		ErrorInfo error1 = new ErrorInfo(e.getMessage(), request.getRequestURI(), LocalDateTime.now());
		return error1;
	}

	@ExceptionHandler(UserException.class)
	public @ResponseBody ErrorInfo checkUserException(CustomerException e, HttpServletRequest request) {
		ErrorInfo error = new ErrorInfo(e.getMessage(), request.getRequestURI(), LocalDateTime.now());
		return error;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public @ResponseBody ErrorInfo checkUserId(MethodArgumentNotValidException e, HttpServletRequest request) {
		ErrorInfo errorInfo = new ErrorInfo(e.getMessage(), request.getRequestURI(), LocalDateTime.now(),
				e.getBindingResult().toString());
		System.out.println(e.getBindingResult().toString());
		return errorInfo;
	}
}
