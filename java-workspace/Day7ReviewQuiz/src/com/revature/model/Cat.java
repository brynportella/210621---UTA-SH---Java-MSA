package com.revature.model;

/*
 * Cat is the bottom of any future hierarchy. 
 * 
 * So we don't need to worry about allowing direct access to these variables in subclasses.
 * 
 */
public class Cat {
	private Collar collar;
	private CatToy[] toys;
	
	
	public Cat() {
		collar = new Collar(); 
		toys = new CatToy[4]; 
	}
	
	public Cat(Collar collar, CatToy[] toys) {
		super();
		this.collar = collar;
		this.toys = toys;
	}
	
	
	public void eat() {}
	public void eat(String food) {}
	
	public Collar getCollar() {
		return collar;
	}
	public void setCollar(Collar collar) {
		this.collar = collar;
	}
	public CatToy[] getToys() {
		return toys;
	}
	public void setToys(CatToy[] toys) {
		this.toys = toys;
	}
	
	
}
