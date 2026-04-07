<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>전제 도서 조회</title>		 
	</head>
	<body>
		<h3>전체 도서 조회</h3>		
		<table border="1" width="600">
			<tr><th>도서번호</th>
			<th>도서명</th>
			<th>저자</th>
			<th>가격</th>
			<th>출판일</th>
			<th>재고</th>
			<th>출판사</th>
			</tr>
			
			<c:forEach items="${bookList}" var="book" >
				<tr>
					<td><a href="<c:url value='/book/detailViewBook/${book.bookNo}'/>">${book.bookNo}</a></td>
					<td>${book.bookName}</td>
					<td>${book.bookAuthor}</td>
					<td>${book.bookPrice}</td>
					<td><fmt:formatDate value="${book.bookDate}" pattern="yyyy-MM-dd" /></td>
					<td>${book.bookStock}</td>
					<td>${book.pubNo}</td>
				</tr>
			</c:forEach>

		</table><br><br>
		
		<!--  index 페이지로 이동 링크 추가 -->
		<a href="<c:url value='/'/>">홈으로 이동</a>
	</body>
</html>