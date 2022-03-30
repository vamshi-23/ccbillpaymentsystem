package com.cg.creditcardpayment.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.creditcardpayment.bean.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

	/**
	 * Query to delete the customer from customer entity based on their customerId
	 */
	@Modifying
	@Transactional
	@Query("delete from Customer c where c.custId=:custId")
	Integer removeCustomer(long custId);

	/**
	 * Query to get the customer based on their customerId
	 */
	@Query("select c from Customer c where custId=:custId")
	public Customer getCustomer(long custId);

	/**
	 * Query to update the customer details based on their customerId
	 */
	@Transactional
	@Modifying
	@Query("update Customer c set c = ?1 where c.custId=?2")
	public int updateCustomer(Customer customer, long id);

	/**
	 * Query to get the customer object from the database with customerId
	 */
	@Query("select c from Customer c where c.custId=:custId")
	@Transactional
	public Customer existsByCustId(long custId);

	/**
	 * Query to get the customer object from the database with customerId
	 */
	@Query("select c from Customer c where c.custId=:custId")
	@Transactional
	public Customer existsByUserId(long custId);
}