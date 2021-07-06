package com.example.wrappers;

public class Wrappers {
	
	public static void main(String[] args) {
		
		//There are multiple ways we can create a wrapper object
		Integer x1 = 5;
		Integer y1 = new Integer(8);
		Integer parsedInt = Integer.parseInt("6");
		
		int x2 = 5;
		int y2 = 7;
		
		autoboxing(x1, y2);
		unboxing(y2, y1);
		
	}
	
	public static void autoboxing(Integer x, Integer y) {
		System.out.println("We are in autoboxing method!");
		System.out.println(x+y);
	}
	
	public static void unboxing(int x, int y) {
		System.out.println("We are in unboxing method!");
		System.out.println(x+y);
	}
	
}
