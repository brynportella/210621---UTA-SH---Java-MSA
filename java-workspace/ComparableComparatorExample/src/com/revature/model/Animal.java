package com.revature.model;

//How do I modify the declaration of this class 
//to implement Comparable<>??
public class Animal implements Comparable<Animal>  {
	private long chipSerialNumber;
	private String type; 
	private String name; 
	private double size; 
	
	public Animal() {}
	
	
	
	public Animal(long chipSerialNumber, String type, String name, double size) {
		super();
		this.chipSerialNumber = chipSerialNumber;
		this.type = type;
		this.name = name;
		this.size = size;
	}



	public long getChipSerialNumber() {
		return chipSerialNumber;
	}



	public void setChipSerialNumber(long chipSerialNumber) {
		this.chipSerialNumber = chipSerialNumber;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getSize() {
		return size;
	}



	public void setSize(double size) {
		this.size = size;
	}



	//myAnimalObject.compareTo(myOtherAnimalObject)
	//A.compareTo(B); 
	//A comes before B result should be less than 0 
	public int compareTo(Animal otherAnimal) {
		long result = this.chipSerialNumber - otherAnimal.chipSerialNumber; 
		if (result < 0) {
			return -1;
		}else if(result > 0 ) {
			return 1; 
		}else {
			return 0; 
		}
	}



	@Override
	public String toString() {
		return "Animal [chipSerialNumber=" + chipSerialNumber + ", type=" + type + ", name=" + name + ", size=" + size
				+ "]";
	}
	
	
}
