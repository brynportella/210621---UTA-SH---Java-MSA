package com.example.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MasterViewServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	//This is one of our front controllers, it will delegate requests to the dispatcher
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		System.out.println("Starting in the Master doGet method");
		req.getRequestDispatcher(RequestViewHelper.process(req)).forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		doGet(req, res);
	}
	
}
