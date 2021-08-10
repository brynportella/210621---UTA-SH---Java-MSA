package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.model.SuperVillain;

@Repository()
public class SuperVillainDao {
	
	public List<SuperVillain> selectAll(){
		List<SuperVillain> vills = new ArrayList<>();
		
		vills.add(new SuperVillain("Danny Boy", "Technopath", 280_000));
		vills.add(new SuperVillain("Aster", "Firebreath", 100_000));
		vills.add(new SuperVillain("Claire", "Transformation", 220_000));
		vills.add(new SuperVillain("Rain Man", "SuperSpeed", 210_000));
		
		return vills;
		
	}
}
