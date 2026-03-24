<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="frmMember" method="post" action="newMemberOk.jsp">
		아이디: <input type="text" name="memId"><br>
		비밀번호: <input type="password" name="memPwd"><br>
		이름: <input type="text" name="memName"><br>
		이메일: <input type="text" name="memEmail"><br>
		
		<input type="submit" value="가입하기"><input type="reset" value="다시 입력">
	</form>
</body>
</html>