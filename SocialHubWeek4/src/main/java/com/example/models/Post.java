package com.example.models;

public class Post{
	
	private int postId;
	private int authorId;
	private int wallUserId;
	private String postContent;
	
	public Post() {
		
	}
	
	public Post(int id, int authorId, int wallId, String content) {
		this.postId = id;
		this.authorId = authorId;
		this.wallUserId = wallId;
		this.postContent = content;
	}
	
	public Post(int authorId, int wallId, String content) {
		this.authorId = authorId;
		this.wallUserId = wallId;
		this.postContent = content;
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

	public int getWallUserId() {
		return wallUserId;
	}

	public void setWallUserId(int wallUserId) {
		this.wallUserId = wallUserId;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", authorId=" + authorId + ", wallUserId=" + wallUserId + ", postContent="
				+ postContent + "]";
	}
}
