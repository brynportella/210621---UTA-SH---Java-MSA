package com.revature.model;

public class Bunny extends Animal {
	
	public Bunny() {
		//super(1,1, "Bunny"); 
		
		//Set the position to 1,1
		int[] startingPosition = {1,1}; 
		this.setPosition(startingPosition); 
		//Set the name to Bunny
		this.setName("Bunny");
	}

	@Override
	public void eat(String food) {
		System.out.println("Yummy veggies!! I love "+food);
		
	}

	@Override
	public void eat() {
		System.out.println("Yummy veggies I love carrots");
	}

}
