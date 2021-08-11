package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Food;
import com.example.repository.FoodRepo;

@RestController
@RequestMapping(value="/rest")
public class FoodRestController {
	
	private FoodRepo foodRepo;
	
	@Autowired
	public FoodRestController(FoodRepo foodRepo) {
		this.foodRepo = foodRepo;
	}
	
	public FoodRestController() {
		
	}
	
	@GetMapping("/{id}")
	public Food getFoodById(@PathVariable("id")int id) {
		return foodRepo.selectById(id);
	}
	
	@GetMapping(value="")
	public List<Food> getAllFoods(){
		return foodRepo.selectAll();
	}
	
}
