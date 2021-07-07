package com.example.dao;

import com.example.models.User;

public interface UserDao {
	
	User getUserByUsername(String username);
	User addUser(User u);
	
}
