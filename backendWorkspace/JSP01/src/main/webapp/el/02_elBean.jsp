<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="student" class="bean.StudentBean" scope="page">
	<jsp:setProperty name="student" property="stdName" value="홍길동"/>
</jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
	${empty student }<br><%-- student 객체가 null인가 --%>
	${not empty student }<br>
	${student.stdName }<br>
</body>
</html>