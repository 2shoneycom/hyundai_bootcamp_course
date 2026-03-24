<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");
		
		// user_id가 빈값이면 login 페이지로 제어를 이동
		if (user_id.equals("")) { %>			
			<jsp:forward page="login_forward.jsp" />
	<%	}
	%>
	
	<h3>환영합니다 <%= user_id %>님</h3>
</body>
</html>