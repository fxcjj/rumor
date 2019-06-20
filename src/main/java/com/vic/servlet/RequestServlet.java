package com.vic.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class RequestServlet
 */
public class RequestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String scheme = request.getScheme();
		String localAddr = request.getLocalAddr();
		String remoteAddr = request.getRemoteAddr();
		String remoteHost = request.getRemoteHost();
		int remotePort = request.getRemotePort();
		StringBuffer requestURL = request.getRequestURL();
		String requestURI = request.getRequestURI();
		String serverName = request.getServerName();
		int serverPort = request.getServerPort();
		String servletPath = request.getServletPath();
		
		//http
		System.out.println("scheme = " + scheme);
		System.out.println("localAddr = " + localAddr);
		System.out.println("remoteAddr = " + remoteAddr);
		System.out.println("remoteHost = " + remoteHost);
		System.out.println("remotePort = " + remotePort);
		// http://localhost:8081/rumor/RequestServlet
		System.out.println("requestURL = " + requestURL);
		// /rumor/RequestServlet
		System.out.println("requestURI = " + requestURI);
		//localhost
		System.out.println("serverName = " + serverName);
		//8081
		System.out.println("serverPort = " + serverPort);
		// /RequestServlet
		System.out.println("servletPath = " + servletPath);
		
		String xxfIp = request.getHeader("X-Forwarded-For");
		System.out.println("X-Forwarded-For = " + xxfIp);
		
		String xrIp = request.getHeader("X-Real-IP");
		System.out.println("X-Real-IP = " + xrIp);
		
		
	}

}
