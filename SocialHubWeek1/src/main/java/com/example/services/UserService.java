package com.example.services;

import java.io.FileNotFoundException;
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
	
	private String file;
	private FileIO<User> io;
	
	public UserService(String file) {
		this.file = file;
		this.io = new FileIO<User>(file);
	}
	
	public User signUp(String firstName, String lastName, String password){
		ArrayList<User> users;
		
		try {
			users = io.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("Creating a blank users array");
			users = new ArrayList<User>();
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		User u = new User(firstName, lastName, password);
		
		//Check to see if the users username is already stored somewhere
		for(int i=0; i<users.size(); i++) {
			if(users.get(i).getUsername().equals(u.getUsername())) {
				Logging.logger.warn("Username created that already exists in the database");
				throw new UserNameAlreadyExistsException();
			}
		}
		
		users.add(u);
		io.writeObject(users);
		return u;
	}
	
	public User login(String username, String password){
		ArrayList<User> users;
		
		try {
			users = io.readObject();
		} catch (FileNotFoundException e) {
			users = new ArrayList<User>();
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		//We first want to loop through our users list to see if we can match a username
		for(int i=0; i<users.size(); i++) {
			//If the username exists in the file, we then want to check the passwords
			if(users.get(i).getUsername().equals(username)) {
				if(users.get(i).getPassword().equals(password)) {
					Logging.logger.info("User: " + username + "was logged in");
					System.out.println("User was signed in");
					return users.get(i);
				} else {
					Logging.logger.warn("User tried logging in with invalid credentials");
					throw new InvalidCredentialsException();
				}
			}
		}
		Logging.logger.warn("User tried logging in that does not exist");
		throw new UserDoesNotExistException();
	}
	
	public List<User> getAllUsers(){
		ArrayList<User> users;
		try {
			users = io.readObject();
		} catch (Exception e) {
			users = new ArrayList<User>();
		}
		return users;
	}
	
}
