package com.example.lambdas;

import java.util.ArrayList;

public class LambdaDriver {
	
	public static void main(String[] args) {
		
		traditional();
		
		lambdaWay("We are printing inside of a lambda");
		
		System.out.println(add(4,4));
		
		System.out.println(sub(7,4));
		
		ArrayList<String> names = new ArrayList<String>();
		
		names.add("Ethan");
		names.add("Ahmed");
		names.add("AJ");
		names.add("Alex");
		
		names.forEach((String name) -> {
			System.out.println(name);
		});
		
	}
	
	public static void traditional() {
		PrintInterface p = new PrintInterface() {
			@Override
			public void printSomething() {
				System.out.println("Printing something inside of traditional");
			}
		};
		p.printSomething();
	}
	
	public static void lambdaWay(String s) {
		PrintInterface p = () -> {System.out.println(s);};
		p.printSomething();
	}
	
	public static int add (int x, int y) {
		Calculate calc = () -> x+y;
		return calc.calculate();
	}
	
	public static int sub (int x, int y) {
		Calculate calc = () -> x-y;
		return calc.calculate();
	}
	
}
