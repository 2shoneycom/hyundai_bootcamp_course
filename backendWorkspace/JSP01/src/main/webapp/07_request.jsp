<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>07_request.jsp</title>
</head>
<body>
<%
	// out: 톰캣 컨테이너 버퍼로 출력 -> 클라이언트에 응답 데이터
	out.println("요청 대상 서버명 : " + request.getServerName() + "<br>");
	out.println("요청 대상 포트번호 : " + request.getServerPort() + "<br>");
	out.println("요청 방식 : " + request.getMethod() + "<br>");
	out.println("요청 프로토콜 : " + request.getProtocol() + "<br>");
	out.println("URL : " + request.getRequestURL() + "<br>");
	out.println("URI : " + request.getRequestURI() + "<br>");
	out.println("ContextPath : " + request.getContextPath() + "<br>");
	out.println("ServletPath : " + request.getServletPath() + "<br>");
	
%>
</body>
</html>