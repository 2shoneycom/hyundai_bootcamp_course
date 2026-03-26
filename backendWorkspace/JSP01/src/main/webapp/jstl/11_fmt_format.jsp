<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>11_fmt_format.jsp</title>
</head>
<body>
	<h3>fmt:formatNumber 태그 이용한 숫자 포맷팅</h3>
	<c:set var="price" value="1000000" />
	기본(천단위 구분) : <fmt:formatNumber value="${price }" type="number"/><br>
	원화 : <fmt:formatNumber value="${price }" type="currency" currencySymbol="￦"/><br>
	달러 : <fmt:formatNumber value="${price }" type="currency" currencySymbol="$"/><br>
	천 단위 구분 없음 : <fmt:formatNumber value="${price }" type="number" groupingUsed="false"/><br>
	퍼센트 : <fmt:formatNumber value="${price }" type="percent" groupingUsed="true"/><br>
	<hr>
	<h3>fmt:formatDate 태그 이용한 날짜 포맷팅</h3>
	<c:set var="now" value="<%= new Date() %>" />
	<fmt:formatDate value="${now }" type="date" /><br>
	<fmt:formatDate value="${now }" type="date" dateStyle="full" /><br>
	<fmt:formatDate value="${now }" type="date" dateStyle="short" /><br>
	<fmt:formatDate value="${now }" type="time" /><br>
	<fmt:formatDate value="${now }" type="time" timeStyle="full" /><br>
	<fmt:formatDate value="${now }" type="time" timeStyle="short" /><br>
	<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full" /><br>
	
</body>
</html>