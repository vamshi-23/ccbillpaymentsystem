package com.cg.creditcardpayment.service;

import java.util.List;

import com.cg.creditcardpayment.bean.Transaction;
import com.cg.creditcardpayment.exception.TransactionException;

public interface ITransactionService {
	/**
	 * 
	 * @param transaction
	 * @return response object transaction
	 * @throws transactionException
	 */
	
	public Transaction addTransaction(Transaction transaction) throws TransactionException;
	/**
	 * 
	 * @param id of the transaction which we want to remove
	 * @return response object of the removed transaction
	 * @throws trnsactionException
	 */

	public Transaction removeTransaction(long id) throws TransactionException;
	
	/**
	 * 
	 * @param id of the transaction which we want to update
	 * @param  transaction
	 * @return the object of the updated transaction
	 * @throws transactionException
	 */
	
	public Transaction updateTransaction(long id, Transaction transaction) throws TransactionException;
	/**
	 * 
	 * @param id of the transaction which we want to get
	 * @return the object of the transaction of that id
	 */
	
	public Transaction getTransactionDetails(long id) throws TransactionException;
	/**
	 * get all list of the transaction
	 * @return
	 */
	
	public List<Transaction> getAllTransactions();
	
	/**
	 * 
	 * @param id of the transaction which we want to get
	 * @return the object of the transaction of that id
	 */

	Transaction updateTransaction(long id) throws TransactionException;

}
