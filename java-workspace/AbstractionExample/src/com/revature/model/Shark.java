package com.revature.model;


//implements as many interfaces as it wants 
//must override all abstract methods
public class Shark extends Animal implements Swimmer, FastMover{
	
	
	public Shark() {
		int[] startingPoint = {0, -100}; 
		this.setPosition(startingPoint);
		this.setName("Shark");
	}
	
	public void eat(String food) {
		System.out.println("ARRGHH I am eating "+food+". I am the master of the sea.");
	}

	@Override
	public void eat() {
		System.out.println("Yum minoes are delicious!!");
	}

	@Override
	public void swim() {
		System.out.println("I am mighty and I swim!!");
		
	}
	
	
	
	
}
