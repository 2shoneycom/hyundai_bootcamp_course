<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! 
	int width, height;
%>
<% 
	width = Integer.parseInt(request.getParameter("width"));
	height = Integer.parseInt(request.getParameter("height"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>10_typeConversionOk.jsp</title>
</head>
<body>
	사각형의 면적: <%= width * height %>
</body>
</html>