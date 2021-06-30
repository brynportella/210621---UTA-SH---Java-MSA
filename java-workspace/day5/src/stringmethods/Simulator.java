package stringmethods;

public class Simulator {
	public static void main(String[] args) {
		String word = "Hello My Name Is Joseph";
		String[] divided = word.split("e");
		for (int i = 0; i < divided.length; i++) {
			System.out.println(divided[i]);
		}
		
		System.out.println(word.charAt(4));
		/*
		 * When provided with two int values, the
		 * substring method will print all of the
		 * characters including the first argument
		 * but exclusing the second
		 */
		System.out.println(word.substring(10, 15));
		
		System.out.println(word.toUpperCase());
		System.out.println(word);
		
		
	}
}
