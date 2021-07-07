package com.example.generics;

public class Generics {
	
	public static void main(String[] args) {
		
		//We can create an instance of our GenericClass like this
		GenericClass<Integer> gc = new GenericClass<Integer>(5);
		
		//What we cant do is something like this
		//GenericClass<String> gc2 = new GenericClass<String>(3);
		
		System.out.println(gc.getValue());
		
		//We must only input integers now
		//gc.setValue(3.2);
		
		VeryGeneric<String> vg = new VeryGeneric<String>("Hello");
		
		VeryGeneric<Double> vg2 = new VeryGeneric<Double>(4.5);
		
		System.out.println(vg.value);
		
		//We still cant change the type of value
		//vg2.value = "Hello";
		
	}
	
}

class GenericClass<T extends Number>{
	private T value;
	private double value2;
	
	public GenericClass(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
}

class VeryGeneric<T> {
	public T value;
	
	public VeryGeneric(T value) {
		this.value = value;
	}
}
