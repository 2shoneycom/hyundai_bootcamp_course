<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>07_cForEachArrayList.jsp</title>
</head>
<body>
	<table align="center" border="1">
		<tr align="center" bgcolor="lightgreen">
			<td width="7%"><b>아이디</b></td>
			<td width="7%"><b>비밀번호</b></td>
			<td width="7%"><b>이름</b></td>
			<td width="7%"><b>이메일</b></td>
		</tr>
		<c:forEach items="${memList }" var="data">
		<tr>
			<td>${data.id }</td>
			<td>${data.pwd }</td>
			<td>${data.name }</td>
			<td>${data.email }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
