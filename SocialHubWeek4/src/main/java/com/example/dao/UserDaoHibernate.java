package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.example.models.User;
import com.example.utils.HibernateUtil;

public class UserDaoHibernate implements UserDao{
	
	//Native SQL will allow us to execute plain old SQL queries on the table itself
	//It is not recommeded because this tightly couples your code to the database itself
	@Override
	public List<User> getAllUsers() {
		Session ses = HibernateUtil.getSession();
		List<User> users = ses.createNativeQuery("select * from users", User.class).list();
		//ses.close();
		return users;
	}
	
	//Criteria API allows you to create complex queries programaticaly using OOP principles rather than sql
	//It targets the objects rather than the tables
	@Override
	public User getUserByUserName(String username) {
		
		Session ses = HibernateUtil.getSession();
		System.out.println("In get user by username");
		User user = ses.createQuery("from User where username=:username", User.class).setString("username", username).uniqueResult();
		System.out.println(user);
		//ses.close();
		return user;
	}
	
	//HQL allows you to create queries based on the object rather than the table
	public User getUserById(int id) {
		Session ses = HibernateUtil.getSession();
		User user = ses.createQuery("from User where id=" + id, User.class).uniqueResult();
		return user;
	}
	
	//Sessions have built in methods that help you achieve basic crud operations
	@Override
	public void createUser(User u) {
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		//.save will save the object to the database for you
		ses.save(u);
		tran.commit();
		//ses.close();
	}

	@Override
	public void updateUser(User u) {
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		//.update will update a specific record for you
		ses.update(u);
		tran.commit();
		//ses.close();
	}

	@Override
	public void deleteUser(User u) {
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		//.update delete will delete an entity from the table for you
		ses.delete(u);
		tran.commit();
		//ses.close();
	}

}
