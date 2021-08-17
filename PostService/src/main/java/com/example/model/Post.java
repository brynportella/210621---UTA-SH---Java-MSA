package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name="user_id")
	private int user;
	
	@Column(name="content")
	private String postContent;
	
	public Post(int u, String content) {
		this.user = u;
		this.postContent = content;
	}
	
}
