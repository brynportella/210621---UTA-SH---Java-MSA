package varargs;

public class Simulator {
	public static void main(String[] args) {
		/*
		 * When you invoke a method, the information
		 * provided to the method is the argument. A
		 * VarArgs (variable arguments list) allows
		 * you to pass an arbitrary number of arguments
		 * separated by commas, to a method, and Java
		 * will automatically convert it to an array
		 * for you!
		 */
		int[] nums = {12,3,4,78,43};
		printAll(88, nums);
		printAll(13,56,787,23);
		printAll(99);
		printAll(1,2,3,4,5,6,7,8,9,0);
		printAll(0);
	}
	
	/*
	 * A Variable arguments list must be the last parameter
	 * of the parameter list when declaring a method. This
	 * means that you can only have one varargs within an
	 * method declaration.
	 */
	public static void printAll(int a, int... values) {
		for (int i = 0; i < values.length; i++) {
			System.out.println(values[i]);
		}
	}
	
	public static void printAll(int a, int b, int c) {
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}
