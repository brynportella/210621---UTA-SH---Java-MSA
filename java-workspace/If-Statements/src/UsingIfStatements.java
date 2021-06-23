
public class UsingIfStatements {
	public static void main(String[] args) {
		
		
		
		/*
		 * if (condition--HAS TO BE BOOLEAN){
		 *    stuff you want to happen when true 
		 *  }else{
		 *    stuff if not true
		 *   }
		 */
		//== is our comparison operator 
		//HAS to be used with compatible types
		
		int x = 6; // as soon as we reach a true condition that's the only one that will run
		if( x % 2 == 0) {
			System.out.println("A:Even");
		}else if(x % 3== 0)
			System.out.println("B:Divisible by 3.");
		else 
			System.out.println("C:Odd");
		
		System.out.println("D");
	
		boolean flag = true; 
		if(flag) {//DONT say == true 
			System.out.println("YAY - true");
		}
		
		flag = false;
		
		//BAD!!!!!!!!!!!!
		if (flag = true) {
			System.out.println("UH OH ");
		}else {
			System.out.println("OH NO!");
		}
		
	}
}
