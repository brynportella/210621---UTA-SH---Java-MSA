package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Crime;
import com.example.util.HibernateUtil;

public class CrimeDao {
	
	public CrimeDao() {
		
	}
	
	public void insert(Crime crime) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(crime);
		tx.commit();
	}
	
	public void update(Crime crime) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.update(crime);
		tx.commit();
	}
	
	public Crime selectById(int id) {
		Session ses = HibernateUtil.getSession();
		Crime crime = ses.get(Crime.class, id);
		return crime;
	}
	
	public List<Crime> selectAll(){
		Session ses = HibernateUtil.getSession();
		List<Crime> cList = ses.createQuery("from Crime", Crime.class).list();
		return cList;
	}
	
}
