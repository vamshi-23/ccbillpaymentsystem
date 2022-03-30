package com.cg.creditcardpayment.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.creditcardpayment.bean.CreditCard;
import com.cg.creditcardpayment.dao.CreditCardImplementation;
import com.cg.creditcardpayment.exception.CreditcardException;

/*
 * Using @RestController annotation is to access the all the CRUD operation of the service class
 * Using @RequestMapping is to provide the url as "/creditcard" to access this CRUD operations.
 */
@RestController
@RequestMapping("/creditcard")
public class CreditCardController {

	/*
	 * Injecting the Dao class object into service using @Autowired annotation.
	 */
	@Autowired
	private CreditCardImplementation service;

	/*
	 * In this we are creating logger object with the reference of Controller.class
	 * with the help of this object we can make the application default logger into
	 * with the proper info in the console.
	 */
	Logger log = LoggerFactory.getLogger(CreditCardController.class);

	/*
	 * @PostMapping annotation is used to add the card related Information in the
	 * database. passing the collected data to addCard method which is available in
	 * the Dao class to implement the add logic.
	 * 
	 */
	@PostMapping("/addCard")
	public CreditCard addCreditCard(@Valid @RequestBody CreditCard creditCard) throws CreditcardException {
		CreditCard c = service.addCreditCard(creditCard);
		if (c != null) {
			log.info("CreditCard Created"); // If the card is created then this info is printed in spring boot console.
		} else {
			log.error("Not created");// if are not able to create the card this logger msg will print in console.
		}
		return c;
	}

	/*
	 * @GetMapping annotation is used to fetch the card details using cardId from
	 * the database. passing the collected data to getCreditcard method which is
	 * available in the Dao class to implement the fetching logic.
	 */
	@GetMapping("/getCreditcard/{id}")
	public CreditCard getCreditCard(@PathVariable("id") long cardId) throws CreditcardException {
		log.info("Feteched " + cardId + " details");
		return service.getCreditCard(cardId);

	}

	/*
	 * @Getmapping annotation using in this method called GetCreditcardDetails to
	 * fetch all Cards and card details from database. passing the collected data to
	 * getCredicardDetails method which is available in the Dao class to implement
	 * the logic.
	 */
	@GetMapping("/getCreditcarddetails")
	public List<CreditCard> getAllCreditcard() {
		log.info("Feteched all the creditcard details");
		return service.getAllCreditCards();
	}

	/*
	 * @DeleteMapping annotation is used to remove the card details from the
	 * database by using cardId. passing the collected data to removeCreditcard
	 * method which is available in the Dao class to implement the logic
	 */
	@DeleteMapping("/delete/{cardId}")
	public CreditCard removeCreditCard(@PathVariable long cardId) throws CreditcardException {
		log.info("Deleted Id: " + cardId + " details");
		return service.removeCreditCard(cardId);
	}

	/*
	 * @PutMapping annotation is used to update the card details using cardId from
	 * the database. Passing the collected data to updateCreditcard method which is
	 * available in the Dao class to implement the update logic.
	 */
	@PutMapping("/update/{cardId}")
	public CreditCard updateCreditCard(@PathVariable long cardId, @Valid @RequestBody CreditCard card)
			throws CreditcardException {
		log.info("the CardId " + card + " is updated");
		return service.updateCreditCard(cardId, card);
	}

}
