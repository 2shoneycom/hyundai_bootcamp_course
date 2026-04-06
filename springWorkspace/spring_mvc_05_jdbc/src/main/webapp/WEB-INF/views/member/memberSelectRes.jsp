<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 조회</title>
</head>
<body>
	<table border="1">
		<tr align="center" bgcolor="lightgreen">
			<th width="7%">아이디</th>
			<th width="7%">비밀번호</th>
			<th width="7%">이름</th>
			<th width="7%">이메일</th>
			<th width="7%">가입일</th>
		</tr>
		<c:forEach var="mem" begin="0" end="${memList.size()}" step="1" items="${memList}" >
			<tr>
				<td width="7%">${mem.memId}</td>
				<td width="7%">${mem.memPwd}</td>
				<td width="7%">${mem.memName}</td>
				<td width="7%">${mem.memEmail}</td>
				<td width="7%">${mem.memJoinDate}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>