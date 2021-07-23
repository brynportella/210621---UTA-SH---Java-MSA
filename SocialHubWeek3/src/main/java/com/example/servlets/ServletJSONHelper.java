package com.example.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.controllers.LoginController;
import com.example.controllers.LogoutController;
import com.example.controllers.PostsController;
import com.example.controllers.SessionController;
import com.fasterxml.jackson.core.JsonProcessingException;

public class ServletJSONHelper {
	
	public static void process(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		System.out.println("In the ServletJSONHelper with URI: " + req.getRequestURI());
		switch(req.getRequestURI()) {
			case "/SocialHubWeek3/api/login":
				LoginController.login(req, res);
				break;
			case "/SocialHubWeek3/api/logout":
				LogoutController.logout(req, res);
				break;
			case "/SocialHubWeek3/api/posts":
				PostsController.handlePosts(req, res);
				break;
			case "/SocialHubWeek3/api/session":
				SessionController.getSession(req, res);
				break;
		}
	}
	
}
