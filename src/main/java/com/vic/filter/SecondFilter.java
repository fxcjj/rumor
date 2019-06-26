package com.vic.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Servlet Filter implementation class SecondFilter
 */
@WebFilter("/SecondFilter")
public class SecondFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Before SecondFilter doFilter method.");
		chain.doFilter(request, response);
		System.out.println("After SecondFilter doFilter method.");
	}

	public void destroy() {
	}
}
