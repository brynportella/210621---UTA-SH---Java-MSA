package com.example.mutablestings;

public class StringBuilderAndBuffer {
	
	public static void main(String[] args) {
		
		//String builder object, is a string object that is mutable, but not thread safe
		StringBuilder stringBuilder = new StringBuilder("Hello from String builder");
		stringBuilder.append(" we are adding to the string builder");
		System.out.println(stringBuilder);
		String str1 = stringBuilder.toString();
		System.out.println(str1);
		
		//StringBuffer is a string object that is mutable and is thread safe, however with this is typically no
		//longer used
		StringBuffer stringBuffer = new StringBuffer("Hello from String Buffer");
		stringBuffer.append(" adding with append");
		System.out.println(stringBuffer);
		
	}
	
}
