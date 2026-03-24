<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>09_responseOk.jsp</title>
</head>
<body>
<%!
	String answer;
%>
<%
	request.setCharacterEncoding("utf-8");

	answer = request.getParameter("answer");
	
	if (answer.equals("서울")) {
		response.sendRedirect("pass.jsp"); // 클라이언트에게 응답을 전달하면서 Redirect 신호도 보냄
	}
	else {
		response.sendRedirect("fail.jsp"); // Redircet는 클라이언트로부터 새로운 요청을 진행하게 진행하게 하는 신호
	}
%>
</body>
</html>