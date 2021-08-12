package com.example.demo.controller;

import java.util.LinkedHashMap;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@RestController
@RequestMapping(value="temp")
@NoArgsConstructor
public class RestTemplateController {
	
	@GetMapping("/get")
	public ResponseEntity<String> restTemplateGet(){
		RestTemplate rest = new RestTemplate();
		String url = "https://jsonplaceholder.typicode.com/posts";
		ResponseEntity<String> res = rest.getForEntity(url, String.class);
		return res;
	}
	
	@PostMapping("/exchange")
	public GenericPost restTemplateExchange(@RequestBody GenericPost p) {
		RestTemplate rest = new RestTemplate();
		String url = "https://jsonplaceholder.typicode.com/posts";
		HttpEntity<GenericPost> request = new HttpEntity<>(new GenericPost(p.getTitle(), p.getBody(), p.getUserId()));
		return rest.exchange(url, HttpMethod.POST, request, GenericPost.class).getBody();
	}
	
	@PostMapping("/post")
	public ResponseEntity<GenericPost> restTemplatePost(@RequestBody LinkedHashMap<String, String> post){
		RestTemplate rest = new RestTemplate();
		String url = "https://jsonplaceholder.typicode.com/posts";
		HttpEntity<GenericPost> request = new HttpEntity<>(new GenericPost(post.get("title"), post.get("body"), Integer.parseInt(post.get("userId"))));
		GenericPost p = rest.postForObject(url, request, GenericPost.class);
		return new ResponseEntity<GenericPost>(p, HttpStatus.CREATED);
	}
	
}


class GenericPost{
	private String title;
	private String body;
	private int userId;
	public GenericPost(String title, String body, int userId) {
		super();
		this.title = title;
		this.body = body;
		this.userId = userId;
	}
	public GenericPost() {
		super();
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "GenericPost [title=" + title + ", body=" + body + ", userId=" + userId + "]";
	}
	
}
