<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>urlParamRes.jsp</title>
</head>
<body>
	<table align="center" border="1">
		<tr align="center" bgcolor="lightgreen">
			<td width="7%"><b>아이디</b></td>
			<td width="7%"><b>비밀번호</b></td>
			<td width="7%"><b>이름</b></td>
			<td width="7%"><b>이메일</b></td>
		</tr>
		<tr>
			<td>${param.id }</td>
			<td>${param.pwd }</td>
			<td>${param.name }</td>
			<td>${param.email }</td>
		</tr>
	</table>
</body>
</html>