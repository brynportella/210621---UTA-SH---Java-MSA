package com.example.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Food;
import com.example.repository.FoodRepo;

@Controller
//Request mapping maps the uri to localhost:8080/ProjectName/api/foodController
@RequestMapping(path="/foodController")
//CORS aka cross origin resource sharing is a way to restrict access from resources outside of the server domain
//The star will allow all access to this controller
@CrossOrigin(origins="*")
public class FoodController {
	
	private FoodRepo foodRepo;
	
	public FoodController() {
		
	}
	
	@Autowired
	public FoodController(FoodRepo foodRepo) {
		this.foodRepo = foodRepo;
	}
	
	//@RequestMapping(value="/foods", method=RequestMethod.GET)
	@GetMapping(value="/foods")
	//ResponseBody sets the response body and sends the response back to client automatically
	public @ResponseBody List<Food> getAllFoods(){
		System.out.println("In the get all foods");
		return foodRepo.selectAll();
	}
	
	@GetMapping(value="/foods/id", produces="application/json")
	//You can use ResponseEntity to manually set the response body and status code
	//RequestParam allows you to add a paramer to the end of your request uri
	public ResponseEntity<Food> getFoodById(@RequestParam("id") int id){
		return new ResponseEntity<Food>(foodRepo.selectById(id), HttpStatus.OK);
	}
	
	@GetMapping(value="/foods/{name}")
	//PathVariable allows you to replace {name} with the name of the food you are looking for
	public ResponseEntity<Food> getFoodByName(@PathVariable("name")String name){
		Food food = foodRepo.selectByName(name);
		if(food == null) {
			return new ResponseEntity<Food>(new Food(0, "", 0.0), HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<Food>(food, HttpStatus.OK);
		}
	}
	
	@PostMapping(value="foods/create", consumes=MediaType.APPLICATION_JSON_VALUE)
	//@RequestBody allows us to access the body of the HTTP Request
	//We use a LinkedHashMap to access the json body attributes
	public ResponseEntity<Food> createFood(@RequestBody LinkedHashMap<String, String> foodMap){
		Food food = new Food(foodMap.get("name"), Double.parseDouble(foodMap.get("calories")));
		foodRepo.insert(food);
		return new ResponseEntity<Food>(foodRepo.selectByName(food.getFoodName()), HttpStatus.CREATED);
	}
	
}
