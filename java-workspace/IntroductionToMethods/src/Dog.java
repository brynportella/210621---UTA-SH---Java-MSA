
//Blueprint for future dogs 
public class Dog {
	//Every dog has a size 
	//instance variables
	public double size;
	//Every dog has a name
	//instance variable
	public String name; 
	
	//Implicitly we have a constructor 
	//we use constructors to create objects
	//THEY ARE DIFFERENT FROM METHODS
	public Dog() {}//Defining or declaring the constructor
	//creating the constructor 
	
	//behavior of the object
	//an action the object can take 
	//instance method 
	//NOTICE NO STATIC KEYWORD
	public void bark() {
		System.out.println(this.name+" says Woof"); 
	}
	
	public void changeName(String newName) {
		this.name = newName; 
	}
	
	public double doggyAdd(double a, double b) {
		double result = a + b + 8; 
		return result; 
		//Can't have things after the return statement
		//unreachable code
	}
}
