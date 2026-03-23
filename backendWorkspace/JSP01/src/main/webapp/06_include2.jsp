<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String name="홍길동";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06_include.jsp</title>
</head>
<body>
	<!-- top.jsp  -->
	이 부분에 top.jsp의 내용이 포함됩니다<p>
	<%@ include file="top2.jsp" %>
	<hr>
	<h3>본문</h3>
	이 부분은 06_include.jsp의 내용입니다<p>
	<hr>
	<!-- bottom.jsp -->
	이 부분에 bottom.jsp의 내용이 포함됩니다<p>
	<%@ include file="bottom2.jsp" %>
</body>
</html>