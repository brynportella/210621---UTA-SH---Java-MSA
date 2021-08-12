package com.example.demo.model;

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
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="posts")
public class Post {
	
	@Id
	@Column(name="post_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int postId;
	
	@Column(name="content")
	private String postContent;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
		name="post_likes_junction",
		joinColumns= {@JoinColumn(name="post_id")},
		inverseJoinColumns = {@JoinColumn(name="user_id")}
	)
	Set<User> likes = new HashSet<User>();
	
	public Post(int id, User u, String content) {
		this.postId = id;
		this.user = u;
		this.postContent = content;
	}
	
	public Post(User u, String content) {
		this.user = u;
		this.postContent = content;
	}
}
