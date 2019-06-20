<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp的Include指令测试</title>
</head>
<body>
	<%--使用include标签引入引入其它JSP页面--%>
	<%@include file="/jspfragments/head.jspf" %>
	<h1>网页主体内容</h1>
	<%@include file="/jspfragments/foot.jspf" %>
</body>
</html>