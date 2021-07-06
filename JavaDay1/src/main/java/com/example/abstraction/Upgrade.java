package com.example.abstraction;

public interface Upgrade {
	
	boolean modified = true;
	
	String getMods();
	
	//default keyword allows us to implement methods in interfaces
	default void showOff() {
		System.out.println("Showing off our cool upgrades");
	}
	
}
