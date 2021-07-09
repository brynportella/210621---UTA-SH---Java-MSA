package com.example.singleton;

public class SingletonDriver {

	public static void main(String[] args) {

		LazySingleton ex1_1 = LazySingleton.getInstance();
		LazySingleton ex1_2 = LazySingleton.getInstance();
		
		System.out.println("ex1_1 == ex1_2? " + (ex1_1 == ex1_2));
		
		ex1_1.setValue(10);
		System.out.println("ex1_1.getValue() = " + ex1_1.getValue());
		System.out.println("ex1_2.getValue() = " + ex1_2.getValue());
		
		EagerSingleton ex2_1 = EagerSingleton.getInstance();
		EagerSingleton ex2_2 = EagerSingleton.getInstance();
		
		System.out.println("ex2_1 == ex2_2? " + (ex2_1 == ex2_2));
		
		ex2_2.setValue(20);
		System.out.println("ex2_1.getValue() = " + ex2_1.getValue());
		System.out.println("ex2_2.getValue() = " + ex2_2.getValue());
	}

}
