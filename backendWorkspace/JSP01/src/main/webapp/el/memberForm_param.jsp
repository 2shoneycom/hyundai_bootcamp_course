<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberForm_param</title>
</head>
<body>
	<form name="frmMember" method="post" action="03_paramResult.jsp">
		아이디: <input type="text" name="id"><br>
		비밀번호: <input type="password" name="pwd"><br>
		이름: <input type="text" name="name"><br>
		이메일: <input type="text" name="email"><br>
		
		<input type="checkbox" name=interests value="웹프로그래밍">웹 프로그래밍
		<input type="checkbox" name=interests value="웹디자인">웹 디자인
		<input type="checkbox" name=interests value="빅데이터">빅데이터
		<input type="checkbox" name=interests value="자바">자바
		<br><br>
		
		<input type="submit" value="확인">
	</form>
</body>
</html>