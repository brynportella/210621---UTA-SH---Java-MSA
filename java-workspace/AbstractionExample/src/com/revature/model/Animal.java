package com.revature.model;

import java.util.Arrays;

public abstract class Animal {
	private int[] position = {0,0};
	private String name; 
	
	Animal(){}
	Animal(int x, int y, String name){
		this.position[0] = x;
		this.position[1] =y; 
		this.name = name; 
	}
	
	//method without a body is an abstract method
	// we need the abstract keyword
	public abstract void eat(String food); 
	
	public abstract void eat(); 
	
	//Any method that isn't abstract is considered concrete
	public void move(int x, int y) {
		System.out.println("Moving from "+ position[0]+","+position[1]);
		position[0] = x;
		position[1] = y;
		System.out.println("To "+ position[0]+","+position[1]);
	}

	public int[] getPosition() {
		return position;
	}

	public void setPosition(int[] position) {
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Animal [position=" + Arrays.toString(position) + ", name=" + name + "]";
	}
	
	
	
}
