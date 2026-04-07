<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상품 정보 수정</title>
	</head>
	<body>
		<h3>상품 정보 수정</h3>
		<form method="post" action="<c:url value='/product/updateProduct'/>">
			<table>
				<tr><td>상품 번호</td>
					<td><input type="text" name="prdNo" id="prdNo" ></td></tr>
				<tr><td>상품명</td>
					<td><input type="text" name="prdName"  ></td></tr>
				<tr><td>가격 </td>
					<td> <input type="text" name="prdPrice"  ></td></tr>
				<tr><td>제조회사</td>
					<td><input type="text" name="prdCompany" ></td></tr>
				<tr><td>재고 </td> 
					<td><input type="text" name="prdStock"  ></td></tr>
				<tr><td>제조일 </td> 
					<td><input type="text" name="prdDate" ></td></tr>
				<tr><td colspan="2"><input type="submit" value="수정">
				<input type="reset" value="취소"></td></tr>
			</table>
		</form><br><br>
		
		<a href="<c:url value='/' />">[홈으로 이동]</a> 
	
	
	</body>
</html>