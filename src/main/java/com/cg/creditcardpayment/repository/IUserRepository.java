package com.cg.creditcardpayment.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.creditcardpayment.bean.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
	
	/*
	 * updating the password by checking the user Id. 
	 */
	@Query(value = "update User_Info set User_Password = ?1 where User_Id = ?2", nativeQuery = true)
	@Modifying
	@Transactional
	public int changePassword(String password, long id);
}
