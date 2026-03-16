<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
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
<script type="text/javascript">
	function submitHandler() {
		//입력값 검증, 서버에 특수문자를 전달할 때 공격시 사용되는 아스키코드가 아닌 참조문자로 변환 후 전달
		let value = document.querySelector("input[name='keyword']").value;
		value = value.replaceAll("&", "&amp;");
		value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
		value = value.replaceAll("/", "&#x2F;");
		value = value.replaceAll("'", "&#x27;");
		value = value.replaceAll("\"", "&quot;");
		document.querySelector("input[name='keyword']").value = value;
	}
</script>
<title>Insert title here</title>
</head>

<body>
  <h1>Reflected XSS 공격</h1>

  <div class="form">
    <form action="reflected3.jsp" method="get"
      onsubmit="return submitHandler()">
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
    String key = request.getParameter("keyword");
    if (key == null) {
    	key = "";
    }
    %>

    <div class="container__header">
      검색어
      <%=key + "&lt;script&gt;"%>
    </div>
  </div>

</body>

</html>