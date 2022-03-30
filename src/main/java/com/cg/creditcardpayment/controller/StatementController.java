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

import com.cg.creditcardpayment.bean.Statement;
import com.cg.creditcardpayment.dao.StatementImplementation;
import com.cg.creditcardpayment.exception.StatementException;

/*
 * Using @RestController to access all the CRUD operations of customer Service
 * Using @RequestMapping to provide the URL as "/statement" to access these CRUD operations
*/
@RestController
@RequestMapping("/statement")
public class StatementController {
	/*
	 * Injecting the StatementImpl class object into statementService with the help
	 * of @Autowired annotation
	 */
	@Autowired
	private StatementImplementation statementService;

	/*
	 * Using @PostMapping annotation to add the Statement related information into
	 * database. Passing the collected data to createStatement method which is
	 * available in the StatementImpl class to implement the adding logic
	 */
	@PostMapping(path = "/create")
	public Statement createStatement(@RequestBody Statement statement) throws StatementException {
		Statement s = statementService.addStatement(statement);
		return s;
	}

	/*
	 * using @DeleteMapping to delete the details of statement based on their
	 * statementId Passing the collected data to deleteStatement method which is
	 * available in the StatementImpl class to implement the delete operation logic
	 */
	@DeleteMapping(path = "/delete/{id}")
	public Statement deleteStatement(@PathVariable("id") long statementId) throws StatementException {
		Statement s = statementService.removeStatement(statementId);
		return s;
	}

	/*
	 * Using @PutMapping to update the details of Statement based on their
	 * statementId Passing the collected data to updateStatement method which is
	 * available in the StatementImpl class to implement the update operation logic
	 */
	@PutMapping(path = "/update/{id}")
	public Statement updateStatement(@PathVariable("id") long statementId, @Valid @RequestBody Statement statement)
			throws StatementException {
		return statementService.updateStatement(statementId, statement);
	}

	/*
	 * Using @GetMapping to fetch the values from database based on their
	 * statementId passing the collected data to getStatement method which is
	 * available in the StatementImpl class to implement the getting logic
	 */
	@GetMapping(path = "/getStatement/{id}")
	public Statement getStatement(@PathVariable("id") long statementId) throws StatementException {
		return statementService.getStatement(statementId);
	}

	/*
	 * Using @GetMapping to fetch the values from database passing the collected
	 * data to getAllStatement method which is available in the StatementImpl class
	 * to implement the getting logic
	 */
	@GetMapping(path = "/getAllStatement")
	public List<Statement> getAllStatement() throws StatementException {
		return statementService.getAllStatements();
	}

	@GetMapping(path = "/getBilledStatement")
	public Statement getBilledStatement() throws StatementException {
		return statementService.getBilledStatement();
	}

	@GetMapping(path = "/getUnbilledStatement")
	public Statement getUnbilledStatement() throws StatementException {
		return statementService.getUnbilledStatement();
	}
}
