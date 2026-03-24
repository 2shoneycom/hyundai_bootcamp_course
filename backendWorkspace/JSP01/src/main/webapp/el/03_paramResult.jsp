<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03_paramResult.jsp</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
%>
	Request 객체의 파라미터로 전달된 데이터는 el 표현어의 param 내장객체를 통해 접근 가능<br>
	아이디 : ${param.id } <br>
	비밀번호 : ${param.pwd } <br>
	이름 : ${param.name } <br>
	이메일 : ${param.email }<br>
	관심분야 : ${param.interests }<br>
	관심분야 : ${paramValues.interests }<br>
	paramValues는 참조 가능한 배열 반환하는 객체<br>
	
</body>
</html>