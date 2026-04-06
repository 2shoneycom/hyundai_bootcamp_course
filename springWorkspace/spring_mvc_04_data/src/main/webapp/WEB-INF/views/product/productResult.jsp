<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 조회</title>
</head>
<body>
	<h3>조회하신 상품 정보는 다음과 같습니다</h3>
	<hr>
	상품번호 : ${prdNo} <br>
	상품명 : ${prdName}<br>
	가격 : ${prdPrice} <br>
	제조회사 : ${prdCompany} <br>
	제조일 : ${prdDate} <br>
	재고 : ${prdStock} <br>
	
	<br>
	url을 통해서 데이터 전달 : @PathVariable<br>
	상품명 : <a href="/data2/product/productDetailView/${prdName}">${prdName}</a><br>
	상품데이터 : <a href="/data2/product/productDetailView/${prdName}/${prdCompany}/${prdStock}">데이터 전송</a><br>
</body>
</html>