package com.example.services;

import com.example.dao.UserDao;
import com.example.dao.UserDaoMock;
import com.example.exceptions.InvalidCredentialsException;
import com.example.models.User;

public class UserService {
	
	private UserDao uDao = new UserDaoMock();
	
	public User register(String firstName, String lastName, String password) {
		
		User u = new User(firstName, lastName, password);
		
		uDao.addUser(u);
		
		return u;
	}
	
	public User login(String username, String password) {
		User u = uDao.getUserByUsername(username);
		if(u == null) {
			throw new InvalidCredentialsException();
		} else {
			if(!u.getPassword().equals(password)) {
				throw new InvalidCredentialsException();
			}
			else {
				System.out.println("Logged In");
				return u;
			}
		}
	}
	
}
