package com.example.inheritance;

public class Dog extends Animal{
	
	int age;
	
	public Dog() {
		//super() makes a call to the parent classes constructor
		super("Dog");
		System.out.println("Inside of dog no-arg");
	}
	
	public Dog(int age) {
		this();
		System.out.println("Inside of the dog one-arg");
		this.age = age;
	}
	
	void bark() {
		System.out.println("Doggo barking");
	}
	
}
