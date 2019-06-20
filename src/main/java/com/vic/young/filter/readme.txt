
1. listener,filter,servlet的初始化顺序和销毁顺序
初始化顺序
listener
filter
servlet

销毁顺序
servlet
filter
listener

2. filter启动顺序和销毁顺序
创建4个filter
filter1
filter2
filter3
filter4

filter1和filter2在web.xml中配置
<filter-mapping>
	<filter-name>filter2</filter-name>
	<url-pattern>/myHttpServlet</url-pattern>
</filter-mapping>

<filter-mapping>
	<filter-name>filter1</filter-name>
	<url-pattern>/myHttpServlet</url-pattern>
</filter-mapping>

filter1和filter2使用@WebFilter注解配置

启动顺序
filter2
filter1
filter4
filter3

销毁顺序
filter2
filter1
filter4
filter3

作用顺序
filter2 doFilter
filter1 doFilter
filter4 doFilter
filter4 doFilter

总结：web.xml中配置的filter，以filterMapping为顺序，先声明先执行。
使用@WebFilter注解，是按照文件名排序执行的，有待求证。
参考
https://blog.csdn.net/u012793120/article/details/53447441

3. @WebFilter的属性
1) urlPatterns 指定过滤的url pattern，如"/*"匹配所有url
2) servletNames 指定作用于的servlet
3) dispatcherTypes 表示servlet调度时的动作，如果此filter匹配到则执行doFilter方法，否则不执行。
调度动作包括请求（Request）、转发（forward）、包含（include）、声明式错误等，默认Request。
可以在web.xml中配置
<filter-mapping>
	<filter-name>myFilter</filter-name>
	<url-pattern>/myHttpServlet</url-pattern>
	<dispatcher>ERROR</dispatcher>
	<dispatcher>FORWARD</dispatcher>
	<dispatcher>REQUEST</dispatcher>
</filter-mapping>
note: web.xml版本要在2.3以上才有此属性

也可以注释配置
dispatcherTypes={DispatcherType.REQUEST, DispatcherType.FORWARD}

配置该过滤器管理的资源当被直接调用或者通过转发调用时起作用。
我们可以在servlet中进行转发调用，这里有两个servlet

下面的Servlet是被过滤器管理的：
@WebServlet(name="myHttpServlet", urlPatterns="/myHttpServlet")
public class MyHttpServlet extends HttpServlet {......}

下面的Servlet是用来调用上面的Servlet的：
@WebServlet(name="myHttpServlet1", urlPatterns="/myHttpServlet1", loadOnStartup=1)
public class MyHttpServlet1 extends HttpServlet {
	private static final long serialVersionUID = 6446908355902952649L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("MyHttpServlet1 request work");
		System.out.println("current thread :" + Thread.currentThread().getName());

		resp.getWriter().write("myHttpServlet1");

		req.getRequestDispatcher("/myHttpServlet").forward(req, resp);
//		req.getRequestDispatcher("/myHttpServlet").include(req, resp);
	}

分析如下：
* 当在上述的Filter中没有DispatcherType.FORWARD时，那么上边通过getRequestDispatcher()调用forward()来访问MyHttpServlet时不会调用过滤器方法，
使用forward()方法只会返回最后一个被调用的资源；
* 当在上述的Filter中没有DispatcherType.INCLUDE时，那么上边通过getRequestDispatcher()调用include()来访问MyHttpServlet时不会调用过滤器方法，
使用include()方法则会将所有经过的资源全部返回；

还有一个是对错误的声明式处理，是在web.xml中进行配置的，如下：
<error-page>
	<error-code>404</error-code>
	<!-- error-code or exception-type can be chosen only one -->
	<!-- <exception-type>java.lang.NullPointerException</exception-type> -->
	<location>/myHttpServlet</location>
</error-page>
当在发生404错误时，则会访问到/myHttpServlet对应的Servlet，这时候如果Filter中没有配置DispatcherType.ERROR，则也不会经过这个过滤器。

其它属性参数源码

filter可以对请求预处理，对响应后处理