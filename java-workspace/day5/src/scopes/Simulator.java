// Code comments
package scopes;

import example.Data;

public class Simulator {
	public static String instanceScope = "Instance Scope String!";
	
	public static void methodOne() {
		String methodScope = "NOT ACTUALLY INSTANCE SCOPE!";
		System.out.println(methodScope);
		System.out.println(instanceScope);
	}
	
	public static void methodTwo () {
		System.out.println(instanceScope);
	}
	
	public static void main(String[] args) {
//		Data d = new Data();
//		methodOne();
//		methodTwo();
		
		/*
		 * When accessing static data, we can call
		 * that data from the Class itself (i.e. we
		 * do NOT require the creation/instantiation of
		 * an object from that class)
		 */
		System.out.println(Information.value);
		Information.value = "New Data";
		System.out.println(Information.value);
		
		/*
		 * When creating objects from a class, the
		 * static data is shared across all objects
		 * of that class.
		 * 
		 * However, instance variables (non-static fields)
		 * are NOT shared across the objects. I.e. objects
		 * can have their own instance variable values!
		 */
		Information info_1 = new Information();
		System.out.println("info_1: " + info_1.nonStatic);
		info_1.nonStatic = "Info 1 Changed Value";
		info_1.id = 99;
		System.out.println("info_1: " + info_1.nonStatic);
		System.out.println("info_1: " + info_1.id); // 99
		
		Information info_2 = new Information();
		System.out.println("info_2: " + info_2.nonStatic);
		info_2.id = 500;
		System.out.println("info_2: " + info_2.id); // 500
		
		System.out.println("info_1: " + info_1.value);
		info_2.value = "Changed!";
		System.out.println("info_1: " + info_1.value);
		System.out.println("info_2: " + info_2.value);
	}

}
