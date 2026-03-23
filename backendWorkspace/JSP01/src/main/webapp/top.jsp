<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%!
	Date date = new Date();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>top.jsp</title>
</head>
<body>
	<font color="blue" size="3pt">
		top 페이지 입니다 <p>
		<%=date.toLocaleString()%>
	</font>
</body>
</html>