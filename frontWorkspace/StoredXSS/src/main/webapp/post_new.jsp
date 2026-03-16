<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	function submitHandler() {
		// (1번 방식) 입력값 필터링
		let title = document.querySelector("input[name='title']");
		let writer = document.querySelector("input[name='writer']");
		let content = document.querySelector("textarea[name='content']");
		
		const reg = /^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9| |]+$/;
		
		if (!reg.test(title.value) || !reg.test(writer.value) || !reg.test(content.value)) {
			alert("특수문자는 입력할 수 없습니다");
			return false;
		}
		return true;
	}
</script>
<title>신규 게시글 작성</title>
</head>
<body>
  <h1>신규 게시글 작성</h1>
  <form action="post_new_send.jsp" method="post" onsubmit = "return submitHandler()">
    <table>
      <tr>
        <td>작성자</td>
        <td><input type="text" name="writer"></td>
      </tr>
      <tr>
        <td>제목</td>
        <td><input type="text" name="title"></td>
      </tr>
      <tr>
        <td>내용</td>
        <td><textarea rows="10" cols="20" name="content"></textarea></td>
      </tr>
      <tr>
        <td colspan="2">
          <button type="submit">저장</button>
          <button type="button" onclick="location.href='post_list.jsp'">목록으로</button>
          <button type="reset">초기화</button>
        </td>
      </tr>
    </table>
  </form>
</body>
</html>