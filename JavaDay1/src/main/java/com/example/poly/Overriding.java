package com.example.poly;

public class Overriding extends Parent{
	
	protected int x;
	protected String name;
	
	@Override
	protected String getObj() {
		return "yes";
	}
	
	@Override
	public void changeAccess() {
		System.out.println("Yes we can");
	}
	
	public static String hiding() {
		return "hidden";
	}
	
	public Overriding() {
		name = "child";
	}
	
}
