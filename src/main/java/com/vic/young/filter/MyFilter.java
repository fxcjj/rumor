package com.vic.young.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(filterName = "MyFilter",
        /*
        1) urlPatterns 匹配请求中的url，如"/*", "*.do"等，匹配到此filter会执行。
        2) 指定应用此filter的servlet
         */
//        urlPatterns = {"*.do"},
        servletNames = {"Servlet4"},
        initParams = {
                @WebInitParam(name = "name", value = "sahara"),
                @WebInitParam(name = "age", value = "18")
        }
        )
public class MyFilter implements Filter {

    public void destroy() {
        //容器销毁后执行，在servlet之后
        System.out.println("MyFilter destroy.");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        System.out.println("Before MyFilter doFilter method.");
        chain.doFilter(req, resp); //执行指定servlet的doGet/doPost方法
        System.out.println("After MyFilter doFilter method.");

    }

    public void init(FilterConfig config) throws ServletException {
        String name = config.getInitParameter("name");
        String age = config.getInitParameter("age");
        //启动容器时初始化，在listener之后，在servlet之前
        System.out.println("MyFilter init. init param, name: " + name + ", age: " + age);
    }

}

/*
output:
Servlet4 init(ServletConfig config) method...
Servlet4 init() method...
Before MyFilter doFilter method.
Servlet4...
After MyFilter doFilter method.
*/