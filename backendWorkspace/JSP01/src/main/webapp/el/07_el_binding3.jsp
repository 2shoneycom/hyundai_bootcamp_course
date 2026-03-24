<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>07_el_binding3.jsp</title>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	<h3>회원 정보 수정</h3>
	<form method="post" action="memberUpdate.jsp">
		아이디: <input type="text" name="id" value="${mem.id }" readonly><br>
		비밀번호: <input type="text" name="pwd" value="${mem.pwd }"><br>
		이름: <input type="text" name="name" value="${mem.name }"><br>
		이메일: <input type="text" name="email" value="${mem.email }"><br>
		<input type="submit" value="수정 완료">
	</form>
</body>
</html>