package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@AllArgsConstructor(onConstructor= @__(@Autowired))
public class UserService {
	
	private UserRepo uDao;
	
	public boolean registerUser(User u) {
		try {
			uDao.save(u);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public User loginUser(String username, String password) {
		User u = uDao.findByUsername(username);
		
		if(u == null) {
			return null;
		}
		else {
			if(!u.getPassword().equals(password)) {
				return null;
			}
			else {
				return u;
			}
		}
	}
	
	public User displayUser(String username) {
		User u = uDao.findByUsername(username);
		
		if(u == null) {
			return null;
		}
		
		return u;
	}
	
	public User getUserById(int id) {
		return uDao.getById(id);
	}
	
}
