package com.cg.creditcardpayment.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.creditcardpayment.bean.Customer;
import com.cg.creditcardpayment.exception.CustomerException;
import com.cg.creditcardpayment.exception.UserIdDoesNotExistException;
import com.cg.creditcardpayment.repository.ICustomerRepository;
import com.cg.creditcardpayment.service.ICustomerService;

@Service
public class CustomerImplementation implements ICustomerService {

	/*
	 * Injecting the ICustomerRepository into customerRepository reference using
	 * Autowired annotation.
	 */
	@Autowired
	private ICustomerRepository customerRepository;

	/*
	 * Logic to add customer into database. checking the userId using
	 * existsByUserId, if exists throwing an exception else adding into database.
	 * 
	 */
	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		Customer c = customerRepository.existsByUserId(customer.getUserId());

		if (c != null) {
			throw new CustomerException(
					"User Id Already Exists, Try choosing different or Login with the same User Id");
		}
		return customerRepository.save(customer);
	}
	
	/*
	 * logic to remove the customer data from database based on their custId.
	 */
	@Override
	public Customer removeCustomer(long custId) throws CustomerException {
		Integer status = customerRepository.removeCustomer(custId);

		if (status == 0) {
			return customerRepository.existsByCustId(custId);
		} else {
			throw new CustomerException("Customer has been Removed successfully");
		}
	}

	/*
	 * logic to get the customer details based on the custId.
	 */
	@Override
	public Customer getCustomer(long custId) throws CustomerException {
		Long id = custId;
		if (id.equals(null)) {
			throw new CustomerException("Customer Id cannot be null");
		}
		return customerRepository.getCustomer(custId);
	}

	/*
	 * logic to get all the customer details.
	 */
	@Override
	public List<Customer> getAllCustomers() {

		return customerRepository.findAll();
	}

	/*
	 * logic to update the customer details based on their customerId.
	 */
	@Override
	public Customer updateCustomer(long custId, Customer customer)
			throws CustomerException, UserIdDoesNotExistException {

		int status = customerRepository.updateCustomer(customer, custId);
		if (status == 1) {
			return customer;
		} else {
			throw new CustomerException("Invalid Customer Details, Try Again!!!");
		}
	}

}
