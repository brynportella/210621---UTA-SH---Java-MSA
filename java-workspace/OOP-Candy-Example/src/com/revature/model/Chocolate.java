package com.revature.model;

public class Chocolate extends Candy {
	
	public Chocolate() {
		super("chocolate");//must be the first line of the constructor
	}
	
	public void displayChocolateExcitement() {
		System.out.println("YAAYYYYAYAYAY! Chocolate"
				+ "Candy type: "+ type);
	}
	
	public String displayChocolateExcitement(String message) {
		System.out.println("YAAYYYYAYAYAY! Chocolate"
				+ "Candy type: "+ type+" "+message);
		return null;
	}

	public void displayChocolateExcitement(String message, String otherMessage) {
		System.out.println("YAAYYYYAYAYAY! Chocolate"
				+ "Candy type: "+ type+" "+message);
	}
	@Override
	public String toString() {
		return "Chocolate [type=" + type + "]";
	}
	
}
