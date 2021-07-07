package com.example.exceptions;

//If we want to create a custom exception, we simply need to extend Exception
public class NegativeSpeedException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public NegativeSpeedException() {
		super("Cannot go a negative speed");
	}

}
