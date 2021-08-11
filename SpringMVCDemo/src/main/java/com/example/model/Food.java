package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="food")
public class Food {
	
	@Id
	@Column(name="food_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int foodId;
	
	@Column(name="food_name", unique=true, nullable=false)
	private String foodName;
	
	@Column(name="calories", nullable=false)
	private double calories;

	public Food(int foodId, String foodName, double calories) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.calories = calories;
	}

	public Food(String foodName, double calories) {
		super();
		this.foodName = foodName;
		this.calories = calories;
	}

	public Food() {
		super();
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", foodName=" + foodName + ", calories=" + calories + "]";
	}
	
}
