package com.revature.model;

public interface Swimmer {
	//All methods in an interface are implicitly 
	//public abstract
	void swim(); //same as public abstract void swim(); 
	
	//static methods are NOT inherited 
	//they belong to the interface 
	// they have a body
	//they are usually used as helper methods
	//to perform some set action 
	//they cannot affect the state of an object 
	public static double convertMetersToLeagues(double meters) {
		return meters* .5; 
	}
	
	//If we want to add functionality in our interface
	//without breaking the other classes
	public default void dive() {
		//default implementation
	}
	
	//If we add more abstract methods they will break our code
	//void jump(); 
}
