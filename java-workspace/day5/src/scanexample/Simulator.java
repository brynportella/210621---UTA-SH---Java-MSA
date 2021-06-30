package scanexample;

import java.util.Scanner;

public class Simulator {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Give me a number");
		int value = scan.nextInt();
		System.out.println("You entered: " + value);
		System.out.println("Give me a decimal number:");
		double dbl = scan.nextDouble();
		double calculation = dbl * 3.14;
		System.out.println("The calculated value: " + calculation);
	}
	
	public static double CtoF(double degreesC) {
		return degreesC * 9; // perform calcuation
	}
	
	
}
