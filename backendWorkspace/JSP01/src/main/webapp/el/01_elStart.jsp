<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>01_elStart.jsp</title>
</head>
<body>
<%-- ${}는 el을 나타내는 기호, {}내의 값을 현위치에 출력 --%>
	{100} : \${100} : ${100} <br>
	${3.14} <br>
	${"홍길동" }<br>
	${true }<br>
	${true && true }<br>
	${10+1 }<br>
	<%= true %><br>
	<%= 10+1 %><br>
	${100 mod 9 }<%-- mod: 나머지 연산 --%><br>
	<%-- ${"hello"+"world" } --%><br>
	<%-- el표현어 코드에 대한 주석은 jsp 주석 시용해야 함 --%>
</body>
</html>