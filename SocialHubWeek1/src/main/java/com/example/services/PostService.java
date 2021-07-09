package com.example.services;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.example.dao.FileIO;
import com.example.logging.Logging;
import com.example.models.Post;

public class PostService {
	
	private String file;
	private FileIO<Post> io;
	
	public PostService(String file) {
		this.file = file;
		this.io = new FileIO<Post>(file);
	}
	
	//Get all posts from the post file
	public List<Post> getAllPosts(){
		List<Post> pList;
		
		try {
			pList = io.readObject();
		} catch (FileNotFoundException e) {
			pList = new ArrayList<Post>();
		} catch (Exception e) {
			pList = null;
			e.printStackTrace();
		}
		
		return pList;
	}
	
	public void addPost(Post p) {
		ArrayList<Post> pList;
		
		try {
			pList = io.readObject();
		} catch(FileNotFoundException e) {
			pList = new ArrayList<Post>();
		}
		catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		pList.add(p);
		io.writeObject(pList);
		Logging.logger.info("User: " + p.getUser() + " posted a new post");
	}
	
}
