<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<%
request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 출력창</title>
<c:if test='${msg="add" }'>
	<script>
		window.onload= function() {
			alert("상품을 등록했습니다");
		}
	</script>
</c:if>
<c:if test='${msg="mod" }'>
	<script>
		window.onload= function() {
			alert("상품 정보를 수정 했습니다");
		}
	</script>
</c:if>
<style>
.cls1 {
	font-size: 40px;
	text-align: center;
}

.cls2 {
	font-size: 20px;
	text-align: center;
}
</style>

</head>
<body>
	<p class="cls1">상품 정보</p>
	<table align="center" border="1">
		<tr align="center" bgcolor="lightgreen">
			<td width="7%"><b>상품번호</b></td>
			<td width="7%"><b>상품명</b></td>
			<td width="7%"><b>가격</b></td>
			<td width="7%"><b>재고</b></td>
			<td width="7%"><b>입고일</b></td>
			<td width="7%"><b>회사</b></td>
			<td width="7%"><b>수정</b></td>
			<td width="7%"><b>삭제</b></td>
		</tr>
		<c:choose>
			<c:when test="${empty productList }">
				<tr>
					<td colspan="8">등록된 상품이 없습니다</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="prd" items="${productList }">
					<tr align="center">
						<td>${prd.prdNo }</td>
						<td>${prd.prdName }</td>
						<td>${prd.prdPrice }</td>
						<td>${prd.prdStock }</td>
						<td>${prd.prdDate }</td>
						<td>${prd.prdCompany }</td>
						<td><a href="${contextPath }/product/modProduct.do?id=${prd.prdNo}">수정</a></td>
						<td><a href="${contextPath }/product/delProduct.do">삭제</a></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<a href="${contextPath }/product/productForm.do"><p class="cls2">상품 등록</p></a>
</body>
</html>
