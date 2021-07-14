package com.example.models;

import java.io.Serializable;

public class Post implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String user;
	private String content;
	
	public Post() {
		
	}
	
	public Post(String user, String content) {
		this.user = user;
		this.content = content;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Post [user=" + user + ", content=" + content + "]";
	}
	
}
