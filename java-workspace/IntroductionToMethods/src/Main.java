
public class Main {
	public static void main(String[] args) {
						//Creating an object
						// VVVVVV 
		Dog doggy = new Dog(); 
		//^^ Creating the variable 
		
		//Creating an object is instantiating the class 
		//from which you found the blueprint
		//Also referred to as creating an instance 
		// creating an object 
		
		doggy.name = "Daisy"; 
		doggy.size = 45.6; 
		
		Dog otherDog = new Dog(); 
		
		otherDog.name = "Spot"; 
		otherDog.size = 80.0; 
		
		System.out.println(doggy.name);
		System.out.println(otherDog.name);
		
		//INVOKE method on an object 
		//invoke/call/run bark on otherDog 
		otherDog.bark();
		otherDog.changeName("Sparky");
		System.out.println(otherDog.name);
		
		double answer = doggy.doggyAdd(10, 10); 
		System.out.println(answer);
	}
}
