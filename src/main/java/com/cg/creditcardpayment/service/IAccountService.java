package com.cg.creditcardpayment.service;

	import java.util.List;

import com.cg.creditcardpayment.bean.Account;
import com.cg.creditcardpayment.exception.AccountException;

	public interface IAccountService {
		/**
		 * 
		 * @param account
		 * @return response object account
		 * @throws AccountException
		 */
		public Account addAccount(Account account) throws AccountException ;
		/**
		 * 
		 * @param id of the account which we want to remove
		 * @return response object of the removed account
		 * @throws AccountException
		 */
		public Account removeAccount(long id) throws AccountException ;
		/**
		 * 
		 * @param id of the account which we want to update
		 * @param  account 
		 * @return the object of the updated account
		 * @throws AccountException
		 */
		public Account updateAccount(long id, Account account) throws AccountException;
		/**
		 * 
		 * @param id of the account which we want to get
		 * @return the object of the account of that id
		 */
		public Account getAccount(long id);
		/**
		 * get all list of the accounts
		 * @return
		 */
		public List<Account> getAllAccounts();
}
