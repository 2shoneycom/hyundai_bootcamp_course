<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	학번 : ${no}<br>
	성명 : ${name}<br>
	학년 : ${year}<br>
	
	<p>url을 통한 데이터 전달</p>
	검색(학번) : <a href="/data2/student/studentDetailView/${no}">${no}</a><br>
	검색(학번) : <a href="/data2/student/studentDetailView1/${no}/${name}/${year}">여러 데이터 전달</a><br>
	검색(학번) : <a href="/data2/student/studentDetailView1/1111/홍길동/4">여러 데이터 전달</a><br>
	
</body>
</html>