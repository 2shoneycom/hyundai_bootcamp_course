<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>10_cRedirect.jsp</title>
</head>
<body>
<!-- redirect 되는 페이지이므로 표현되는 출력은 없음, 응답 코드는 302번으로 나타남 -->
<c:redirect url="/jstl/urlParamRes.jsp" >
	<c:param name="id" value="hong" />
	<c:param name="pwd" value="1234" />
	<c:param name="name" value="홍길동" />
	<c:param name="email" value="hong@test.com" />
</c:redirect>
</body>
</html>