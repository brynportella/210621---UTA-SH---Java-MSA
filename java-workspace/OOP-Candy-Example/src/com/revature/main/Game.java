package com.revature.main;

import java.util.Arrays;
import java.util.Scanner;

import com.revature.model.Candy;
import com.revature.model.Chocolate;

public class Game {
	static Scanner scan = new Scanner(System.in); 
	
	public static void main(String[] args) {
		System.out.println("We are creating candies. How many candies do you want?");
		int numberOfCandies = scan.nextInt(); 
		Candy[] candies = new Candy[numberOfCandies]; 
		//Candy helperCandy = new Candy(); 
		
		for (int i = 0; i < candies.length; i++) {
			int randomNumber = (int)Math.ceil(Math.random()* 2);
			Candy currentCandy;
			if(randomNumber > 1)
				currentCandy = new Chocolate();
			else
				currentCandy = new HardCandy(); 
			candies[i] = currentCandy; 
			Candy.addCandy(currentCandy);
		}
		
		System.out.println(Arrays.toString(candies));
		Candy.addCandy(candies);
		Candy.addCandy();
		//Varargs methods can be invoked with any number
		//of arguments of the specific type
		//helperCandy.addCandy(helperCandy, new Candy(), new Candy());
		
	}

}
