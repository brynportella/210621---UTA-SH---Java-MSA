package com.example.fileio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScannerIO {
	
	private static ObjectIO<User> io = new ObjectIO<User>();
	private static final String file = "users.txt";
	
	public static void main(String[] args) {
		//To get user input you can use the scanner class
		Scanner scan = new Scanner(System.in);
		
		ArrayList<User> users = null;
		
		try {
			users = io.readObjects(file);
		} catch (FileNotFoundException e) {
			System.out.println("The users file does not exist yet");
			users = new ArrayList<User>();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.print("Please enter your first name: ");
		String first = scan.nextLine();
		System.out.print("Please enter your last name: ");
		String last = scan.nextLine();
		System.out.print("Please enter a password: ");
		String pass = scan.nextLine();
		
		User u = new User(first, last, pass);
		
		users.add(u);
		
		io.writeObjects(file, users);
		
		System.out.println("Your username is: " + u.getUsername());
		
		System.out.println("Other registered users include: ");
		try {
			users = io.readObjects(file);
		} catch( ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		for(int i=0; i<users.size(); i++) {
			System.out.println(users.get(i).getUsername());
		}
		
		scan.close();
		
	}
	
}
