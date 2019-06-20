package com.vic.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class SessionServlet
 */
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Overrides the name of the character encoding used in the body of this
		 * request. This method must be called prior to reading request
		 * parameters or reading input using getReader().
		 */
		//request.setCharacterEncoding("UTF-8");

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//使用request得到session,如果不存在则创建一个
		HttpSession session = request.getSession();
		//将数据存储到session中
		session.setAttribute("data", "hello");
		//获取session的id 
		String sessionId = session.getId();
		//判断session是不是新创建的
		if(session.isNew()) {
			response.getWriter().print("session创建成功，session id是：" + sessionId);
		} else {
			response.getWriter().print("服务器已经存在该session了，session的id是：" + sessionId);
		}
		
	}

}
