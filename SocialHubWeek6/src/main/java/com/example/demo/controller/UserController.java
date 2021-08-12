package com.example.demo.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;
import com.example.demo.validator.UserValidator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping(value="/users")
@AllArgsConstructor(onConstructor=@__(@Autowired))
@NoArgsConstructor
public class UserController {
	
	private UserService uServ;
	
	@InitBinder()
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new UserValidator());
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> createUser(@RequestBody LinkedHashMap<String, String> user){
		System.out.println(user);
		User u = new User(user.get("firstName"), user.get("lastName"), user.get("email"), user.get("password"));
		if(uServ.registerUser(u)) {
			return new ResponseEntity<>("User was registered", HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>("Username or email already registered to a user", HttpStatus.CONFLICT);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> loginUser(@RequestBody LinkedHashMap<String, String> user){
		User u = uServ.loginUser(user.get("username"), user.get("password"));
		if(u == null) {
			return new ResponseEntity<User>(u, HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<User> getUser(@PathVariable("username")String username){
		User u = uServ.displayUser(username);
		if(u == null) {
			return new ResponseEntity<User>(u, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}
	
	@GetMapping("/posts/{id}")
	public ResponseEntity<List<Post>> getUserPosts(@PathVariable("id")int id){
		return new ResponseEntity<>(uServ.getUserPosts(id), HttpStatus.OK);
	}
	
	@PostMapping("/validate")
	public ResponseEntity<String> validateUser(@RequestBody @Valid User u, BindingResult result){
		if(result.hasErrors()) {
			System.out.println("Errors were had");
			System.out.println(result.getFieldError());
			return new ResponseEntity<String>(result.getFieldError().getCode() + " " + result.getFieldError().getDefaultMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<String>("User is valid", HttpStatus.OK);
	}
	
}
