
public class PlusOperatorInJava {
	public static void main(String[] args) {
		// +
		int result = 8+9; 
		System.out.println("The Result is "+result);
		
		String textValue = "Hello"+ " "+"World"; 
		System.out.println(textValue);
		
		String numberText = ""+6+8;
		System.out.println(numberText);//68
		System.out.println((9+10)+"");//19
		//System.out.println(68 instanceof String );
		System.out.println("The result is "+(numberText instanceof String));
	}
	
}
