package com.vic.shop;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class BuyServlet
 */
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Book book = DB.getAll().get(id);  //得到用户想买的书
		HttpSession session = request.getSession();
		List<Book> list = (List<Book>) session.getAttribute("list");  //得到用户用于保存所有书的容器
		if(list==null){
			list = new ArrayList<Book>();
			session.setAttribute("list", list);
		}
		list.add(book);
		//response. encodeRedirectURL(java.lang.String url)用于对sendRedirect方法后的url地址进行重写
		String url = response.encodeRedirectURL(request.getContextPath() + "/ListCartServlet");
		System.out.println(url);
		response.sendRedirect(url);
	}

}
