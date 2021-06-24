
public class QuestionEight {
	public static void main(String[] args) {
		int x = 10; 
		if ( x % 2 == 0 ) { 
		    System.out.println("A");
		    //NEED AN IF 
		}else if (x % 5 == 0) {
		    	System.out.println("B"); 
		}
		
		//ONLY ONE of the above blocks can run^^^^^^
		
		
		//IF we want to test even and then test divisible by 5:
		if ( x % 2 == 0 ) { 
		    System.out.println("A");
		    if (x % 5 == 0) {
			    System.out.println("B"); 
			}
		}  
		
		
		//If we want to test when both are true 
		
		if(x % 2 == 0 && x % 5 == 0 ) {
			System.out.println("A\nB");
		}
		
		//If we want to test them separately 
		if ( x % 2 == 0 ) { 
		    System.out.println("A");
		}
		if (x % 5 == 0) {
		    System.out.println("B"); 
		}
		
		
	}
}
