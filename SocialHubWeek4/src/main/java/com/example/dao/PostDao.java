package com.example.dao;

import java.util.List;

import com.example.models.Post;
import com.example.models.PostDisplay;
import com.example.models.User;

public interface PostDao {

	public void createPost(Post p);
	
	public List<PostDisplay> getAllPosts();
	
	public User getUsersPosts(User u);
	
}
