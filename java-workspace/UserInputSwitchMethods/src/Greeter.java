import java.util.Scanner;

public class Greeter {
	
	public void greet(String input) {
		System.out.println("Hello "+input);
	}
	
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in); 
		System.out.println("What is your name?");
		String name = myScanner.next(); 
		
		//How to create a new Greeter object-- 
		Greeter greeter = new Greeter(); 
		//How do we call/invoke/ run greet on our greeter 
		//to say hello to our user 
		greeter.greet(name);
		myScanner.nextLine(); 
		System.out.println("What is your favorite season?");
		String season = myScanner.nextLine(); 
		
		switch(season.toLowerCase()) {
		case "summer":
			System.out.println("YAY- summer on the beach!");
			break;
		case "spring":
			System.out.println("Yay!! flowers!!");
			break;
		case "winter":
			System.out.println("Yay!! snow");
			break; 
		case "fall":
		case "autumn":
			System.out.println("Yay!! leaves and pumpkins");	
			break; 
		default:
			System.out.println("That isn't a season that I know!");
		}
		

		
	}
}
