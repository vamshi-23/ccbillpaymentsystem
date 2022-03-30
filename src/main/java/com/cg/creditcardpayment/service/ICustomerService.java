package com.cg.creditcardpayment.service;

import java.util.List;

import com.cg.creditcardpayment.bean.Customer;
import com.cg.creditcardpayment.exception.CustomerException;
import com.cg.creditcardpayment.exception.UserIdDoesNotExistException;

public interface ICustomerService {
	public Customer addCustomer(Customer customer) throws CustomerException;

	public Customer removeCustomer(long custId) throws CustomerException;

	public Customer updateCustomer(long custId, Customer customer) throws CustomerException, UserIdDoesNotExistException;

	public Customer getCustomer(long custId) throws CustomerException;

	public List<Customer> getAllCustomers();
}
