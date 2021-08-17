package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Post;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	public List<Post> findAll();
	public List<Post> findAllByUser(int u);
	
}
