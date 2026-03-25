<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%--
	쿼리 스트링: uri?id=hong&pwd=1234&name=홍길동&email=hong%40test.com
	<c:url> 태그 블럭에 sub 태그로 c:param 사용 가능
	: url에 쿼리 스트링 방식으로 파라미터를 구성해 줌
 --%>
    
<c:url var="url1" value="/jstl/urlParamRes.jsp" >
	<c:param name="id" value="hong" />
	<c:param name="pwd" value="1234" />
	<c:param name="name" value="홍길동" />
	<c:param name="email" value="hong@test.com" />
</c:url>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>09_cUrlParam.jsp</title>
</head>
<body>
	<a href="${url1 }">회원 정보 출력</a>
</body>
</html>