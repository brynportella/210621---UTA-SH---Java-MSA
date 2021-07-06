package com.example.encap;

public class Person {
	
	private int age;
	private String firstName;
	private String lastName;
	
	public Person() {
		this.age = 0;
		this.firstName = "first";
		this.lastName = "last";
	}
	
	public Person(int age, String first, String last) {
		this.age = age;
		this.firstName = first;
		this.lastName = last;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String first) {
		this.firstName = first;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String last) {
		this.lastName = last;
	}
	
}
