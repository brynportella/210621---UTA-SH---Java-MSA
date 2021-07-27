package com.example.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static Session ses;
	
	private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	
	public static Session getSession() {
		if(ses == null) {
			ses = sf.openSession();
		}
		return ses;
	}
	
	public static void closeSes() {
		ses.close();
		sf.close();
	}
}
