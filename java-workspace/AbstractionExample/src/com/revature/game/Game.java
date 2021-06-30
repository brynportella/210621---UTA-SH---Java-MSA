package com.revature.game;

import java.util.Scanner;

import com.revature.model.Animal;
import com.revature.model.Bunny;
import com.revature.model.Shark;
import com.revature.model.Swimmer;

public class Game {
	private static Scanner scan = new Scanner(System.in); 
	public static void main(String[] args) {
		System.out.println("What animal do you want to be?");
		String input = scan.nextLine(); 
		Animal animal; 
		switch(input) {
		case "shark":
			animal = new Shark();
			break;
		case "bunny":
			animal = new Bunny(); 
			break; 
		default:
			//Abstract classes can't be directly instantiated.
			//animal = new Animal(); 
			animal = null; 
		}
		animal.eat(); 
		Shark sharky = new Shark(); 
		sharky.swim(); //calling instance methods (NOT static methods) 
		double leagues = Swimmer.convertMetersToLeagues(3.0); 
	}
}
