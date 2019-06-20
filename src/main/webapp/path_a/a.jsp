<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.http.Cookie" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	path_a/a.jsp <br/>
	<%
		Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies) {
	%>
		<%=c.getName()+", "+c.getValue()+", "+c.getPath() %><br/>
	<%
		}
	%>
</body>
</html>