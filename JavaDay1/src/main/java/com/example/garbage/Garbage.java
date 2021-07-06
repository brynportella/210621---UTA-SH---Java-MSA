package com.example.garbage;

public class Garbage {
	
	@Override
	protected void finalize() {
		System.out.println("Garbage's finalize() method called");
		System.out.println("Goodby cruel world!");
		System.exit(0);
	}
	
}
