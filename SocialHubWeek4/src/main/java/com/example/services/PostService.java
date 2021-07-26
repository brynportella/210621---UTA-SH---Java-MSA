package com.example.services;

import java.util.ArrayList;
import java.util.List;

import com.example.dao.PostDao;
import com.example.fileio.FileIO;
import com.example.models.Post;
import com.example.models.PostDisplay;
import com.example.models.User;

public class PostService {

	private PostDao pDao;
	
	public PostService(PostDao p) {
		this.pDao = p;
	}
	
	public List<PostDisplay> getAllPosts(){
		return pDao.getAllPosts();
	}
	
	public void addPost(int userId, int wallId, String content) {
		Post p = new Post(userId, wallId, content);
		pDao.createPost(p);
	}
	
	public User loadUserPosts(User u){
		return pDao.getUsersPosts(u);
	}
	
	
	/*
	public List<Post> getAllPosts(){
		List<Post> pList;
		
		try {
			pList = io.readObject();
		} catch(Exception e) {
			pList = new ArrayList<Post>();
		}
		return pList;
	}
	
	public void addList(Post p) {
		ArrayList<Post> pList;
		
		try {
			pList = io.readObject();
		} catch(Exception e) {
			pList = new ArrayList<Post>();
		}
		
		pList.add(p);
		io.writeObject(pList);
	}
	*/
}
