<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index 페이지</title>
	</head>
	<body>
		<h3>MyBatis 사용 DB 연동 : 상품 관리</h3><br>
		
		<a href="/mybatis/product/listAllProduct">전체 상품 조회</a><br> 
		<a href="<c:url value='/product/listAllProduct'/>">전체 상품 조회</a><br>
		<a href="<c:url value='/product/newProductForm'/>">상품 등록</a><br>
		<a href="<c:url value='/product/productSearchForm1'/>">상품 검색 1</a><br>
		<a href="<c:url value='/product/productSearchForm2'/>">상품 검색 2</a><br>
		<a href="<c:url value='/product/productSearchForm3'/>">상품 검색 3(RestController)</a><br>
		
		<h3>이미지 연습</h3>
		resoruces 폴더 활용 : <img src="<c:url value='/resources/image/apple.png'/>"/><br>
		/images/의 매핑을 새로 적용 : <img src="<c:url value='/images/apple.png'/>"/>
		
		<h3>Ajax 연습</h3>
		<a href="<c:url value='/loginForm'/>">로그인</a>

</body>
</html>



