import java.util.Arrays; 

public class UsingArrays {
	public static void main(String[] args) {
		//Prepopulated array 
		//it's still an object 
		int myWholeNumbers [] = {1,2,3,4,5};//int[] is the same datatype
		
		//Access last element in the array 
		System.out.println(myWholeNumbers[myWholeNumbers.length - 1]);
		
		System.out.println(myWholeNumbers);//Prints [I@15db9742
		
		System.out.println(Arrays.toString(myWholeNumbers));//prints [1, 2, 3, 4, 5]
		
		int[] emptyNumbers = new int[5]; 
		
		//Arrays are indexed at 0 
		//To access elements you use the index 
		// this is called indexing into the array 
		
		System.out.println(myWholeNumbers[0]);// Prints the first element
		
		System.out.println(emptyNumbers[0]);// Gives us 0 
		
		boolean[] emptyBooleans = new boolean[5]; 
		System.out.println(emptyBooleans[0]);
		
		String[] emptyStringObjectArray = new String[6]; 
		System.out.println(emptyStringObjectArray[0]);
		
		//String[] arrayOfStrings = new String[]; < HAVE TO CHOOSE SIZE
		
		System.out.println(emptyBooleans.length);
		
		
	}
}
