<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="mB" class="bean.MemberVOEl" />
<jsp:useBean id="mC" class="bean.MemberVOEl" />
<jsp:useBean id="memberList" class="java.util.ArrayList" />

<%
	mB.setId("son");
	mB.setName("손흥민");
	
	mC.setId("park");
	mC.setName("박지성");
	
	memberList.add(mB);
	memberList.add(mC);
%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el 표현어로 배열</title>
</head>
<body>
	회원 1 이름 : ${memberList[0].getName() }<br>
	회원 2 이름 : ${memberList[1].getName() }<br>
</body>
</html>