package flowcontrol;

public class BreakAndContinue {
	public static void main(String[] args) {
		/*
		 * The 'Break' and 'Continue' keyword allow you to have more fine-tuned control
		 * over the execution of your program.
		 * 
		 * The 'break' keyword is used to halt the execution of the closest loop or
		 * switch statement.
		 * 
		 * The 'continue' keyword is used to halt the current execution cycle, and
		 * restart the loop at the next cycle...
		 * 
		 * A Label is an arbitrarily named identifier that you can apply to a loop
		 * (technically to switch statements as well, but this is not used often). This
		 * identifier can then be applied to the break or continue statement to control
		 * which loop the break/continue apply towards
		 */
		alpha: for (char letter = 'A'; letter <= 'D'; letter++) {
			numeric: for (int num = 0; num <= 4; num++) {
				if (num == 2) {
					break numeric;
				}
				System.out.println(letter + ":" + num);
			}
		}

		arbitrary: for (char letter = 'A'; letter <= 'D'; letter++) {
			doesntMatter: for (int num = 0; num <= 4; num++) {
				if (num == 2) {
					break arbitrary;
				}
				System.out.println(letter + ":" + num);
			}
		}

		scoobydoo: for (char letter = 'A'; letter <= 'D'; letter++) {
			pineapple: for (int num = 0; num <= 4; num++) {
				if (num == 2) {
					continue pineapple;
				}
				System.out.println(letter + ":" + num);
			}
		}

		int count = 0;
		loop: while (count < 5) {
			char let = 'A';
			switch (let) {
			case 'A':
				System.out.println("Not the best example...");
				continue loop;
			}
		}
		
		int value = 0;
		for (char c = 'A'; c <= 'Z'; c++) {
			System.out.println(c + ":" + value);
			value++;
		}
	}
}
