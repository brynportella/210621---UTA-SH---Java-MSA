package com.revature.main;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

import com.revature.model.Animal;
import com.revature.model.AnimalNameComparer;

public class Main {
	public static void main(String[] args) {
		Animal tiger = new Animal(1L,"tiger", "Tony", 280.0);
		Animal hippo = new Animal(2L,"hippo", "Horton", 400.0);
		Animal pig = new Animal(3L,"pig", "Piglet", 40.0);
		
		SortedSet<Animal> sortedAnimals = new TreeSet<Animal>(); 
		sortedAnimals.add(pig); 
		sortedAnimals.add(tiger);
		sortedAnimals.add(hippo); 
		
		System.out.println(sortedAnimals);
		
		Comparator<Animal> animalComparer = new AnimalNameComparer();
		SortedSet<Animal> sortedAnimalsNames = new TreeSet<Animal>(animalComparer); 
		sortedAnimalsNames.add(pig); 
		sortedAnimalsNames.add(tiger);
		sortedAnimalsNames.add(hippo); 
		
		System.out.println("\n\n\n"+sortedAnimalsNames);
	}
}
