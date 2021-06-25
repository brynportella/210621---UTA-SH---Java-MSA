package scopes;

public class Information {
	static String value = "This value is Static on the Information Class";
	
	String nonStatic = "This requires an object";
	int id = 10;
	
	static int combine = 20;
	
	String word; // by default this will be null
	double dbl; // by default will be 0 (0.0)
	
	public void exampleMethod() {
		String value = "Within my method";
		if (true) {
			/*
			 * Variable names cannot be duplicated within
			 * a method, although they can share
			 * a name with a variable at the instance/class
			 * level. This is because the 'this' keyword
			 * can distinguish between these variables
			 */
//			String value = "Inside if-statement";
		}
	}
	
	/*
	 * Custom constructors are used to set the initial state
	 * of an object...
	 */
	public Information(String nonStatic, int id, String word, double dbl) {
		this.nonStatic = nonStatic;
		this.id = id;
		this.word = word;
		this.dbl = dbl;
	}
	
	/*
	 * This is what the "default, no-args" constructor
	 * looks like...
	 * 
	 * If you do not create another constructor, java
	 * will provide you with one that looks similar in
	 * structure to the one below
	 */
	public Information() {
		
	}
	
	public void addValues() {
		int sum = id + combine;
	}
}
