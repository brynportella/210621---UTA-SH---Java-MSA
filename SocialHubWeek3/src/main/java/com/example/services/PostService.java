package com.example.services;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.example.dao.FileIO;
import com.example.dao.PostDao;
import com.example.logging.Logging;
import com.example.models.Post;
import com.example.models.PostDisplay;
import com.example.models.User;

public class PostService {
	
	private PostDao pDao;
	
	public PostService(PostDao p) {
		this.pDao = p;
	}
	
	public void addPost(int userId, int wallId, String content) {
		Post p = new Post(userId, wallId, content);
		pDao.createPost(p);
	}
	
	public List<PostDisplay> getAllPosts(){
		return pDao.getAllPosts();
	}
	
	public User loadUserPosts(User u) {
		return pDao.getUsersPosts(u);
	}
	
}
