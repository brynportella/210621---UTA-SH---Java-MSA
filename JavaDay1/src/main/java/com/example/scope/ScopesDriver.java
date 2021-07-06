package com.example.scope;

public class ScopesDriver {
	
	public static void main(String[] args) {
		
		//Create a new instance of our ScopesAndMods class
		ScopesAndMods sm = new ScopesAndMods();
		
		//We can use this to access instance variables and static variables
		System.out.println(sm.a);
		System.out.println(sm.str);
		
		ScopesAndMods sm2 = new ScopesAndMods();
		
		sm2.str = "I am a new string";
		
		System.out.println(sm.str);
		System.out.println(sm2.str);
		
		//The proper way to access static variables and methods
		System.out.println(ScopesAndMods.CONSTANT);
		ScopesAndMods.Hello();
	}
	
}
