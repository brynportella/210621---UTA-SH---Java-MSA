package com.example.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.PostDao;
import com.example.dao.PostDaoConcrete;
import com.example.dao.UserDao;
import com.example.dao.UserDaoConcrete;
import com.example.models.Post;
import com.example.models.PostDisplay;
import com.example.models.User;
import com.example.services.PostService;
import com.example.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class PostsController {
	
	private static PostDao pDao = new PostDaoConcrete();
	private static PostService pServ = new PostService(pDao);
	private static UserDao uDao = new UserDaoConcrete();
	private static UserService uServ = new UserService(uDao);
	
	public static void handlePosts(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		if(req.getMethod().equals("GET")) {
			
			List<PostDisplay> posts = pServ.getAllPosts();
			res.getWriter().write(new ObjectMapper().writeValueAsString(posts));
			
		}
		else {
			//To read in stringified JSON data is a bit more complicated,
			StringBuilder buffer = new StringBuilder();
			BufferedReader reader = req.getReader();
			
			String line;
			while((line = reader.readLine()) != null) {
				buffer.append(line);
				buffer.append(System.lineSeparator());
			}
			String data = buffer.toString();
			System.out.println(data);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode parsedObj = mapper.readTree(data);
			
			int userId = Integer.parseInt(parsedObj.get("userId").asText());
			int wallId = Integer.parseInt(parsedObj.get("wallId").asText());
			String content = parsedObj.get("content").asText();
			
			pServ.addPost(userId, wallId, content);
			
			ObjectNode ret = mapper.createObjectNode();
			ret.put("message", "successfully submitted a new reimbursment");
			
			res.getWriter().write(new ObjectMapper().writeValueAsString(ret));
		}
	}
	
}
