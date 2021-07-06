package com.example.abstraction;

public abstract class Car {
	
	int cost;
	boolean isDriving = false;
	
	//You can use constructors to enforce class constaints
	public Car(int cost) {
		this.cost = cost;
	}
	
	public void start() {
		System.out.println("Car has started");
	}
	
	public abstract void drive();
	
}
