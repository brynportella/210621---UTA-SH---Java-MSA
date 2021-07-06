package com.example.abstraction;

public class SportsCar extends Car implements SportsUpgrade{
	
	int cost;
	String name;
	
	public SportsCar(int cost, String name) {
		super(cost);
		this.cost = cost;
		this.name = name;
	}

	@Override
	public String getMods() {
		return SportsCar.sportsMods + " , Tire Upgrades, Window Tint";
	}

	@Override
	public void rev() {
		System.out.println("The sports car revs its engine");
		
	}

	@Override
	public void burnout() {
		System.out.println("The sports car does a burnout");
		
	}
	
	@Override
	public void drive() {
		this.isDriving = true;
		System.out.println("The sports car drives fast");
	}

}
