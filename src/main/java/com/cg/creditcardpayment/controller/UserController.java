package com.cg.creditcardpayment.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.creditcardpayment.bean.User;
import com.cg.creditcardpayment.dao.UserServiceImplementation;
import com.cg.creditcardpayment.exception.UserException;

/*
 * Using RestController to access the all the CRUD operations of customer service 
 * Using RequestMapping to provide the URL as "/user" to access these CRUD operations
 */

@RestController
@RequestMapping("/user")
public class UserController {

	/**
	 * Injecting the userServiceImplementation class object into the userService
	 * reference using Autowired annotation.
	 */
	@Autowired
	private UserServiceImplementation userService;

	Logger log = LoggerFactory.getLogger(CustomerController.class);

	/**
	 * Using PostMapping annotation to validate the User related information into
	 * database. Passing the collected data to addCustomer method which is available
	 * in the customerImplementation class to implement the adding logic
	 */
	@PostMapping(path = "/signin")
	public User signIn(@Valid @RequestBody User user) throws UserException {
		User u = userService.signIn(user);
		if (u != null) {
			log.info("Signin successfully");
		} 
		else {
			log.info("Signin failed");
		}
		return u;
	}

	/**
	 * Using GetMapping to signOut the user. passing the user related information to
	 * signOut which is available in the UserServiceImplementation class to
	 * implement the signOut logic.
	 */
	@GetMapping(path = "/signout/")
	public User signOut(@Valid @RequestBody User user) throws UserException {
		log.info("Signout successful");
		return userService.signOut(user);
	}

	/**
	 * Using the PutMapping to change the password of the user. passing the new
	 * values values to changePassword method which is available in the
	 * userServiceImplementation class to implement the changePassword logic.
	 */
	@PutMapping(path = "/changePassword")
	public User changePassword(@PathVariable long id, @Valid @RequestBody User user) throws UserException {
		User u = userService.changePassword(id, user);
		if(u != null) {
			log.info("Password changed successfully");
		}
		else
		{
			log.info("Password change unsuccessful");
		}
		return u;
	}
}
