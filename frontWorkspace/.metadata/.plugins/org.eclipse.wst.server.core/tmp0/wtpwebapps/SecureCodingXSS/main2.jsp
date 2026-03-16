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
	//js의 정규 표현식 객체는 RegExp를 활용 인스턴스 생성 또는 리터럴 표기법을 활용해서 인스턴스 생성
	//리터럴 표기법은 정규식 패턴문자를 /정규식패턴문자 / 로 묶어서 인스턴스 생성하는 기능

	let re1 = new RegExp('ab+c'); //정규식에서 +는 반복을 의미, + 앞의 문자를 1회이상 반복하는 패턴
	let re2 = new RegExp(/abc/); //문자열에 abc 패턴이 있는지 확인
	let re3 = /abc/;

	//RegExp.test("문자열") : 파라미터로 전달된 문자열이 정규표현식의 패턴과 일치하는지의 결과를 ture/false로 반환하는 메소드
	console.log(re1.test("abbcde"));
	console.log(re2.test("abbccde"));
	console.log(re3.test("abcde"));
	//참조변수없이 정규식 패턴 그대로 사용
	console.log(/abc/.test("abbcde"));

	//정규식 기호 : ^(시작값을 의미, 먼저 표시), +(1회 이상 반복), $(종료값을 의미, 뒤에 표시)
	//정규식 기호 : [] (패턴의 집합), | (or의 의미), - (순서적인 범위를 표현)

	const regex = /^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9| |]+$/; //[]안의 문자중 하나로 시작해야되고 문자는 1번이상 반복될 수 있고 []안의 문자중 하나로 끝나야 함
	console.log(regex.test("<script"));// < 로 시작됨
        	console.log(regex.test("script>"));// > 로 끝남
	console.log(regex.test("scr<ipt"));// []안에 없는 문자가 포함됨
	console.log(regex.test("script"));//[]안에있는 문자로 시작되고 종료되고 반복되고 있음

	function submitHandler() {
		const keyword = document.querySelector("input[name='keyword']");
		const reg = /^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9| |]+$/;
		if (!reg.test(keyword.value)) {
			alert("특수문자는 입력할 수 없습니다");
			return false;
		}
		return true;
	}
</script>
<title>Insert title here</title>
</head>

<body>

  <h1>Reflected XSS 공격</h1>

  <div class="form">
    <form action="reflected2.jsp" method="get"
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
      <%=key%>
    </div>
  </div>

</body>

</html>