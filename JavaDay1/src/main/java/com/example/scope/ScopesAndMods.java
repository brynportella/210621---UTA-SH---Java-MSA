package com.example.scope;

public class ScopesAndMods {
	
	//Order of initialization
	//The first thing that gets created when a class is called are the static variables
	//The next thing is the static initilizers
	//After that we create instance variables, followed by instance intializers
	//The last things are constructors
		
	//The first 2 variables are instance scope
	public int a = 5;
	public int b = 6;
		
	//The second 2 variables are class scope
	public static int c = 7;
	public static String str = "Hello";
		
	public final static String CONSTANT = "This can never be reasigned";
		
	static { //This is a static initalizer
		System.out.println("Some logic here in static");
		str = "Hello World";
		//a = 8;
	}
		
	{ //Instance initializer
		System.out.println("Some logic in instance");
	}
		
	//Method scope
	public void method1() {
		String hello = "Hello";
		System.out.println(hello);
		if(5 == 5) {
			//block scope
			int i = 78;
			hello += " world";
			System.out.println(hello);
		}
		//We cannot access i outside of the if block
		//System.out.println(i);
	}
		
	public static void Hello() {
		System.out.println("Hello static method");
	}
	
}
