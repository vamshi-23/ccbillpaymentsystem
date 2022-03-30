package com.cg.creditcardpayment.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.creditcardpayment.bean.User;
import com.cg.creditcardpayment.exception.UserException;
import com.cg.creditcardpayment.repository.IUserRepository;
import com.cg.creditcardpayment.service.IUserService;

@Service
public class UserServiceImplementation implements IUserService {

	@Autowired
	private IUserRepository userRepository;

	/*
	 * Logic for signIn, checking the validation of the input values and throwing an
	 * exception exception or proper output.
	 */
	@Override
	public User signIn(User user) throws UserException {
		String user2 = "admin";
		String user1 = "customer";

		if (user == null) {
			throw new UserException("Invalid User Details");
		} else if (!user.getRole().equalsIgnoreCase(user1) && !user.getRole().equalsIgnoreCase(user2)) {
			throw new UserException("Invalid User Details, User role can only be either customer or admin");
		}

		User userDetails = userRepository.findById(user.getUserId()).get();
		if (userDetails == null) {
			throw new UserException("User Details doesnot exists");
		} else if (!userDetails.getPassword().equals(user.getPassword())) {
			throw new UserException("Invalid credentials");
		}

		return userDetails;
	}

	/*
	 * Logic for signOut, validating the values given by user and returning null
	 * values.
	 */
	@Override
	public User signOut(User user) throws UserException {
		if (user.equals(null)) {
			throw new UserException("User Details cannot be null");
		}
		user.setUserId(0);
		user.setPassword(null);

		return user;
	}

	/*
	 * Logic for changePassword, validating the values given by the user and
	 * throwing an exception or changing the password in the database.
	 */
	@Override
	public User changePassword(long id, User user) throws UserException {

		String password = user.getPassword();
		int status = userRepository.changePassword(password, id);

		if (status == 1) {
			return userRepository.findById(id).get();
		} else {
			throw new UserException("Password Change is not done successfully, please try again");
		}
	}

}
