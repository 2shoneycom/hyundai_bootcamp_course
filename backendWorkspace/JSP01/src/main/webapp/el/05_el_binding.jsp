<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>05_el_binding.jsp</title>
<script type="text/javascript">
	let name = "${name}";
	alert(name);
</script>
</head>
<body>
	el 표현 언어로 파라미터값 반환받을 때는 param 내장객체 사용 / request 객체의 attribute 값을 반환 받을 때는 attribute name만 표현 
	id: <%= request.getAttribute("id") %><br>
	pwd: ${pwd }<br>
	name: ${name }<br>
	email: ${email }<br>
	
</body>
</html>