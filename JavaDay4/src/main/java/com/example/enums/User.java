package com.example.enums;

import java.util.ArrayList;

enum Type {
	REGULAR,
	SUPER,
	PREMIUM
}

public class User {
	
	private String firstName;
	private String lastName;
	private String userName;
	private Type userType;
	
	public static void main(String[] args) {
		User u1 = new User("Rick", "Sanchez", "ilovemorty", Type.PREMIUM);
		User u2 = new User("Morty", "Smith", "ihaterick", Type.REGULAR);
		User u3 = new User("Summer", "Smith", "sssumertime", Type.REGULAR);
		User u4 = new User("Bird", "Person", "birdwars", Type.SUPER);
		User u5 = new User("Beth", "Smith", "bsmith", Type.SUPER);
		
		//.values() method allows us to see a list of the constant values
		for(Type type: Type.values()) {
			System.out.println(type);
			System.out.println(type.ordinal());
		}
		
		ArrayList<User> ulist = new ArrayList<User>();
		
		ulist.add(u1);
		ulist.add(u2);
		ulist.add(u3);
		ulist.add(u4);
		ulist.add(u5);
		
		for(int i=0; i<ulist.size(); i++) {
			switch(ulist.get(i).getUserType()) {
				case REGULAR:
					System.out.println("User: " + ulist.get(i).getUserName() + " is a " + Type.REGULAR + " user");
					break;
				case SUPER:
					System.out.println("User: " + ulist.get(i).getUserName() + " is a " + Type.SUPER + " user");
					break;
				case PREMIUM:
					System.out.println("User: " + ulist.get(i).getUserName() + " is a " + Type.PREMIUM + " user");
					break;
				default:
					System.out.println("We don't know what you are");
			}
		}
		
	}
	
	public User(String firstName, String lastName, String userName, Type userType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.userType = userType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Type getUserType() {
		return userType;
	}

	public void setUserType(Type userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", userType="
				+ userType + "]";
	}
	
}
