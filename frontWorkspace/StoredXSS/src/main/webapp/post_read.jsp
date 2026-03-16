<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>게시글 상세 열람</title>
</head>

<body>
  <h1>게시글 상세 열람</h1>
  <%
  try {
  	Class.forName("oracle.jdbc.driver.OracleDriver");

  	String db_address = "jdbc:oracle:thin:@localhost:29889:xe";
  	String db_username = "C##SQL_USER";
  	String db_pwd = "1234";
  	Connection connection = DriverManager.getConnection(db_address, db_username, db_pwd);

  	// 게시글 보기: 특정 게시글 출력
  	// 게시글 파라미터 필요
  	request.setCharacterEncoding("UTF-8");

  	// 전달되는 파라미터는 문자열임
  	String num = request.getParameter("num");

  	String readQuery = "SELECT * FROM pratice_board WHERE num= " + num;

  	PreparedStatement pstmt = connection.prepareStatement(readQuery);

  	ResultSet result = pstmt.executeQuery();
  %>

  <table border="1">
    <%
    while (result.next()) {
    %>
    <tr>
      <td>번호</td>
      <td><%=result.getInt("num")%></td>
    </tr>
    <tr>
      <td>작성일</td>
      <td><%=result.getTimestamp("regdate")%></td>
    </tr>
    <!-- (방식 3번) 직접 출력 금지 처리 -->
    <tr>
      <td>작성자</td>
      <td><c:out value=result.getString("writer") /></td>
    </tr>
    <tr>
      <td>제목</td>
      <% String title = result.getString("title"); %>
      <c:set var="title" value="${title}" />
      <td><c:out value="${title}" /></td>
    </tr>
    <tr>
      <td>내용</td>
      <td><c:out value=result.getString("content") /></td>
    </tr>
    <tr>
      <td colspan="2">
        <button type=button onclick="location.href='post_list.jsp'">목록으로</button>
      </td>
    </tr>
    <%
    }
    %>
  </table>
  <%
  } catch (Exception ex) {
  out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
  }
  %>

</body>
</html>