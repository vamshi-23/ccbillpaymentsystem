package com.cg.creditcardpayment.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.creditcardpayment.bean.CreditCard;
import com.cg.creditcardpayment.exception.CreditcardException;
import com.cg.creditcardpayment.repository.ICreditCardRepository;
import com.cg.creditcardpayment.service.ICreditCardService;
/*
 *Here we are using implements keyword to access the service interface in dao class.
 *@Service annotation is used to perform Service interface tasks.
 *And Overriding all the methods from ICreditCardService
 */
@Service
public class CreditCardImplementation implements ICreditCardService {

	/*
	 * The annotation @Autowired in spring boot is used to auto-wire a bean into another bean.
	 * In this it loads all the repository queries in Dao class.
	 */
	@Autowired
	private ICreditCardRepository repository;

	/*
	 * In this addCreditcard method we will able to add new card  details to the repository to the database.
	 * If we add with the existing Id or card number this will exception like card already exists.
	 */
	@Override
	public CreditCard addCreditCard(CreditCard creditCard) throws CreditcardException {
		if(repository.existsById(creditCard.getCardId())) {
			throw new CreditcardException("cardID Already exists");
		}
		CreditCard c=repository.save(creditCard);
		return c;
	}

	/*
	 * In this RemoveCreditCard method it will check with the existing cardId with the repository If the cardId is
	 * present then the removeCreditcard(cardId) wired with repository logic and remove the Id from database
	 * If it is removed the status is equals 1 and throws one exception. If the Id is not present then the else part
	 * Exception will throw. 
	 */
	@Override
	public CreditCard removeCreditCard(long cardId) throws CreditcardException {
		Integer status=repository.removeCreditCard(cardId);
	      if(status==1) {
			 throw new CreditcardException("card "+cardId+" is deleted");
	       }
		else {
			throw new CreditcardException("cardId "+cardId+" not found");
		}
	}
	

	/*
	 * Using this update method we are update card details using cardId
	 * If the Id present in database it will get updated and then it will save.
	 * if we did not find the cardId or Id cardId is zero or negative then this method throws exceptions.
	 */
	@Override
	public CreditCard updateCreditCard(long cardId, CreditCard card) throws CreditcardException {
		if(repository.existsById(cardId)) {
			CreditCard c= repository.save(card);
			return c; 
			
		}
		else if(cardId<=0) {
			throw new CreditcardException(" CardId should not be zero or negative");
		}
		else  {
			 throw new CreditcardException("CardID "+cardId+" NotFound");
			
		}
		
	}
	/*
	 * In this below method we can fetch the particular card details with the help of CardId.
	 * If the Id present in database it will fetch the details and return to object display.
	 * if we did not find the cardId or Id cardId is zero or negative then this method throws exceptions.
	 */

	@Override
	public CreditCard getCreditCard(long cardId) throws CreditcardException {
		if(cardId<=0) {
			throw new CreditcardException(" CardId should not be zero or negative");
		}
		else if(!repository.existsById(cardId)) {
			throw new CreditcardException("card Id "+cardId+" doesnot exists");
		}
		else {
		CreditCard G = repository.getCardId(cardId);
		return G;
		}
	}

	/*
	 * Using the List<creditcard> we can fetch all the creditcard present in the data base.
	 */
	@Override
	public List<CreditCard> getAllCreditCards() {
		List<CreditCard> ListOfCreditCard = repository.findAll();
		return ListOfCreditCard;
	}

}
