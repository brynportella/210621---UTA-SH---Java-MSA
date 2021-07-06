package com.example.ops;

public class ControlFlow {
	public void ifElseIfElseExample(int a) {
		if (a < 0) {
			System.out.println("The number is negative");
		} else if (a > 0) {
			System.out.println("The number is positive");
		} else {
			System.out.println("The number is zero");
		}
	}
	
	public void switchStatement(String season) {
		switch(season) {
			//Every one of these case statements can be thought of as individual
			//else if in a if-statement
			case "Summer":
				System.out.println("Lets go to the pool");
				break;
			case "Fall":
				System.out.println("Trick-or-treat");
				break;
			case "Winter":
				System.out.println("It is snowing");
				break;
			case "Spring":
				System.out.println("It is raining");
				break;
			default:
				System.out.println("Season is not recognized");
		}
	}
	
	public void ternary(int x) {
		String s = x>3 ? "x is greater than three" : "x is not greater than three";
		System.out.println(s);
	}
	
	
	
	public void forLoopExample() {
		//When using a for loop, we use three things
		// Looping variable
		// Boolean condition
		// Increment
		for(int i=0; i<10; i++) {
			System.out.println(i);
		}
	}
	
	public void whileLoopExample() {
		int i = 0;
		while(i < 10) {
			System.out.println("While loop: " + i);
			i++;
		}
	}
	
	public void doWhileLoopExample(int x) {
		do {
			System.out.println("Do-while: " + x);
			x++;
		} while(x<10);
	}
	
	public void printEvens() {
		for(int i = 1; i<=100; i++) {
			if(i % 2 == 1) {
				//Continue is used to skip to the next iteration
				continue;
			}
			System.out.println(i);
		}
	}
	
	private boolean inc(int i) {
		return i>0 ? true : false;
	}
	
	public void shortCircuit() {
		int i = 0;
		boolean bool1 = true;
		boolean bool2 = false;
		boolean bool3 = false;
		
		bool3 = (bool2 & inc(i++));
		bool3 = (bool2 && inc(i++));
		bool3 = (bool1 | inc(i++));
		bool3 = (bool1 || inc(i++));
		System.out.println(i);
	}
	
	public void preVsPostFix() {
		int x = 5;
		//prefix
		int y = ++x;
		System.out.println(y + " " + x);
		
		//postfix
		int z = x++;
		System.out.println(z + " " + x);
	}
}
