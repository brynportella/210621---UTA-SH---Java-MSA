package com.revature.model;

public class Question3 {
	private int someVar; //default value of numbers 0 
	
	public int getSomeVar() {
		return someVar; 
	}
	
	//object.setSomeVar(4); 
	public void setSomeVar(int flowerPower) {
		
		flowerPower = 10; 
		
		this.someVar = flowerPower; 
		System.out.println();
	}
	
	public static void main(String[] args) {
		Question3 object = new Question3(); 
		
		System.out.println(object.someVar); // What is the output console here?
		
		int value = 4; 
		object.setSomeVar(value);
		
		System.out.println(value);//What is the output to the console here? 4
		
		System.out.println(object.someVar);//What output to the console here? 10
	}
}
