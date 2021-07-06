package com.example.inheritance;

public class AnimalDriver {
	
	public static void main(String[] args) {
		System.out.println("Creating animal 1");
		Animal a1 = new Animal();
		
		System.out.println("Creating animal 2");
		Animal a2 = new Animal("Cat");
		
		
		System.out.println("Creating dog 1");
		Dog d1 = new Dog();
		
		System.out.println("Creating dog 2");
		Dog d2 = new Dog(2);
		
		a1.walk();
		a2.walk();
		d1.walk();
		
		//a2.bark() doesnt work because animal does not have the bark method
		d1.bark();
		
		System.out.println("Animal 1 age: " + a1.age);
		System.out.println("Animal 2 age: " + a2.age);
		//The age variable in the animal class is shaddowed by the age variable in the dog class
		System.out.println("Dog 2 age: " + d2.age);
	}
	
}
