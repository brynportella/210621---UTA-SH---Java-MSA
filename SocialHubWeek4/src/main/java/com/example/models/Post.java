package com.example.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@NamedNativeQueries({
	@NamedNativeQuery(name="getUsersThatLiked", query="select p.users from Post p where p.post_id = :id")
})

@Entity
@Table(name="posts")
public class Post{
	
	@Id
	@Column(name="post_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int postId;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	@JsonIgnoreProperties("posts")
	private User user;
	
	@Column(name="content")
	private String postContent;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name="post_likes_junction",
		joinColumns= {@JoinColumn(name="post_id")},
		inverseJoinColumns = {@JoinColumn(name="user_id")}
	)
	Set<User> likes = new HashSet<>();
	
	public Post() {
		
	}
	
	public Post(int id, User u, String content) {
		this.postId = id;
		this.user = u;
		this.postContent = content;
	}
	
	public Post(User u, String content) {
		this.user = u;
		this.postContent = content;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public User getUser() {
		return user;
	}

	public void setAuthorId(User u) {
		this.user = u;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	
	public Set<User> getLikes() {
		return likes;
	}

	public void setLikes(Set<User> likes) {
		this.likes = likes;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", user=" + user.getUsername() + ", postContent=" + postContent + ", likes=" + likes + "]";
	}

	
}
