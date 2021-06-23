
public class DevisionOperatorInJava {
	public static void main(String[] args) {
		int x = 9/4; //truncates i.e. cuts off any remainder
		System.out.println(x);//prints 2
		//x = 6.0/3; won't work - result is a double
		double result = 6/7;//performs integer devision and then upcasts
		
		System.out.println(result);
		System.out.println();
		
	}
}
