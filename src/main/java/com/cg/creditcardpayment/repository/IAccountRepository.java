package com.cg.creditcardpayment.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.creditcardpayment.bean.Account;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {
	/**
	 * writing the query to update the account details using id
	 * 
	 */
	@Transactional
	@Modifying
	@Query("update Account s set s = ?2 where s.accountNumber= ?1")
	public Account updateStatement(Account account, long id);

	/**
	 * query to delete the account details with respect to account number
	 * 
	 */

	@Transactional
	@Modifying
	@Query("delete from Account account where account.accountNumber=:id")
	Integer removeAccount(long id);

	/**
	 * query to get the account details by using account number
	 */

	@Query("select ac from Account ac where ac.accountNumber=:id")
	public Account getAccount(long id);

	/**
	 * sql query to get list of all account details
	 *
	 */

	@Query(value = "select * from account_info", nativeQuery = true)
	public List<Account> getAllAccounts();

	/**
	 * query to get the account by the AccountNumber
	 * 
	 */
	@Query("select ac from Account ac where ac.accountNumber=:id")
	@Transactional
	public Account existsByAccountNumber(long id);

}
