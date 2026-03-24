<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.MemberVOEl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el_binding_forward2.jsp</title>
</head>
<body>
	<h3>객체 인스턴스 바인딩</h3>
	<%
		MemberVOEl mem = new MemberVOEl("lee", "1234", "이몽룡", "lee@abc.com");
		// 바인딩
		request.setAttribute("mem", mem);
	%> 
	<jsp:forward page="06_el_binding2.jsp" />
</body>
</html>