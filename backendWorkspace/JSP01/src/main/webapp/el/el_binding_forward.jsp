<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el_binding_forward.jsp</title>
</head>
<body>

	<%
		request.setAttribute("id", "hong");
		request.setAttribute("pwd", 1234);
		request.setAttribute("name", "홍길동");
		request.setAttribute("email", "hong@test.com");
	%>
	<jsp:forward page="05_el_binding.jsp" />
	JSP 액션 태그 forward는 제어를 이동할 때 현재 페이지의 request, response를 전달함<br>
	reqeust 객체에 데이터 바인딩해서 넘김
</body>
</html>