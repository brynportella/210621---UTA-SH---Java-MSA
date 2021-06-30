
public class UsingUnaryOperators {
	public static void main(String[] args) {
		
		int i = 0; 
		//i ++; // ++i; or i+= 1;  
		 
		System.out.println(i++);// adds after the current instruction
		System.out.println(i);//prints 1
		//i is one 
		System.out.println(++i);//adds, assigns, then prints 2 
		
		System.out.println(i = i+1);//adds, assigns and then prints 3
		
		System.out.println(i+=1);//adds,assigns, and then prints 4
		
		System.out.println(i+1 );//adds, but doesn't assign 
		
		System.out.println(i);//prints 4 because we did not change i in the last statement
	}
}
