package com.example.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		//We first need to set the responses content type to application/json
		res.setContentType("application/json");
		User u1 = new User("rick", "password");
		User u2 = new User("morty", "password");
		User u3 = new User("summer", "password");
		
		ArrayList<User> uList = new ArrayList<User>();
		uList.add(u1);
		uList.add(u2);
		uList.add(u3);
		
		//We still use getWriter, but this time we use .write
		//and pass in an instance of a new objectmapper, to write the list as a string
		res.getWriter().write(new ObjectMapper().writeValueAsString(uList));
	}
	
}
