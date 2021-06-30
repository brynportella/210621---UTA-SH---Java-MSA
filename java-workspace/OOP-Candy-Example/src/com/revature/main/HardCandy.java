package com.revature.main;

import com.revature.model.Candy;

public class HardCandy extends Candy{
	//We would have access to 
	//protected fields and methods 
	//of the Candy class
	
	//DO NOT HAVE ACCESS TO PACKAGE PRIVATE 
	//VARIABLES AND METHODS
	
	public HardCandy() {
		super("hard candy"); 
	}
}
