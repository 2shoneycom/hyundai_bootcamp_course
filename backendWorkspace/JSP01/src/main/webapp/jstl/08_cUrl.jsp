<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value='/css/index.css'/>" > <!-- css 경로 지정 -->
<script src="<c:url value='/js/index.js'/>"></script> 
<title>08_cUrl.jsp</title>
</head>
<body>
	URL 이용: <img src="http://localhost:8080/JSP01/image/apple.png" /><br><br>
	
	URI 이용(Servlet path만 활용): <img src="/image/apple.png" /><br><br>
	<!-- src의 uri가 / 로 시작하면 root로 인식하고 http://localhost:8080/image/apple.png -->
	
	URI 이용(Servlet path만 활용, 현재 위치 기준으로 상대적 주소 생성) : <img src="../image/apple.png" /><br><br>
	<!-- webapp 기준으로 확인하면 08_cUrl.jsp는 webapp>jstl에 있고
	     apple.png는 webapp>image에 있음 두 자원의 경로가 다름. 이 경우는 jstl/image/apple.png로 찾음  -->
	
	c:url 태그 이용(Servlet path만 활용): <img src="<c:url value='/image/apple.png'/>" /><br><br>
	<!-- 어느 위치던 간에 ContextPath 찾아감 -->
	
</body>
</html>