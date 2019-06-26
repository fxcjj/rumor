package com.vic.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Victor
*/
public class HelloFilter implements Filter {
	
	protected Set<String> includeUrls = new HashSet<String>();
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String includeUrlsParam = filterConfig.getInitParameter("includeUrls");
		/*String[] urlsArray = includeUrlsParam.split(",");
		Collections.addAll(this.includeUrls, urlsArray);*/
	}
	

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("Before HelloFilter doFilter method.");
		HttpServletRequest request = (HttpServletRequest)req;
		
		String servletPath = request.getServletPath();
		System.out.println(servletPath);
		// 为/a.jsp时
		if(includeUrls.contains(servletPath)) {
			return;
		}
		filterChain.doFilter(request, resp);
		System.out.println("After HelloFilter doFilter method.");
	}
	
	@Override
	public void destroy() {
		
	}

}
