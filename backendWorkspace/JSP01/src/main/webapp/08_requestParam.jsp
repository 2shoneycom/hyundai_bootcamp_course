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
		// 선언부에 변수 선언
		String id, name, pwd, email;
		String interests[];
	%>
	
	<%
		request.setCharacterEncoding("UTF-8");
		// 한개 파라미터 값 반환
		id = request.getParameter("id");
		name = request.getParameter("name");
		pwd = request.getParameter("pwd");
		email = request.getParameter("email");
		interests = request.getParameterValues("interests");
	%>
	<!-- 변수에 저장된 값 출력(응답데이터로 표현) : 표현식 사용 -->
	성명 : <%= name %><br>
	아이디 : <%= id %><br>
	비밀번호 : <%= pwd %><br>
	이메일 : <%= email %><br>
	관심분야 : 
	<% for (String interest : interests) { %>
			<%= interest + ", " %>
	<% } %>
	<br>
</body>
</html>