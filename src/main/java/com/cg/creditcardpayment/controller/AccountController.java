package com.cg.creditcardpayment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.creditcardpayment.bean.Account;
import com.cg.creditcardpayment.dao.AccountImplementation;
import com.cg.creditcardpayment.exception.AccountException;

/**
 * AccountController The AccountController program takes care of mapping
 */

@RestController
@RequestMapping("/account")
public class AccountController {

	/**
	 * This a local variable is the object of AccountDao which is used to access the
	 * functions in AccountServices
	 */
	@Autowired
	private AccountImplementation service;

	/**
	 * This method sends the new account details to the add method in AccountService
	 * 
	 * @Param account which contains all the account details
	 * @return response of the account details of the specific accountId
	 */
	@PostMapping(path = "/addAccount")
	public Account addAccount(@Valid @RequestBody Account account) throws AccountException {

		return service.addAccount(account);

	}

	/**
	 * This method retrieve the account details of the given account number
	 * 
	 * @param accountId to find the account details
	 * @return response of the account details of the specific accountId
	 */
	@GetMapping(path = "/getAccount/{id}")
	public Account getAccount(@PathVariable long id) {
		return service.getAccount(id);

	}

	/**
	 * This method delete the account details of the given account number
	 * 
	 * @param accountId to find the account details
	 */
	@DeleteMapping(path = "/deleteAccount/{id}")
	public Account removeAccount(@PathVariable long id) throws AccountException {
		Account ac = service.removeAccount(id);
		return ac;
	}

	/**
	 * This method retrieve all the details of accounts from the getAllAccount
	 * method in AccountDao
	 * 
	 * @return Response which contains all the details of accounts
	 */
	@GetMapping(path = "/allAccounts")
	public List<Account> getAllAccounts() {
		List<Account> allAccounts = service.getAllAccounts();
		return allAccounts;
	}

	/**
	 * This method update the account details of the given account number
	 * 
	 * @param accountId to find the account details
	 * @return the Response updated account details
	 */
	@PutMapping(path = "/update/{id}")
	public Account updateAccount(@PathVariable long id, @Valid @RequestBody Account account) throws AccountException {

		return service.updateAccount(id, account);

	}

}
