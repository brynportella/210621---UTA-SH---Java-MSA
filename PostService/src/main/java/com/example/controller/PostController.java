package com.example.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Post;
import com.example.service.PostService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor(onConstructor=@__(@Autowired))
@NoArgsConstructor
public class PostController {
	
	private PostService pServ;
	
	@PostMapping("/create")
	public ResponseEntity<Post> createPost(@RequestBody LinkedHashMap<String, String> post){
		int u = Integer.parseInt(post.get("userId"));
		Post p = new Post(u, post.get("content"));
		pServ.createPost(p);
		return new ResponseEntity<Post>(p, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Post>> getUserPosts(@PathVariable("id")int id){
		return new ResponseEntity<List<Post>>(pServ.getUserPosts(id), HttpStatus.OK);
	}
	
}
