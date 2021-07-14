package com.example.dao;

import java.util.List;

import com.example.models.User;

public interface UserDao {
	
	List<User> getAllUsers();
	
	User getUserByUsername(String username);
	
	void createUser(User u);
	
	void updateUser(User u);
	
	void deleteUser(User u);
	
}
