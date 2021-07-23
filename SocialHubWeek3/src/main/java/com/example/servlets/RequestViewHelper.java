package com.example.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.example.controllers.LoginViewController;

public class RequestViewHelper {
	
	//This is the class that will delegate tasks to certain controllers
	//This is basically our dispatcher
	public static String process(HttpServletRequest req) throws IOException, ServletException{
		System.out.println("In the view dispatcher process method, with URI: " + req.getRequestURI());
		//We will use the specific URI to send the request to the correct controller
		switch(req.getRequestURI()) {
			case "/SocialHubWeek3/login":
				return LoginViewController.fetchLoginPage(req);
			default:
				return "/SocialHubWeek3/login";
		}
	}
	
}
