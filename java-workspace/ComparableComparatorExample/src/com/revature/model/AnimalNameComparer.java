package com.revature.model;

import java.util.Comparator;

public class AnimalNameComparer implements Comparator<Animal> {

	@Override
	public int compare(Animal o1, Animal o2) {
		// TODO Auto-generated method stub
		return (o1.getName()).compareTo(o2.getName());
	}

}
