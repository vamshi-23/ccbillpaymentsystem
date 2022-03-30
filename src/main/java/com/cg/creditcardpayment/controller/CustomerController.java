package com.cg.creditcardpayment.controller;

import java.util.List;

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

import com.cg.creditcardpayment.bean.Customer;
import com.cg.creditcardpayment.dao.CustomerImplementation;
import com.cg.creditcardpayment.exception.CustomerException;
import com.cg.creditcardpayment.exception.UserIdDoesNotExistException;

/*
 * Using RestController to access the all the CRUD operations of customer service 
 * Using RequestMapping to provide the URL as "/customers" to access these CRUD operations
 */

@RestController
@RequestMapping("/customers")
public class CustomerController {

	/**
	 * Injecting the CustomerImplementation class object into customerService
	 * reference using Autowired Annotation.
	 */
	@Autowired
	private CustomerImplementation customerService;

	/**
	 * Logger is use
	 */
	Logger log = LoggerFactory.getLogger(CustomerController.class);

	/**
	 * Using PostMapping annotation to add the Customer related information into
	 * database. Passing the collected data to addCustomer method which is available
	 * in the customerImplementation class to implement the adding logic
	 */
	@PostMapping(path = "/addCustomer")
	public Customer addCustomer(@Valid @RequestBody Customer customer) throws CustomerException {
		Customer c = customerService.addCustomer(customer);
		if (c != null) {
			log.info("Customer added successfully");
		} else {
			log.error("Customer details not added successfully");
		}

		return c;
	}

	/**
	 * Using GetMapping to fetch the values from database based on their Id. Passing
	 * the collected data to getCustomer method which is available in the
	 * customerImplementation class to implement the getting logic
	 */
	@GetMapping(path = "/getCustomer/{custId}")
	public Customer getCustomer(@RequestBody @PathVariable long custId) throws CustomerException {
		Customer c = customerService.getCustomer(custId);
		if (c != null) {
			log.info("Fetched Customer details having Customer id: " + custId);
		} else {
			log.error("Error while fetching Customer details of " + custId);
		}
		return c;
	}

	/**
	 * Using GetMapping to fetch all Customer details from database. Passing the
	 * collected data to getCustomer method which is available in the
	 * customerImplementation class to implement the getting logic
	 */
	@GetMapping(path = "/getAllCustomers/")
	public List<Customer> getAllCustomers() {
		List<Customer> c = customerService.getAllCustomers();
		if (c != null) {
			log.info("Fetched All Customer details");
		} else {
			log.error("Error while fetching Customers details");
		}
		return c;
	}

	/**
	 * Using DeleteMapping to delete the details of customer based on their
	 * customerId. Passing the collected data to removeCustomer method which is
	 * available in the customerImplementation class to implement the delete
	 * operation logic.
	 */
	@DeleteMapping(path = "/deleteCustomer/{custId}")
	public Customer deleteCustomer(@PathVariable long custId) throws CustomerException {
		log.info("Customer details hasbeen rmeoved from database having customerId: " + custId);
		return customerService.removeCustomer(custId);
	}

	/**
	 * Using PutMapping to update the details of customer based on their customerId.
	 * Passing the collected data to putCustomer method which is available in the
	 * CustomerImplementation class to implement the update operation logic.
	 */
	@PutMapping(path = "/updateCustomer/{custId}")
	public Customer updateCustomer(@PathVariable long custId, @Valid @RequestBody Customer customer)
			throws CustomerException, UserIdDoesNotExistException {

		Customer c = customerService.updateCustomer(custId, customer);
		if (c != null) {
			log.info("Customer details hasbeen updated succesfully");
		} else {
			log.error("Customer details hasnot been updated succesfully");
		}
		return c;
	}
}
