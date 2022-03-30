package com.cg.creditcardpayment.service;

import java.util.List;

import com.cg.creditcardpayment.bean.Statement;
import com.cg.creditcardpayment.exception.StatementException;

public interface IStatementService {

	public Statement addStatement(Statement statement) throws StatementException;

	public Statement removeStatement(long id) throws StatementException;

	public Statement updateStatement(long id, Statement statement) throws StatementException;

	public Statement getStatement(long id) throws StatementException;

	public List<Statement> getAllStatements() throws StatementException;

	public Statement getBilledStatement();

	public Statement getUnbilledStatement();
}
