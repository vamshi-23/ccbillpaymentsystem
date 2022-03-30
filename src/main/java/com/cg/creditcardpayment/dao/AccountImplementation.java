package com.cg.creditcardpayment.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.creditcardpayment.bean.Account;
import com.cg.creditcardpayment.controller.AccountController;
import com.cg.creditcardpayment.exception.AccountException;
import com.cg.creditcardpayment.repository.IAccountRepository;
import com.cg.creditcardpayment.service.IAccountService;

@Service
public class AccountImplementation implements IAccountService {
	/**
	 * injecting the IAccountRepository into repository reference using autowired
	 * annotation
	 */
	@Autowired
	private IAccountRepository repository;
	/**
	 * logic to add Account into database checking the AccountNumber using
	 * ExistsByAccountNumber, if exists throwing an exception else adding into
	 * database.
	 * 
	 */

	// Creating and Initializing the logger object in the logger variable
	Logger log = LoggerFactory.getLogger(AccountController.class);

	@Override
	public Account addAccount(Account account) throws AccountException {
		if (repository.existsById(account.getAccountNumber())) {
			throw new AccountException("Account already exists");
		}
		Account acc = repository.save(account);
		if (acc != null) {
			log.info("Account added");
		} else {
			log.error("Account not added");
		}
		return acc;

	}

	/**
	 * logic to remove the Account data from database by using accountNumber
	 * 
	 */

	@Override
	public Account removeAccount(long id) throws AccountException {
		log.info("Account removed");
		Integer status = repository.removeAccount(id);
		if (status == 1) {
			throw new AccountException("Account" + id + "is deleted");
		} else {
			throw new AccountException("Account does not exist");
		}

	}

	/**
	 * logic to update the account details by using accountNumber
	 */

	@Override
	public Account updateAccount(long id, Account account) throws AccountException {

		if (repository.existsById(id)) {
			log.info("Account updated");
			return repository.save(account);
		} else {
			throw new AccountException("Account not found");
		}

	}

	/**
	 * logic to get account based on the AccountNumber
	 */

	@Override
	public Account getAccount(long id) {
		log.info("get Account");
		return repository.getAccount(id);

	}

	/**
	 * logic to get the All account details
	 */

	@Override
	public List<Account> getAllAccounts() {
		log.info("get all Accounts");
		List<Account> listOfAccounts = repository.getAllAccounts();
		return listOfAccounts;
	}

}
