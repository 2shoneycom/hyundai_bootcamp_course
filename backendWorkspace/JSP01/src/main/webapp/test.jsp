<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 페이지</title>
</head>
<body>
	Jsp 세상에 오신 것을 환영합니다<br>
	<%
		// Jsp 태그 영역, 스크립트릿 영역, 자바코드 영역
		// out이라는 객체 인스턴스 JSP 제공 - output 스트림 객체, 컨테이너 버퍼로 출력 전달
		out.println("JSP를 시작합니다");
	%>
</body>
</html>