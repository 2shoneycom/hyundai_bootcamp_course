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
%>
	<jsp:useBean id="member" class="bean.MemberBean" scope="page">
		<jsp:setProperty property="*" name="member" />
	</jsp:useBean>
	
	<h3>Bean 속성값 출력</h3>
	아이디 : <%= member.getMemId() %><br>
	비밀번호 : <%= member.getMemPwd() %><br>
	성명 : <%= member.getMemName() %><br>
	이메일 : <%= member.getMemEmail() %><br>
</body>
</html>