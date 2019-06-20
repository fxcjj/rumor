package com.vic.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Servlet implementation class CookieDemo1
 */
public class CookieDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieDemo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Cookie[] cookies = request.getCookies();
	    PrintWriter out = response.getWriter();
	    if(cookies != null) {
	        out.write("last access time: ");
	        for(Cookie c : cookies) {
	            if (c.getName().equals("lastAccessTime")) {
	                    Long lastAccessTime =Long.parseLong(c.getValue());
	                    Date date = new Date(lastAccessTime);
	                    out.write("name="+c.getName()+", value="+date.toLocaleString()+", domain="+c.getDomain()+", path="+c.getPath());
	             }
	        }
	    } else {
	        out.write("you first time access this web!");
	    }
	    Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis()+"");
	    
	    //Sets the maximum age of the cookie in seconds
	    //若浏览器15s没有任何操作，则删除cookie
//	    cookie.setMaxAge(60*60*24);
	    
	    //表示无cookie，即用户每次访问都是first time
	    //A zero value causes the cookie to be deleted.
//	    cookie.setMaxAge(0);
	    
	    //Note: 默认是-1，表示会持续保留值直到server退出

//	    cookie.setMaxAge(0); //5min
	    cookie.setPath("/rumor1/jsp");
	    
	    response.addCookie(cookie);
	    
	}

}
