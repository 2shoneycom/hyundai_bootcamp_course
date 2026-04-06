<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 조회</title>
</head>
<body>
	<h3>조회하신 상품 정보는 다음과 같습니다(command 객체 사용)</h3>
	<hr>
	상품번호 : ${product.prdNo } <br>
	상품명 : ${product.prdName }<br>
	가격 : ${product.prdPrice } <br>
	제조회사 : ${product.prdCompany } <br>
	제조일 : ${product.prdDate } <br>
	재고 : ${product.prdStock } <br>
</body>
</html>