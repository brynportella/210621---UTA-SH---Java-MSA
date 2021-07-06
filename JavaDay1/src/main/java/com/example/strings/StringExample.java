package com.example.strings;

public class StringExample {
	
	public static void main(String[] args) {
		
		//Declare using the String literal "hi", first time it will be stored in the string pool
		String str1 = "hi";
		
		//Declare the String literal "hi" again, and it will point at the first reference of hi in the string pool
		String str2 = "hi";
		
		//To create an actual new string object in the heap, we can use the new keyword
		String str3 = new String("hi");
		
		String str4 = "hi";
		
		//With strings, the == will check to see if the objects are the same in memory
		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		
		System.out.println("reasign str4 to the object reference of str3");
		str4 = str3;
		
		System.out.println(str3 == str4);
		
		//String implements its own version of .equals()
		//This will check to see if the content is the same
		System.out.println(str1.equals(str3));
		
		//How can we concatenate strings
		String str5 = "Hello";
		
		str5 = str5.concat(" World");
		System.out.println(str5);
		
		str5 += " Whats up?";
		System.out.println(str5);
		
		//String methods
		//Substring
		String str6 = "Hello world, hows it doing?";
		
		str6 = str6.substring(0,5);
		System.out.println(str6);
		
		//replaceAll
		String test = "Here is my string. Isnt it cool?";
		
		test = test.replace(" ", "-");
		System.out.println(test);
		
		//charAt
		String orginal = "orginal string";
		System.out.println(orginal.charAt(1));
		
		//lowercase and uppercase
		String crazy = "CrAzY cAsE";
		
		String lower = crazy.toLowerCase();
		String upper = crazy.toUpperCase();
		
		System.out.println(lower);
		System.out.println(upper);
		
		//endswith
		String ends = "run";
		boolean endsWithING = ends.endsWith("ING".toLowerCase());
		System.out.println(endsWithING);
	}
	
}
