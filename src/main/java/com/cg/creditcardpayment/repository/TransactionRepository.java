package com.cg.creditcardpayment.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.creditcardpayment.bean.Transaction;
import com.cg.creditcardpayment.exception.TransactionException;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	 /**
	   * query to delete the transaction details with respect to transaction number
	   * 
	   */
	
	// public Transaction addTransaction(Transaction transaction);
	@Transactional
	@Modifying
	@Query("delete from Transaction t WHERE t.transactionId=:tranId")
	Integer removeTransaction(long tranId);
	/**
	   * writing the  query to update the transaction details using id
	   * 
	   */
	
	@Query(value = "Update Transaction SET",nativeQuery=true)
	public Transaction updateTransaction(long tranId, Transaction transaction);
	/**
	 * sql query to get list of all transaction details
	 *
	 */

	@Query("select t from Transaction t where transactionId=:tranId")
	public Transaction getTransactionDetails(long tranId);

	/**
	 * sql query to get list of all transaction details
	 *
	 */
	
	@Query(value = "select * from Transaction_info", nativeQuery = true)
	public List<Transaction> getAllTransactions();
	@Query(" select tranId from Transaction tranId where tranId.transactionId=:id")
	@Transactional
	public Transaction existsByTransaction(long id);
	
	// public Optional<Transaction> findById(Transaction transaction);
	// public static boolean existsById(TransactionRepository transactionRepository)
	// {
	// TODO Auto-generated method stub
	// return false;
//	public Optional<Transaction> findById(Transaction transaction);
//	} 

}
