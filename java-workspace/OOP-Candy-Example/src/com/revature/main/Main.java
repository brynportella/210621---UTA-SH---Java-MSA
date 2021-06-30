package com.revature.main;

import javax.security.auth.callback.ChoiceCallback;

import com.revature.model.Candy;
import com.revature.model.Chocolate;

public class Main {
	public static void main(String[] args) {
		Candy candy = new Candy(); 
		//candy.type = "kit-kat"; 
		candy.setType("kit-kat");
		System.out.println(candy.getType());
		
		
		Chocolate chocolate = new Chocolate();
		chocolate.setType("chocolate");
		System.out.println(chocolate.getType());
		
		//Polymorphism
		//Covariant types 
		//Made possible by inheritance 
		Candy myChocolateCandy = new Chocolate();
		//Reference type determines what we have access to
		myChocolateCandy.setType("chocolate");
		
		//myChocolateCandy.displayChocolateExcitement(); 
		
		/*
		 * Overriding is an example 
		 * of runtime polymorphism. 
		 */
		System.out.println(myChocolateCandy.toString());//toString is called implicitly even if I didn't say it
		//The output comes from the most specifc implementation
		//the overridden version of the program.
		
		Chocolate chocolateTypeReference = (Chocolate) myChocolateCandy; 
		
		//Overloading is an example
		//of compile time polymorphism.
		chocolateTypeReference.displayChocolateExcitement();
	}
}
