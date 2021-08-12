package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Post;
import com.example.demo.model.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	public List<Post> findAll();
	public Post findByUser(User u);
	
}
