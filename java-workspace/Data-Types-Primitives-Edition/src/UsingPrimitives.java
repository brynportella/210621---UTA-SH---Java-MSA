
public class UsingPrimitives {
	public static void main(String[] args) {
		//double 
		double myDecimalNumber = 34.5;
		//can implicitly convert from ints to doubles
		//Up-casting- converting between two datatypes going up in size
		myDecimalNumber = 9; //ints are 32 bits and doubles are 64 
		
		//upcasting again 
		long myNumberBIG = -23_000_000; //any whole number is first understood as an int
		
		myNumberBIG = 90L; //90 lowercase L
		
		//DOWN- CASTING
		//Must be done explicitly 
		int basicWholeNumber = (int) myNumberBIG; 
	}
}
