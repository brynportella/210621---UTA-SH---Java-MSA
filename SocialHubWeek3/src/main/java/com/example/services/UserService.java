package com.example.services;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.example.dao.FileIO;
import com.example.dao.UserDao;
import com.example.dao.UserDaoMock;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UserDoesNotExistException;
import com.example.exceptions.UserNameAlreadyExistsException;
import com.example.logging.Logging;
import com.example.models.User;

public class UserService {
	
	private UserDao uDao;
	
	public UserService(UserDao u) {
		this.uDao = u;
	}
	
	public User signUp(String first, String last, String email, String password) throws UserNameAlreadyExistsException{
		User u = new User(first, last, email, password);
		
		try {
			uDao.createUser(u);
			Logging.logger.info("New user has registered");
		} catch(SQLException e) {
			Logging.logger.warn("Username created that already exists in the database");
			throw new UserNameAlreadyExistsException();
		}
		
		return u;
	}
	
	public User signIn(String username, String password) throws UserDoesNotExistException, InvalidCredentialsException{
		
		User u = uDao.getUserByUsername(username);
		
		if(u.getId() == 0) {
			Logging.logger.warn("User tried loggging in that does not exist");
			throw new UserDoesNotExistException();
		}
		else if(!u.getPassword().equals(password)) {
			Logging.logger.warn("User tried to login with invalid credentials");
			throw new InvalidCredentialsException();
		}
		else {
			Logging.logger.info("User was logged in");
			return u;
		}
	}
	
	
	
}
