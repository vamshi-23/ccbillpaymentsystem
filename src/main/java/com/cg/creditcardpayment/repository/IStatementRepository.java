package com.cg.creditcardpayment.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.creditcardpayment.bean.Statement;

@Repository
public interface IStatementRepository extends JpaRepository<Statement, Long> {
	/*
	 * Deleting the statement based on statementId with the help of @Query
	 */
	@Transactional
	@Modifying
	@Query("delete from Statement s where s.statementId= ?1")
	public int removeStatement(long id);

	/*
	 * Updating the statement based on statementId with the help of @Query
	 */
	@Transactional
	@Modifying
	@Query("update Statement s set s = ?2 where s.statementId = ?1")
	public Statement updateStatement(long statementId, Statement statement);

	/*
	 * Getting the statement based on statementId with the help of @Query
	 */
	@Transactional
	@Query(value = "select s from Statement s where s.statementId= ?1")
	public Statement getStatement(long id);

	/*
	 * Getting all the statement with the help of @Query
	 */
	@Query(value = "select * from Statement s", nativeQuery = true)
	public List<Statement> getAllStatements();

}
