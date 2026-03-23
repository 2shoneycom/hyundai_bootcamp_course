<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%!
	// 변수 선언 스크립트
	int x = 10; // 변수 선언하면서 바로 초기화는 가능
	long y; // 변수 선언만 가능
	// y = 10; // 선언된 변수에 값 저장은 불가능
	float floatValue = 3.14F;
	double doubleValue = 3.14;
	
	char ch = 'a';
	String myJob = "프로그래머";
	
	boolean b = true;
%>
<%
	y = 100;
%>
</head>
<body>
	표현식은 해당 데이터가 출력되어야 할 영역(태그)에서 사용
	<h3>변수 값 출력</h3>
	x: <%= x %><br>
	y: <%= y %><br>
	floatValue: <%= floatValue %><br>
	doubleValue: <%= doubleValue %><br>
	myJob: <%= myJob %><br>
	b: <%= b %><br>
</body>
</html>