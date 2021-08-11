package com.example.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Food;

@Transactional
@Repository("foodDao")
public class FoodRepo {
	
	private SessionFactory sesFact;
	
	public FoodRepo() {
		
	}
	
	@Autowired
	public FoodRepo(SessionFactory sesFact) {
		this.sesFact = sesFact;
	}
	
	public void insert(Food food) {
		sesFact.getCurrentSession().save(food);
	}
	
	public Food selectById(int id) {
		return sesFact.getCurrentSession().get(Food.class, id);
	}
	
	public List<Food> selectAll(){
		return sesFact.getCurrentSession().createQuery("from Food", Food.class).list();
	}
	
	public Food selectByName(String name) {
		List<Food> foodList = sesFact.getCurrentSession()
				.createQuery("from Food where food_name=:name", Food.class).setParameter("name", name).list();
		if(foodList.size() == 0) {
			System.out.println("No food of this name exists");
			return null;
		}
		return foodList.get(0);
	}
	
}
