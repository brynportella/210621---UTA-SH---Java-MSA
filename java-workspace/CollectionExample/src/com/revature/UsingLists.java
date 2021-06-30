package com.revature;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UsingLists {
	public static void main(String[] args) {
		List<String> greetings = new ArrayList<String>();
		greetings.add("Hello");//Can add duplicates to our list
		greetings.add("Hello");
		greetings.add("Hi");
		greetings.add("Hey");
		greetings.add("Howdy");
		
		//Anything that IS-A Iterable or an array
		//Enhanced for loop
		for(String itemInList : greetings) {
			System.out.println(itemInList);
		}
		
		for(int i = 0; i < greetings.size(); i++) {
			System.out.println(greetings.get(i));
		}
		
		
		System.out.println("First item in list: "+greetings.get(0));
		
		List<Object> myListOfObjects = new LinkedList<Object>(); 
		
		myListOfObjects.add(new Integer(4));
		myListOfObjects.add(new Double(40.0)); 
		
		for(Object o: myListOfObjects) {
			System.out.println(o);
		}
		
	
	}
}
