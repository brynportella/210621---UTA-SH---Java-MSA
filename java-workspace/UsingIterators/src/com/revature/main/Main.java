package com.revature.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List; 

public class Main {
	public static void main(String[] args) {
		//Create a collection of String objects 
		//myCollection
		//using Collection as the reference type 
		//HashSet as the implementing class
		Collection<String> myCollection = new HashSet<String>();
		//datatype variable = new constructorInvocation(); 
		myCollection.add("Bryn");
		myCollection.add("Naresh");
		myCollection.add("Tristan");
		
		Iterator<String> iter = myCollection.iterator(); 
		//iterator moves through the collection item by item 
		//as long as there is an item in the collection hasNext() will be true
		while(iter.hasNext()) {
			String currentElement = iter.next(); //Moves the iterator forward 
			//and returns the item that it was previously pointing toward
			System.out.println(currentElement);
		}
		
		
		List<Integer> numbers = new ArrayList<Integer>(); 
		numbers.add(1); 
		numbers.add(2); 
	}
}
