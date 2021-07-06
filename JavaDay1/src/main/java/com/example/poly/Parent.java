package com.example.poly;

public class Parent {
	
	protected int x;
	protected String name;
	protected boolean inherited = true;
	
	protected Object getObj() {
		System.out.println("can we change the return type?");
		return new Object();
	}
	
	protected void changeAccess() {
		System.out.println("can we change the access?");
	}
	
	public static String hiding() {
		return "hide me!";
	}
	
	public Parent() {
		x=5;
		name="parent";
	}
	
}
