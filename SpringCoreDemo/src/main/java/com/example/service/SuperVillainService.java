package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.SuperVillainDao;
import com.example.model.SuperVillain;

@Component("SuperVillainServiceBean")
public class SuperVillainService {
	
	//Old way withour DI
	//private SuperVillainDao vDao = new SuperVillainDao();
	
	//With DI
	//@Autowired //using autowired above a property tells spring to attempt byName then byType
	private SuperVillainDao vDao;
	
	public static int counter = 0;
	
	public SuperVillainService() {
		System.out.println("In service layer: no args constructor");
		counter++;
	}
	
	@Autowired
	public SuperVillainService(SuperVillainDao vDao) {
		System.out.println("In service later, DI constructor");
		counter++;
		this.vDao = vDao;
	}
	
	public SuperVillainService(SuperVillainDao vDao, int num) {
		System.out.println("In service later: DI constructor with int argument" + num);
		counter++;
		this.vDao = vDao;
	}
	
	public List<SuperVillain> getAllVills(){
		return vDao.selectAll();
	}
	
	public SuperVillainDao getVillDao() {
		return vDao;
	}
	
	//If you are using setter injection you have to match the set... exactly to the property you are trying to set
	//@Autowired
	public void setvDao(SuperVillainDao vDao) {
		System.out.println("In the setter");
		this.vDao = vDao;
	}
	
}
