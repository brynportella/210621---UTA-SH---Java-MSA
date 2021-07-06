package com.example.abstraction;

public class CarDriver {
	
	public static void main(String[] args) {
		SportsCar sport = new SportsCar(20_000, "BMW");
		
		System.out.println(sport.isDriving);
		
		sport.drive();
		
		System.out.println(sport.isDriving);
		
		System.out.println(sport.cost);
		
		System.out.println(sport.name);
		
		sport.showOff();
		
		System.out.println(sport.getMods());
		
		sport.rev();
		
		sport.burnout();
	}
	
}
