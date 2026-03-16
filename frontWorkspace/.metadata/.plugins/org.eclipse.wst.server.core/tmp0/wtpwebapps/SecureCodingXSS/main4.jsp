<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<style>
.form {
  border: #323232 solid 1px;
  margin: auto;
  padding: 10px;
  width: 70vw;
  height: 100%;
}

.form__input {
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

.form__input>div {
  display: flex;
  justify-content: space-between;
}

.form__button {
  margin-top: 10px;
  width: 100%;
}

.container {
  position: relative;
  overflow-x: auto;
  border: #323232 solid 1px;
  margin: 10px auto;
  padding: 10px;
  width: 70vw;
  height: 300px;
}

.container__header {
  position: absolute;
  top: 1rem;
  right: 1rem;
}
</style>
<title>Insert title here</title>
</head>

<body>
  <h1>Reflected XSS 공격</h1>

  <div class="form">
    <form action="reflected4.jsp" method="get">
      <div class="form__input">
        <div>
          <span> 검색 </span>
          <!-- 입력되는 입력값은 reflected.jsp 서버 페이지쪽으로 keyword 파라미터에 담겨서 전달됨 -->
          <input type="text" name="keyword" />
        </div>
      </div>
      <input class="form__button" type="submit" value=" 전송 " />
    </form>
  </div>

  <div class="container">
    <!-- main.jsp를 요청할 때 keyword 파라미터가 전달되면 전달되는 파라미터 값을 화면에 표현 -->
    <%
    request.setCharacterEncoding("UTF-8");
    %>
    <c:set var="key" value="${param.keyword}" />
    <c:if test="${empty key}">
      <c:set var="key" value="" />
    </c:if>
    <div class="container__header">
      검색어
      <c:out value="${key}" />
    </div>
  </div>

</body>
</html>




