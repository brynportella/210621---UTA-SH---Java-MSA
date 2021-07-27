package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.SuperPrison;
import com.example.util.HibernateUtil;

public class SuperPrisonDao {
	
	public SuperPrisonDao() {
		
	}
	
	public void insert(SuperPrison pris) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(pris);
		tx.commit();
	}
	
	public SuperPrison selectById(int id) {
		Session ses = HibernateUtil.getSession();
		SuperPrison sp = ses.get(SuperPrison.class, id);
		return sp;
	}
	
	public List<SuperPrison> selectAll(){
		Session ses = HibernateUtil.getSession();
		List<SuperPrison> pList = ses.createQuery("from SuperPrison", SuperPrison.class).list();
		return pList;
	}
	
}
