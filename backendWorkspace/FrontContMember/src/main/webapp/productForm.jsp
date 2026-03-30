<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	isELIgnored="false" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>상품 등록 창</title>
<body>
<form method="post"   action="${contextPath }/product/addProduct.do">
<h1  style="text-align:center">상품 등록 창</h1>
<table  align="center">
    <tr>
       <td width="200"><p align="right">상품 번호</td>
       <td width="400"><input type="text" name="prdNo"></td>
    </tr>
    <tr>
        <td width="200"><p align="right">상품 명</td>
        <td width="400"><input type="password"  name="prdName"></td>
    </tr>
    <tr>
        <td width="200"><p align="right">가격</td>
        <td width="400"><p><input type="text"  name="prdPrice"></td>
    </tr>
    <tr>
        <td width="200"><p align="right">재고</td>
        <td width="400"><p><input type="text"  name="prdStock"></td>
    </tr>
    <tr>
        <td width="200"><p align="right">입고일</td>
        <td width="400"><p><input type="text"  name="prdDate"></td>
    </tr>
    <tr>
        <td width="200"><p align="right">회사명</td>
        <td width="400"><p><input type="text"  name="prdCompany"></td>
    </tr>
    <tr>
        <td width="200"><p>&nbsp;</p></td>
        <td width="400">
	       <input type="submit" value="가입하기">
	       <input type="reset" value="다시입력">
       </td>
    </tr>
</table>
</form>
</body>
</html>
