package com.example.inheritance;

public class Animal {

	String name = "animal";
	boolean isAlive = true;
	
	int age = 0;
	
	//This is a no-args constructor
	public Animal() {
		System.out.println("In the animal no-args");
	}
	
	public Animal(String name) {
		//We will make a call to this()
		//This will call the no-args constructor of this given class
		this();
		System.out.println("In the animal one-arg");
		this.name = name;
	}
	
	void walk() {
		System.out.println("The " + name + " is walking");
	}
	
}
