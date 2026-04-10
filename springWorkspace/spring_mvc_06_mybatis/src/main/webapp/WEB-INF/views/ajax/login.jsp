<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="icon" type="image/png" href="#" />
		<script src="/mybatis/js/jquery-3.7.1.min.js"></script>
		<script src="/mybatis/js/login.js"></script>


	</head>
	<body>	
		<form  id="frmLogin" >
			아이디 : <input type="text" id="user_id" name="user_id"><br>
			비밀번호 : <input type="password" id="user_pw" name="user_pw" ><br>
			<input type="submit" value="로그인"> <input type="reset" value="취소">
		</form> <br><br>
		<a href="<c:url value='/'/>">[메인 메뉴]</a><br>
	
	</body>
</html>