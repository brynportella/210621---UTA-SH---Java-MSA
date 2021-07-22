package com.example.html;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HtmlServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		//We can still use the printwriter to send over some HTML
		PrintWriter pw = res.getWriter();
		System.out.println("We are in our HTML servlet");
		pw.println("<html><body><h1>Hello from a HTMLServlet</h1></body></html>");
	}
	
}
