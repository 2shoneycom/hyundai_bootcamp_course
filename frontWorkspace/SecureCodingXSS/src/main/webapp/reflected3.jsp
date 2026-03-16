<%@ page language="java" contentType="text/html;charset=UTF-8"
  pageEncoding="UTF-8"%>
<!-- 해당 페이지내 jsp코드는 java 문법을 따르고 나머지 코드는 html 임 
	즉, jsp코드 제외 나머지는 클라이언트에게 태그 그대로 전달됨
-->
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
  <!-- 현재 페이지는 반사되어져서 
	     클라이언트로부터 전송된 파라미터 값을 그대로 다시 클라이언트에게 전송(반사형)함 -->
  <%
  String key;// 자바변수
  // request java 객체는 현제 페이지 요청시 전달되는 파라미터를 다루기 위한 객체 static과 비슷하게 사용됨
  request.setCharacterEncoding("UTF-8");

  key = request.getParameter("keyword"); //keyword 파라미터 값을 추출
  %>
  <%
  // reflected.jsp를 요청한 페이지인 main.jsp쪽으로 다시 파라미터 값 전송
  // 현재 페이지는 어떤 응답도 하지 않고 응답 대상을 main.jsp로 이전
  response.sendRedirect("main3.jsp?keyword=" + key); //현재 페이지를 요청한 클라이언트(브라우저)에게 전달되는 url로 재요청을 요구하게 됨
  // 클라이언트 브라우저는 현재서버의 main.jsp를 재요청하게됨, 파라미터 keyword를 전달하게 됨
  %>

</body>

</html>




