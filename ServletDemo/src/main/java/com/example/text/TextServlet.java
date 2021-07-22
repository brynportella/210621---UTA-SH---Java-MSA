package com.example.text;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TextServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	//The default content type for our response and request is text/html
	//We can use the printwriter from our response object to respond with text/html directly to the client
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		PrintWriter pw = res.getWriter();
		System.out.println("We made it to the simple text servlet");
		//Now we can send information of type text/html to the client
		pw.println("Hello from a simple servlet");
	}
	
}
