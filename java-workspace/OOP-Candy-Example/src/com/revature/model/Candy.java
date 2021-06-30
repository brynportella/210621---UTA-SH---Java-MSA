package com.revature.model;

/*
 * Properly Encapsulated
 * 
 * -- AS private AS possible
 */

public class Candy {
	//package private 
	//instance variable
	//state of Candy objects 
	String type; 
	//protected would allow for any subclass to have direct access 
	
	//No-arg constructor
	public Candy() {}
	
	//Parameterized constructor
	public Candy(String type) {
		super(); //here implicitly
		this.type = type; 
	}
	
	//Getter, Accessor
	public String getType() {
		return this.type; 
	}
	
	public void setType(String type) {
		this.type = type; 
	}
	
	/*
	 * 1. Same name as inherited method
	 * 2. Same set of parameters 
	 * 3. Compatible return type 
	 * 4. As visible or more visible than the inherited method.
	 */
	//To override toString
	public String toString() {
		return "Candy [type= "+this.type+"]"; 
		
	}
	
	public static void addCandy(Candy ... candies) {
		//for() {
		//	print out each candy
		//}
		for(int i = 0; i< candies.length; i++) {
			System.out.println(candies[i]);
		}
	}
	
}
