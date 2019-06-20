package com.vic.servlet;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ThreadServlet1
 */
public class ThreadServlet1 extends HttpServlet implements SingleThreadModel {
	private static final long serialVersionUID = 1L;

	int i = 1;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			i++;
			try {
				Thread.sleep(1000*4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			response.getWriter().write(i+"");
	}

}
