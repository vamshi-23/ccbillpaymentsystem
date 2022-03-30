package com.cg.creditcardpayment.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.creditcardpayment.bean.Statement;
import com.cg.creditcardpayment.exception.StatementException;
import com.cg.creditcardpayment.repository.IStatementRepository;
import com.cg.creditcardpayment.service.IStatementService;

/*
 * Using implements keyword to access the service interface in dao class
 * Using @Service annotation to perform the service interface tasks 
 * Overriding all the methods from IStatementService
*/
@Service
public class StatementImplementation implements IStatementService {
	/*
	 * Injecting the IStatementRepository interface into StatementImpl class with
	 * the help of @Autowird annotation
	 */
	@Autowired
	private IStatementRepository statementRepo;
	/*
	 * 
	*/
	Logger logger = LoggerFactory.getLogger(StatementImplementation.class);

	/*
	 * Here we are using addStatement method to add new statement to the database
	 * through repository if we provide wrong information it will throw Exception
	 */
	@Override
	public Statement addStatement(Statement statement) throws StatementException {
		if (statementRepo.existsById(statement.getStatementId())) {
			logger.error("Statement " + statement + " already exists");
			throw new StatementException("Statement " + statement.getStatementId() + " is already exists");
		} else {
			logger.info("Statement added succefully");
			return statementRepo.save(statement);
		}

	}

	/*
	 * Here in this removeStatement method it will check the statement in the
	 * database with the help of statementId if it is present then it will remove
	 * that statement from database and if it is removed the status is equal to 1
	 * and it will throws exception that is Statement statementId deleted
	 * successfully and if it is not present in the database it will throw another
	 * exception Statement does not exist
	 */
	@Override
	public Statement removeStatement(long statementId) throws StatementException {
		Integer status = statementRepo.removeStatement(statementId);
		if (status == 1) {
			logger.info("Statement " + statementId + " deleted succefully");
			throw new StatementException("Statement " + statementId + " is deleted");
		} else {
			logger.error("Statement does not exists");
			throw new StatementException("Statement does not exist");
		}
	}

	/*
	 * Using this updateStatement method we are updating the Statement details. If
	 * the statementId is present in the database then it will get updated. if the
	 * statementId is not present or it is invalid then we will get Exception.
	 */
	@Override
	public Statement updateStatement(long statementId, Statement statement) throws StatementException {
		if (statementRepo.existsById(statementId)) {
			logger.info("Statement updated succefully");
			return statementRepo.save(statement);
		} else {
			logger.error("Statement does not exist");
			throw new StatementException("Statement is not present");
		}
	}

	/*
	 * With the help of getStatement we can fetch the particular statement based on
	 * statementId. If the statementId is present in the database it will fetch the
	 * Statement details. if the statementId is not present in the database or
	 * invalid statementId then we will get Exception.
	 */
	@Override
	public Statement getStatement(long statementId) throws StatementException {
		if (statementId <= 0) {
			logger.error("Invalid Statement id");
			throw new StatementException("Statement Id can not be zero or negative");
		}
		if (!statementRepo.existsById(statementId)) {
			logger.error("Statement Id " + statementId + " does not exist");
			throw new StatementException("Statement id " + statementId + " does not exist");
		} else {
			Statement s1 = statementRepo.getStatement(statementId);
			logger.info("StatementId " + s1.getStatementId() + " " + "Billing date " + s1.getBillingDate() + " "
					+ "Due date " + s1.getDueDate() + " " + "Due amount " + s1.getDueAmount() + " " + "Customer "
					+ s1.getCustomer());
			Statement s = statementRepo.getStatement(statementId);
			return s;
		}
	}

	/*
	 * With the help of getAllStatement we can fetch all the statement present in
	 * the database. If there are some statement present in the database then we
	 * will get the list of Statement. If there are no statement in the database
	 * then we will get Exception that is No statement is available.
	 */
	@Override
	public List<Statement> getAllStatements() throws StatementException {
		List<Statement> s = statementRepo.getAllStatements();
		if (s == null) {
			logger.error("No statement is available");
			throw new StatementException("No statement is available");
		} else {
			int count = 0;
			for (Statement s1 : s) {
				logger.info("Statement" + ++count + " " + "StatementId" + s1.getStatementId() + " " + "Billing date "
						+ s1.getBillingDate() + " " + "Due date " + s1.getDueDate() + " " + "Due amount "
						+ s1.getDueAmount());
			}
			return s;
		}
	}

	@Override
	public Statement getBilledStatement() {

		return null;
	}

	@Override
	public Statement getUnbilledStatement() {

		return null;
	}

}
