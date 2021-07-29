package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.models.Post;
import com.example.models.PostDisplay;
import com.example.models.User;
import com.example.utils.HibernateUtil;

public class PostDaoHibernate implements PostDao{
	
	@Override
	public void createPost(Post p) {
		
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		ses.save(p);
		tran.commit();
	}
	
	//More HQL Examples
	@Override
	public List<PostDisplay> getAllPosts() {
		Session ses = HibernateUtil.getSession();
		
		List<Post> posts = ses.createQuery("from Post ORDER BY postId DESC", Post.class).list();
		List<PostDisplay> postList = new ArrayList<PostDisplay>();
		
		for(Post post: posts) {
			PostDisplay p = new PostDisplay(post.getUser().getUsername(), post.getPostId(), post.getUser().getId(), post.getPostContent());
			postList.add(p);
		}
		
		return postList;
	}
	
	public Post getPostById(int id) {
		Session ses = HibernateUtil.getSession();
		Query q = ses.createQuery("from Post where id = :id");
		q.setInteger("id", id);
		Post post = (Post) q.uniqueResult();
		return post;
	}

	//This method is now unneeded, because hibernate will automatically like the users posts to the user
	@Override
	public User getUsersPosts(User u) {
		
		return null;
		
	}
	
	public Post updatePost(Post p) {
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		ses.update(p);
		tran.commit();
		return ses.get(Post.class, p.getPostId());
	}

}
