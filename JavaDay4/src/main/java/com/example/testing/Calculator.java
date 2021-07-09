package com.example.testing;

public class Calculator {
	
	public int add(int x, int y) {
		return x + y;
	}
	
	public int sub(int x, int y) {
		return x - y;
	}
	
	public int divide(int x, int y) throws ArithmeticException{
		return x/y;
	}
	
	public int multiply(int x, int y) {
		return x * y;
	}
	
}
