package com.example.models;

public class PostDisplay {
	
	private String username;
	private int postId;
	private int authorId;
	private String content;
	
	public PostDisplay() {
		
	}
	
	public PostDisplay(String username, int postId, int authorId, String content) {
		super();
		this.username = username;
		this.postId = postId;
		this.authorId = authorId;
		this.content = content;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "PostDisplay [username=" + username + ", postId=" + postId + ", authorId=" + authorId + ", content=" + content + "]";
	}
}
