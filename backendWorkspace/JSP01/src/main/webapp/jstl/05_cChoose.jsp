<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="id" value="hong" scope="page" />
<c:set var="pwd" value="1234" scope="page" />
<c:set var="name" value="${'홍길동' }" scope="page" />
<c:set var="age" value="${20 }" scope="page" />
<c:set var="height" value="${170  }" scope="page" />   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>05_cChoose.jsp</title>
</head>
<body>
	<table align="center" border="1">
		<tr align="center" bgcolor="lightgreen">
			<td width="7%"><b>아이디</b></td>
			<td width="7%"><b>비밀번호</b></td>
			<td width="7%"><b>이름</b></td>
			<td width="7%"><b>나이</b></td>
			<td width="7%"><b>키</b></td>
		</tr>
		<!--  -->
		<c:choose>
			<c:when test="${name==null }">
				<tr align="center"><td colspan="5">이름이 없습니다</td></tr>
			</c:when>
			<c:when test="${empty age }">
				<tr align="center"><td colspan="5">나이가 없습니다</td></tr>
			</c:when>
			<c:when test="${height=='' }">
				<tr align="center"><td colspan="5">키가 없습니다</td></tr>
			</c:when>
			<c:otherwise>
				<tr align="center">
					<td>${id }</td>
					<td>${pwd }</td>
					<td>${name }</td>
					<td>${age }</td>
					<td>${height }</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>