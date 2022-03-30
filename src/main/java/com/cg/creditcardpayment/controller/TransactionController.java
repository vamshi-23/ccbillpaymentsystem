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

import com.cg.creditcardpayment.bean.Transaction;
import com.cg.creditcardpayment.dao.TransactionImplementation;
import com.cg.creditcardpayment.exception.TransactionException;
import com.cg.creditcardpayment.repository.TransactionRepository;
import com.cg.creditcardpayment.service.ITransactionService;

/*
 * Using @RestController annotation is to access the all the CRUD operation of the service class
 * Using @RequestMapping is to provide the url as "/creditcardpaymentsystem" to access this CRUD operations.
 */

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	/*
	 * Injecting the Dao class object into service using @Autowired annotation.
	 */
	
	@Autowired
	private TransactionImplementation tservices;

	   /**
	    * This method sends the new transaction details to the add method in transactionService
	    *@Param  transaction which contains all the transaction details
	    *@return response of the transaction details of the specific tranId
	    */

	// @Autowired
	// private TransactionRepository transactionRepositories
	@PostMapping(path = "/addTransaction")
	public Transaction addTransaction(@Valid @RequestBody Transaction transaction) throws TransactionException {
		return tservices.addTransaction(transaction);
	}
	
	/**
	 * This method delete the transaction details of the given tansaction number
	 * @param  tranId to find the transaction details
	 */
	

	@DeleteMapping(path = "/deleteTransaction/{id}")
	public Transaction removeTransaction(@PathVariable("id") long id) throws TransactionException {
		return tservices.removeTransaction(id);

	}
	
	  /**
	    * This method update the transaction details of the given transaction number
	    * @param  tranId to find the transaction details
     * @return the Response updated transaction details
	    */
	
	

	@PutMapping(path = "/updateTransaction/{id}")
	public Transaction updateTransaction(@PathVariable("id") long id, @Valid @RequestBody Transaction transaction)
			throws TransactionException {
		return tservices.updateTransaction(id, transaction);

	}
	
	/**
	 * This method retrieve the transaction details of the given transaction number
	 * @param  tranId to find the transaction details
	 * @return response of the transaction details of the specific tranId
	 */
	
	
	@GetMapping(path = "/getTransaction/{id}")
	public Transaction getTransactionDetails(@PathVariable("id") long id) throws TransactionException {
		return tservices.getTransactionDetails(id);

	}
	
	/**
	    * This method retrieve all the details of transaction from the getAlltransaction method in ItransactionDao
	    * @return Response which contains all the details of transaction
	    */

	@GetMapping(path = "/allTransaction")
	public List<Transaction> getAllTransactions() {
		return tservices.getAllTransactions();

	}
}