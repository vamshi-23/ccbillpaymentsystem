package com.cg.creditcardpayment.exception;

import java.time.LocalDateTime;

/*
 * In this Error class we are passing msg,url,errortime,Validation msg to show  the Exceptions with a 
 * information what error msg  and in which url, at which time, and validation
 */

public class ErrorInfo {

	String msg;
	String url;
	LocalDateTime errorTime;
	String validationMsg;

	
/*
 * this Constructor is used for the CreditcardEXception.class for method @RequestAnnotation it pass msg, url and time.
 */
	public ErrorInfo(String msg, String url, LocalDateTime errorTime) {
		super();
		this.msg = msg;
		this.url = url;
		this.errorTime = errorTime;
	}

/*
 * this Constructor is used for MethodArgumentNotValidException.class it also pass time ,url, msg and Validation msg
 * also which is bind with beanClass annotation.
 */

	public ErrorInfo(String msg, String url, LocalDateTime errorTime, String validationMsg) {
		super();
		this.msg = msg;
		this.url = url;
		this.errorTime = errorTime;
		this.validationMsg = validationMsg;
	}

}
