package com.example.garbage;

public class GarbageDriver {
	
	public static void main(String[] args) {
		
		System.out.println("Instantiate a new Garbage object");
		Garbage g1 = new Garbage();
		System.out.println("The Garbage object was created");
		
		System.out.println("Assign the varaiable g1 to some other Garbage object");
		g1 = new Garbage();
		
		System.gc();
		
		while(true) {
			System.out.println("Waiting to be collected");
		}
	}
	
}
