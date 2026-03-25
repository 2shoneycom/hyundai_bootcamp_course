<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c_forEach_ArrayList_result_ex.jsp</title>
</head>
<body>
	<table align="center" border="1">
		<tr align="center" bgcolor="lightgreen">
			<td width="7%"><b>상품 번호</b></td>
			<td width="7%"><b>상품명</b></td>
			<td width="7%"><b>가격</b></td>
			<td width="7%"><b>회사</b></td>
		</tr>
		<c:forEach var="prd" items="${prdList }">
		<tr>
			<td>${prd.prdNo }</td>
			<td>${prd.prdName }</td>
			<td>${prd.prdPrice }</td>
			<td>${prd.prdCompany }</td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>