package com.example.poly;

public class PolyDriver {
	
	public static void main(String[] args) {
		Overriding or1 = new Overriding();
		//Upcasting
		Parent p1 = new Overriding();
		Parent p2 = new Parent();
		
		//Doesnt work
		//Downcasting
		//Overriding or2 = new Parent();
		//We can try to force it
		//Overriding or3 = (Overriding) new Parent();
		
		//We can cast object to get the parents variables
		System.out.println("Overriding x variable:" + or1.x);
		//Even though we are pointing p1 at a Overriding object, it will return the 
		//Parents variable for x
		System.out.println("Parent x variable:" + p1.x);
		System.out.println("Parent x variable:" + p2.x);
		
		//Explicit down casting will give us the childs field value
		System.out.println("Overriding x variable: " + ((Overriding)p1).x);
		
		//The term for what we did with the variables here is "variable hiding"
		//It should be avoided since it makes the code difficult to follow
		
		// We cant use casting to get the parents method when the actual object is a child
		// The methods can be overridden, but never casted
		System.out.println("Overriding getObj(): " + or1.getObj());
		System.out.println("Overriding getObj(): " + p1.getObj());
		System.out.println("Parent getObj(): " + p2.getObj());
		
		//Since we don't inherit static methods, we can only hide them not override
		//Since they belong to the class, we can technically "cast" to get them, but it the same
		//as traditional casting
		System.out.println("Overriding static method: " + or1.hiding());
		System.out.println("Parent static method: " + p1.hiding());
		System.out.println("Parent static method: " + p2.hiding());
		System.out.println("Overriding static method: " + (((Overriding)p1).hiding()));
		
		//Note, its best to only access static fields and methods via the class name
		//This is why our IDE typically warns us about using variables like p1
		
		//The variable inherited will be the same throughout all instances due to inheritance
		final String i = "inherited boolean: ";
		System.out.println(i + or1.inherited);
		System.out.println(i + p1.inherited);
		System.out.println(i + p2.inherited);
		
		
	}
	
}
