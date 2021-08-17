package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Post;
import com.example.repository.PostRepo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@AllArgsConstructor(onConstructor= @__(@Autowired))
public class PostService {

	private PostRepo pDao;
	
	public void createPost(Post p) {
		pDao.save(p);
	}
	
	public List<Post> getAllPosts(){
		return pDao.findAll();
	}
	
	public Post getPostById(int postId) {
		return pDao.getById(postId);
	}
	
	public List<Post> getUserPosts(int u){
		return pDao.findAllByUser(u);
	}
	
}
