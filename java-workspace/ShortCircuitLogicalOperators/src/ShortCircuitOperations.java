
public class ShortCircuitOperations {
	public static void main(String[] args) {
		int x = 0; 
		//&&, & - AND
		if(x != 1 && x!=0 ) {
			System.out.println("Not 0 or 1.");
		}
		if(x != 1 & x!=0 ) {
			System.out.println("Not 0 or 1.");
		}
		
		//||, | - OR
		if(x == 1 || x==0 ) {//Check only needed expressions
			System.out.println("Is  0 or 1.");
		}
		if(x == 1 | x==0) {//Check both expressions
			System.out.println("Is 0 or 1.");
		}
	}

}
