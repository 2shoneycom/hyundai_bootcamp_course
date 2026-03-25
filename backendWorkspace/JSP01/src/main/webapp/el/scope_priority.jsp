<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scope_priority.jsp</title>
</head>
<body>
	<%
		application.setAttribute("name", "application");
	%>
		<jsp:forward page="17_scope_priority_result.jsp" />
</body>
</html>