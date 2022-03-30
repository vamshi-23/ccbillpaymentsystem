package com.cg.creditcardpayment.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.creditcardpayment.bean.Transaction;
import com.cg.creditcardpayment.controller.TransactionController;
import com.cg.creditcardpayment.exception.TransactionException;
import com.cg.creditcardpayment.repository.TransactionRepository;
import com.cg.creditcardpayment.service.ITransactionService;

@Service
public class TransactionImplementation implements ITransactionService {

	/*
	 * The annotation @Autowired in spring boot is used to auto-wire a bean into
	 * another bean. In this it loads all the repository queries in Dao class.
	 */
	@Autowired
	private TransactionRepository repository;
	/*
	 * In this transaction method we will able to add newtransaction details to the
	 * repository to the database. If we add with the existing Id or transaction
	 * this will exception like card already exists.
	 */

	// Creating and Initializing the logger object in the logger variable

	Logger log = LoggerFactory.getLogger(TransactionController.class);

	@Override
	public Transaction addTransaction(Transaction transaction) throws TransactionException {
		if (repository.existsById(transaction.getTransactionId())) {
			log.info("Transaction added");
			throw new TransactionException("Transaction already exists");
		}
		Transaction tran = repository.save(transaction);
		log.error("Transaction not added");
		return tran;
	}

	/*
	 * In this Remove transaction method it will check with the existing tranId with
	 * the repository If the tranId is present then the transaction(tranId) wired
	 * with repository logic and remove the Id from database If it is removed the
	 * status is equals 1 and throws one exception. If the Id is not present then
	 * the else part Exception will throw.
	 */

	@Override
	public Transaction removeTransaction(long id) throws TransactionException {
		log.info("Transaction removed");
		Integer Status = repository.removeTransaction(id);
		if (Status == 1) {

			throw new TransactionException("Transaction" + id + "is deleted");
		} else {

			throw new TransactionException("Transaction does not exist");
		}

	}

	/*
	 * Using this update method we are update transaction details using tranId If
	 * the Id present in database it will get updated and then it will save. if we
	 * did not find the cardId or Id cardId is zero or negative then this method
	 * throws exceptions.
	 */

	@Override
	public Transaction updateTransaction(long id, Transaction transaction) throws TransactionException {
		if (repository.existsById(id)) {
			log.info("Transaction updated");
			return repository.save(transaction);
		} else {

			throw new TransactionException("Transaction not found");
		}

	}

	/*
	 * In this below method we can fetch the particular card details with the help
	 * of tranId. If the Id present in database it will fetch the details and return
	 * to object display. if we did not find the tranId is zero or negative then
	 * this method throws exceptions.
	 */

	@Override
	public Transaction getTransactionDetails(long id) {
		log.info("get transaction");

		return repository.getTransactionDetails(id);
	}

	/*
	 * Using the List<transaction> we can fetch all the transaction present in the
	 * data base.
	 */

	@Override
	public List<Transaction> getAllTransactions() {
		log.info("get all Transaction");
		List<Transaction> listOfTransactions = repository.getAllTransactions();
		return listOfTransactions;
	}

	/*
	 * Using this update method we are update transaction details using tranId If
	 * the Id present in database it will get updated and then it will save. if we
	 * did not find the cardId or Id cardId is zero or negative then this method
	 * throws exceptions.
	 */

	@Override
	public Transaction updateTransaction(long id) throws TransactionException {
		if (repository.existsById(id)) {
			log.info("Transaction updated");
			return repository.save(updateTransaction(0));
		} else {
			throw new TransactionException("Transaction not found");
		}

	}
}
