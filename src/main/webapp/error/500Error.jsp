<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 3秒钟后自动跳转回首页 -->
<meta http-equiv="refresh" content="3;url=<%=request.getContextPath()%>/index.jsp">
<title>500(服务器错误)错误友好提示页面</title>
</head>
<body>
	500 对不起，服务器出错!<br/>
	3秒钟后自动跳转回首页，如果没有跳转，请点击<a href="<%=request.getContextPath()%>/index.jsp">这里</a>
</body>
</html>