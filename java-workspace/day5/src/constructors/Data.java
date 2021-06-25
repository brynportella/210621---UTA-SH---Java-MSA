package constructors;

public class Data {
	public String name;
	public int id;
	public double weight;
	public int age;
	public boolean hungry;
	
	/*
	 * Constructors are special methods* (technically
	 * they are subroutines, but you don't need to know that)
	 * that are used to initialize the values of fields
	 * on objects when instantiating them
	 */
	public Data(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	/*
	 * Method (or constructor) overloading allows you
	 * to define multiple methods (or constructors) with
	 * the same name, but different parameter lists, which
	 * can be used to distinguish between which constructor
	 * to use
	 */
	public Data() {
		this("No Name Provided", 0);
	}

	public Data(String name, int id, double weight, int age) {
		this.name = name;
		this.id = id;
		this.weight = weight;
		this.age = age;
	}
	
	public Data(int id, String name, double weight, int age) {
		this.name = name;
		this.id = id;
		this.weight = weight;
		this.age = age;
	}

}
