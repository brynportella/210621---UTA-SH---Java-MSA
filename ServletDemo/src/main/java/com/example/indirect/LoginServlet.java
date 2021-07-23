package com.example.indirect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	//If we get a GET reqeust to /login, we will forward the user to login.html
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		//We can use our RequestDispatcher to use our forward method to server a static webpage to our client
		//We get the dispatcher from the req object
		req.getRequestDispatcher("login.html").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		//We can use servlets to handle for submissions from the client
		//To get the form data we use .getParameter()
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		System.out.println(username);
		System.out.println(password);
		if(!username.equals("rick") || !password.equals("password")) {
			//We can redirect to the login page again
			//Or we can redirect anywhere in the www
			//res.sendRedirect("https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley");
			res.sendRedirect("login");
		}
		else {
			res.sendRedirect("https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley");
		}
		
		
	}
}
