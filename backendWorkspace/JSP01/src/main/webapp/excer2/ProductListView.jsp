<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
     .cls1 {
       font-size:40px;
       text-align:center;
     }
    
     .cls2 {
       font-size:20px;
       text-align:center;
     }
</style>
</head>
<body>
	<p class="cls1"><h4>상품 정보</h4></p>
	<table align="center" border="1">
		<tr align="center" bgcolor="lightgreen">
			<td width="7%"><b>상품번호</b></td>
			<td width="7%"><b>상품명</b></td>
			<td width="7%"><b>가격</b></td>
			<td width="7%"><b>재고</b></td>
			<td width="7%"><b>출시일</b></td>
			<td width="7%"><b>회사</b></td>
		</tr>
		<c:choose>
			<c:when test="${empty prdList }">
			<tr>
				<td colspan="5">등록된 상품이 없습니다</td>
			</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="product" items="${prdList }" >
					<tr>
						<td>${product.prdNo }</td>
						<td>${product.prdName }</td>
						<td>${product.prdPrice }</td>
						<td>${product.prdStock }</td>
						<td>${product.prdDate }</td>
						<td>${product.prdCompany }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>

</body>
</html>