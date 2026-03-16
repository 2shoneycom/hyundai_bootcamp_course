<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
</style>
<script type="text/javascript">
	window.addEventListener('hashchange', function() {
		let hash = window.location.hash.slice(1);
		// 필터링 함수 호출
		if (cleanXSS(hash)) {
			let subUrl = decodeURIComponent(hash);
			window.location.href = subUrl;
		}
	});
	
	const cleanXSS = (keyword) => {
		const regex = /^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9|.|]+$/;
		if (!regex.test(keyword)) {
			alert("요청 주소에 허가되지 않은 특수문자가 있습니다");
			return false;
		} 
		return true;
	};
</script>
<meta charset="UTF-8">
<title>DOM Based XSS 공격</title>
</head>

<body>
  <h1>DOM Based XSS 공격</h1>
  <div class="container">
    <a id="first" href="#first.jsp" class="item">First 바로가기</a> 
    <a id="second" href="#second.jsp" class="item">Second 바로가기</a>
  </div>
</body>
</html>