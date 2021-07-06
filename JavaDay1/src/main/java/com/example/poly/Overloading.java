package com.example.poly;

public class Overloading {
	
	public static void main(String[] args) {
		overloadMe();
		overloadMe("String");
		overloadMe("String", 10);
		overloadMe(10, "String");
	}
	
	public static void overloadMe() {
		System.out.println("No-arg method");
	}
	
	public static void overloadMe(String s) {
		System.out.println("Method with on arg");
	}
	
	public static void overloadMe(String s, int i) {
		System.out.println("Method with string, then int");
	}
	
	public static void overloadMe(int i, String s) {
		System.out.println("Method with int, then string");
	}
	
}
