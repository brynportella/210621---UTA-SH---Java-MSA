package com.example.collections;

import java.util.Random;

public class User implements Comparable<User>{
	
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	
	public User(String firstName, String lastName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = firstName  + lastName + (new Random().nextInt(9000) + 1000);
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUserName() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User: firstName: " + firstName + " lastName: " + lastName + " username: " + username + 
				" password: " + password;
	}

	@Override
	public int compareTo(User o) {
		
		if(this.username.compareTo(o.username) > 0) {
			return 1;
		} else if(this.username.compareTo(o.username) < 0) {
			return - 1;
		}else {
			return 0;
		}
		
	}
	
}
