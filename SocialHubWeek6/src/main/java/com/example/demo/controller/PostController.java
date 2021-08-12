package com.example.demo.controller;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.service.PostService;
import com.example.demo.service.UserService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping(value="/posts")
@AllArgsConstructor(onConstructor=@__(@Autowired))
@NoArgsConstructor
public class PostController {

	private UserService uServ;
	private PostService pServ;
	
	@PostMapping("/create")
	public ResponseEntity<String> createPost(@RequestBody LinkedHashMap<String, String> post){
		User u = uServ.getUserById(Integer.parseInt(post.get("userId")));
		Post p = new Post(u, post.get("content"));
		pServ.createPost(p);
		return new ResponseEntity<String>("Post created successfully", HttpStatus.CREATED);
	}
	
	@PostMapping("/like")
	public ResponseEntity<Post> likePost(@RequestBody LinkedHashMap<String, String> post){
		User u = uServ.getUserById(Integer.parseInt(post.get("userId")));
		pServ.likePost(Integer.parseInt(post.get("postId")), u);
		return new ResponseEntity<>(pServ.getPostById(Integer.parseInt(post.get("postId"))), HttpStatus.OK);
	}
	
}
