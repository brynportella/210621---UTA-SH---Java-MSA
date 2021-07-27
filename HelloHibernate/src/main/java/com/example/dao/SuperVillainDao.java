package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.SuperVillain;
import com.example.util.HibernateUtil;

public class SuperVillainDao {
	
	public SuperVillainDao() {
		
	}
	
	public void insert(SuperVillain svill) {
		//First we need to open up a session
		Session ses = HibernateUtil.getSession();
		//Then we must start a transaction
		Transaction tx = ses.beginTransaction();
		//Use the session method .save() to write the super villain object to our database
		ses.save(svill);
		//Commit the transaction
		tx.commit();
		//Close the session once you are done
		//ses.close();
	}
	
	public SuperVillain selectVillain(int id) {
		Session ses = HibernateUtil.getSession();
		//If you are using ses.get(), you must use the id
		SuperVillain vill = ses.get(SuperVillain.class, id);
		//ses.close();
		return vill;
	}
	
	public SuperVillain selectByNameNative(String name) {
		
		//We can use native SQL queries
		//You can create more complex queries with plain old SQL query
		//It targets the database table rather than the object
		//It is not recommended because it tightly couples your application to your database
		Session ses = HibernateUtil.getSession();
		List<SuperVillain> villList = ses.createNativeQuery("select * from super_villain where name= '" + name + "'", SuperVillain.class).list();
		return villList.get(0);
	}
	
}
