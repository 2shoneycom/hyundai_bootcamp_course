<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		int add (int a, int b) {
			return a * b;
		}
		
		int x = 10, y = 20; 
	%>

	표현식에서는 변수값, 메소드 호출 반환 표현 가능, 계산식 표현 가능<br>
	x 변수의 값: <%= x %><br>
	y 변수의 값: <%= y %><br>
	add 함수 호출 결과: <%= add(x,y) %><br>
	x + y의 계산 결과: <%= x+y %><br>
</body>
</html>