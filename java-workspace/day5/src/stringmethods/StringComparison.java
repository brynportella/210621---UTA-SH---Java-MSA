package stringmethods;

public class StringComparison {
	public static void main(String[] args) {
		/*
		 * String literals (Strings that are declared
		 * outside of any methods using double quotes)
		 * are placed in the String Pool. A String object
		 * created in any other mean is placed in the normal
		 * heap memory (where other objects exist)
		 */
		String one = "Hello";
		String two = new String("Hello");
		String three = "Hello";
		/*
		 * The double equals (==) compares memory
		 * address locations.
		 */
		System.out.println(one == two); // false
		System.out.println(one.equals(two));	// true
		System.out.println(one.equalsIgnoreCase(two)); // true
		System.out.println(one == two.intern()); // true
		System.out.println(one == three); // true
	}
}
