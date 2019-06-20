package com.vic.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Servlet1
 */
public class Servlet3 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet3 init(ServletConfig config) method...");
		super.init(config);
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet3 init() method...");
		super.init();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet3...");
	}

}
