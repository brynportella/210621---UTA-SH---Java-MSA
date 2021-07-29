package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.example.dao.PostDao;
import com.example.dao.PostDaoHibernate;
import com.example.dao.UserDao;
import com.example.fileio.FileIO;
import com.example.models.Post;
import com.example.models.PostDisplay;
import com.example.models.User;

public class PostService {

	private PostDaoHibernate pDao;
	private UserDao uDao;
	
	public PostService(PostDaoHibernate p, UserDao d) {
		this.pDao = p;
		this.uDao = d;
	}
	
	public List<PostDisplay> getAllPosts(){
		return pDao.getAllPosts();
	}
	
	public Post addPost(User u, String content) {
		Post p = new Post(0, u, content);
		pDao.createPost(p);
		List<Post> pList = u.getPosts();
		pList.add(p);
		uDao.updateUser(u);
		return p;
	}
	
	public Post likePost(User u, Post p) {
		Set<User> likes = p.getLikes();
		likes.add(u);
		p.setLikes(likes);
		Set<Post> likedPost = u.getLikePosts();
		likedPost.add(p);
		u.setLikePosts(likedPost);
		uDao.updateUser(u);
		return pDao.updatePost(p);
	}
}
