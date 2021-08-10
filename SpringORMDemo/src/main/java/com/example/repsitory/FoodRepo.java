package com.example.repsitory;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Food;

@Transactional
@Repository("foodRepo")
public class FoodRepo {
	
	private SessionFactory sesFact;
	
	public FoodRepo() {
		super();
	}
	
	@Autowired
	public FoodRepo(SessionFactory sesFact) {
		this.sesFact = sesFact;
	}
	
	public void insert(Food food) {
		/* Old hibernate way
		 * Session ses = sesFact.openSession();
		 * Transaction tx = ses.beginTransaction();
		 * ses.save(food);
		 * tx.commit();
		 * ses.close();
		 */
		//New way with spring orm
		sesFact.getCurrentSession().save(food);
	}
	
	public void update(Food food) {
		/*
		 * Session ses = sesFact.openSession();
		 * Transaction tx = ses.beginTransaction();
		 * ses.update(food);
		 * tx.commit();
		 * ses.close();
		 */
		sesFact.getCurrentSession().update(food);
	}
	
	public Food selectById(int id) {
		return sesFact.getCurrentSession().get(Food.class, id);
	}
	
	public List<Food> selectAll(){
		List<Food> foodList = sesFact.getCurrentSession()
				.createQuery("from Food", Food.class)
				.list();
		return foodList;
	}
}
