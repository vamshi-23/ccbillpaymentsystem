package com.cg.creditcardpayment.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.creditcardpayment.bean.CreditCard;

@Repository
public interface ICreditCardRepository extends JpaRepository<CreditCard, Long> {

	/*
	 * here we are using JPA Query to delete the card from CreditCard entity
	 * 
	 */
	@Transactional
	@Modifying
	@Query("delete from CreditCard c where c.cardId= ?1")
	public int removeCreditCard(long cardId);

	/*
	 * here we are using native query to update the details of the CreditCard by using cardId
	 */
	@Transactional
	@Modifying
	@Query(value = "Update CreditCard SET", nativeQuery = true)
	public CreditCard updateCreditCard(long cardId, CreditCard card);

	/*
	 * here we are using Jpa Query to fetch the card details by using cardId from the database.
	 */
	@Query("select card from CreditCard card where card.cardId=:cardId")
	public CreditCard getCardId(long cardId);

	
	/*
	 * here we are using nativeQuery called SQL query already exists to fetch all the CreditCards from the database.
	 */
	@Query(value = "Select * from creditcard_info", nativeQuery = true)
	public List<CreditCard> getAllCreditCard();

}
