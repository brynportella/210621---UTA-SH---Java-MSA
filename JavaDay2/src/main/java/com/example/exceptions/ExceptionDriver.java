package com.example.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionDriver {
	
	public static void main(String[] args) {
		
		try {
			throwManyExceptions(4);
		//Remember, we can have multiple catch blocks, as long as they go from more specific
		//Exceptions to less specific
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFound caught");
		} catch (IOException e) {
			System.out.println("IO caught");
		} catch (Exception e) {
			System.out.println("General exception caught");
		} finally {
			System.out.println("This will run logic no matter what");
		}
		
		Bicycle myBike = new Bicycle();
		
		System.out.println("gear: " + myBike.gear + " speed: " + myBike.speed);
		
		myBike.speedUp(24);
		System.out.println("gear: " + myBike.gear + " speed: " + myBike.speed);
		
		myBike.speedUp(2);
		System.out.println("gear: " + myBike.gear + " speed: " + myBike.speed);
		
		//To handle a compile time exception we HAVE to surround the code that may throw the exception
		// In a try catch
		
		try {
			myBike.slowDown(26);
		}
		catch(NegativeSpeedException e) {
			myBike.speed = 0;
			myBike.gear = 1;
			e.printStackTrace();
		}
		
		//This still prints because we caught and handled the exception
		System.out.println("gear: " + myBike.gear + " speed: " + myBike.speed);
		
		
	}
	
	public static void throwManyExceptions(int i) throws Exception {
		switch(i) {
			case 1: throw new IOException();
			case 2: throw new ClassNotFoundException();
			case 3: throw new FileNotFoundException();
			default: throw new Exception();
		}
	}
	
}
