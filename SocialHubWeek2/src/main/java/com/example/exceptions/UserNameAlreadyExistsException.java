package com.example.exceptions;

public class UserNameAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public UserNameAlreadyExistsException() {
		super("A username was created that already exists in the database");
	}

}
