package flowcontrol;

/*
 * Flow Control statements allow you to dictate
 * what code you want to execute based on the
 * structure of the flow control statement. Most
 * of these are powered by some type of boolean
 * logic.
 */
public class SwithStatements {
	public static void main(String[] args) {
		/*
		 * Switch statement syntax: switch (variable_we_check) { case
		 * <potential_value_of_variable>: }
		 */

		int number = 4;
		
		/*
		 * Fall-through logic
		 * Once a case is found to match out switch
		 * statement variable, we will continue to
		 * execute code within the switch statement
		 * (even code in other case's that do not match
		 * below the currently executing code), until
		 * either the 'break' keyword is reached, or
		 * the end of the switch statement
		 */
		switch (number) {
		default:
			System.out.println("No matching case statements found");
		case 0:
			System.out.println("The value was 0");
			break;
		case 1:
			System.out.println("The value was 1");
			break;
		}
		
		
		if (number == 0) {
			
		} else if (number == 1) {
			
		} else {
			
		}
	}
}
