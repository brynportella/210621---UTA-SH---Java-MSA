package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
	
	public SuperVillain selectByNameHQL(String name) {
		//HQL Hibernate Query Language creates complex queries using a combo of OOP and SQL
		Session ses = HibernateUtil.getSession();
		List<SuperVillain> villList = ses.createQuery("from SuperVillain where name='" + name + "'", SuperVillain.class).list();
		if(villList.size() == 0) {
			return null;
		}
		return villList.get(0);
	}
	
	public SuperVillain selectByNameCriteria(String name) {
		//Creates complex queries programatically, it does with OOP principles
		Session ses = HibernateUtil.getSession();
		List<SuperVillain> villList = ses.createCriteria(SuperVillain.class).add(Restrictions.like("name", name)).list();
		return villList.get(0);
	}
	
	public void update(SuperVillain vil) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.update(vil);
		tx.commit();
	}
	
	public List<SuperVillain> selectAll(){
		Session ses = HibernateUtil.getSession();
		//This is how we select all entries in a table with HQL
		//HQL is based off of our Java objects, not the table in the db, 
		//Hibernate translates this HQL into native SQL
		List<SuperVillain> villList = ses.createQuery("from SuperVillain", SuperVillain.class).list();
		return villList;
	}
	
}
