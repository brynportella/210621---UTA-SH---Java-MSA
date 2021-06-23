
public class PitfallsOfChar {
	public static void main(String[] args) {
		char myCharacter = 89; //Chars at int convertible
		/*
		 * A char holds a single character.
		 * 
		 * But that character is stored in ASCII
		 * so we can also assign numbers to char. 
		 * 
		 */
		System.out.println(myCharacter);//Prints Y 
		myCharacter = 'p'; 
	}
}
