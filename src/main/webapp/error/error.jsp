<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>错误信息友好提示页面</title>
</head>
<body>
	在页面中声明了isErrorPage="true"时，编译成Servlet时会声明exception对象且得到异常信息！<br/>
	那么在页面上就可以引用exception对象！<br/>
	对不起，出错了，请联系管理员解决!<br/>
	异常信息如下：<%=exception.getMessage() %>
</body>
</html>