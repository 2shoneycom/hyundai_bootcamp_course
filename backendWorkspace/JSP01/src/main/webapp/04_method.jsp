<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04_method.jsp</title>
</head>
<body>
	<%!
		String id = "abcd";
		
		public String getId() {
			return id;
		}
	%>
	메소드 선언은 반드시 선언부에서 정의해야 함<br>
	<% // 스크립트릿
		String id = "abcd"; // 변수 선언은 가능 (지역변수)
		
		// 메소드는 선언 불가능 (호출만 가능)
		/* public String getId() {
			return id;
		} */
	%>
	id 변수 : <%= id %><br>
	getId() 메소드 호출 결과: <%= getId() %>
</body>
</html>