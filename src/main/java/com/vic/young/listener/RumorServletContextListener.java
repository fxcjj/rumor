package com.vic.young.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Enumeration;

/**
 * Application Lifecycle Listener implementation class RumorServletContextListener
 *
 */
public class RumorServletContextListener implements ServletContextListener {

    public RumorServletContextListener() {
    	//容器启动时执行，在filter之前
    	System.out.println("RumorServletContextListener()...");
    }

    public void contextInitialized(ServletContextEvent sce) {
		//容器启动时执行
    	System.out.println("call contextInitialized() method...");
    	System.out.println("======context-param start=======");
    	Enumeration<?> initParameterNames = sce.getServletContext().getInitParameterNames();
    	while(initParameterNames.hasMoreElements()) {
    		//name
    		String name = (String)initParameterNames.nextElement();
    		//value
    		String value = sce.getServletContext().getInitParameter(name);
    		System.out.println(name + "=" + value);
    	}
    	System.out.println("======context-param end=======");
    }

    public void contextDestroyed(ServletContextEvent sce) {
		//容器销毁时执行，最后执行，在servlet,filter之后
    	System.out.println("call contextDestroyed method...");
    }
	
}
