package com.example.arrays;

public class ArraysAndVarArgs {
	
	public static void main(String[] args) {
		
		//This is two ways you can create arrays
		//It can go before or after the name of the variable
		int myIntArray[];
		int[] myOtherIntArray;
		
		//This is how we can set the size with new array
		myIntArray = new int[5];
		
		//We can also "preload" data
		myOtherIntArray = new int[] {1,2,3,4,5,6};
		
		ArraysAndVarArgs aav = new ArraysAndVarArgs();
		aav.arrayLoop(myOtherIntArray);
		aav.arraysAsObj();
		aav.twoDArray();
		aav.display("This is displaying a variable number of arguments", 1,4,3,2,5,1,3,65,3,6,2);
		aav.display("Passing in an array", myOtherIntArray);
	}
	
	public void arrayLoop(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			//We access individual elements with the index inside of square brackets
			System.out.println(arr[i]);
		}
	}
	
	public void arraysAsObj() {
		String[] names = new String[3];
		//Anoter way we can set elements inside of an array
		names[0] = "Ahmed";
		names[1] = "Daniel";
		names[2] = "Kevin";
		//Enhanced forloop
		for(String name: names) {
			System.out.println(name);
		}
	}
	
	public void twoDArray() {
		int[][] the2dArray = new int[3][3];
		int[][] my2dArray = {{1,2,3}, {4,5,6}, {7,8,9}};
		
		int value = my2dArray[1][2];
		System.out.println(value);
		System.out.println(my2dArray[1]);
		
		for(int i=0; i<my2dArray.length; i++) {
			for(int j=0; j<my2dArray[i].length; j++) {
				System.out.println("Value at position " + i + ", " + j + " :" + my2dArray[i][j]);
			}
		}
	}
	
	//Varargs
	public void display(String strValue, int... nums) {
		System.out.println(strValue);
		for(int val: nums) {
			System.out.println(val);
		}
	}
	
}
