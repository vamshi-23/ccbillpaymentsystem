package com.cg.creditcardpayment.service;

import com.cg.creditcardpayment.bean.User;
import com.cg.creditcardpayment.exception.UserException;

public interface IUserService {
	public User signIn(User user) throws UserException;

	public User signOut(User user) throws UserException;

	public User changePassword(long id, User user) throws UserException;
}
