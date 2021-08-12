package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.repository.PostRepo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@AllArgsConstructor(onConstructor=@__(@Autowired))
public class PostService {
	
	private PostRepo pDao;
	
	public void createPost(Post p) {
		pDao.save(p);
	}
	
	public List<Post> getAllPosts(){
		return pDao.findAll();
	}
	
	public void likePost(int postId, User u) {
		Post p = pDao.findById(postId).get();
		p.getLikes().add(u);
		//In spring data jpa if you call save on an entity that has a predefined id in a data base it will be treated as an update
		pDao.save(p);
	}
	
	public Post getPostById(int postId) {
		return pDao.findById(postId).get();
	}
	
}
