<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
</style>
<script type="text/javascript">
	// 브라우저 해시는 서버는 처리 불가능하므로 스크립트 통해서 브라우에서 url 해결 후에 서버로 요청을 진행
	// 브라우저 요청에 hash가 포함되어 있는지 확인
	// 현재 브라우저의 url을 hash 기준 분리함
	// https://www.naver.com/#example -> # 기준으로 분리 # 뒤 나타나는 첫 번째 문자열 반환 -> example
	// https://www.naver.com/#example#test -> 이 경우 2개의 문자열이 나타남
	const hash = window.location.hash.slice(1); 
	
	if (hash) { // hash 값이 있다면
		// decodeURIComponenent("first.jsp")는 파라미로 전달 내용을 uri로 구성
		// 브라우의 현재 요 uri 뒤에 first.jsp 추가해서 요청 가능한 uri로 만들어줌
		window.location.href = decodeURIComponent(window.location.hash.slice(1));
	}
	
	// 1. http://localhost:8081/DOMXSS/domXSS.jsp#first.jsp 요청되면
	// 2. hashchange 이벤트 발생
	// 3. 해시 기준으로 slice 진행 -> first.jsp 반환
	// 4. 현재 요청 서버에 맞는 url을 구성 후 반환
	// http://localhost:8081/DOMXSS/domXSS.jsp -> 페이지명을 first.jsp로 수정후 반환
	// http://localhost:8081/DOMXSS/first.jsp 요청 url이 생성됨
	// window.location.href -> http://localhost:8081/DOMXSS/first.jsp로 지정됨 => 요청진행
	window.addEventListener('hashchange', function() {
		window.location.href = decodeURIComponent(window.location.hash.slice(1));
	});
</script>
<meta charset="UTF-8">
<title>DOM Based XSS 공격</title>
</head>

<body>
  <h1>DOM Based XSS 공격</h1>

  <div class="container">
    <a id="first" href="#first.jsp" class="item">First 바로가기</a> <a
      id="second" href="#second.jsp" class="item">Second 바로가기</a>
  </div>

</body>
</html>