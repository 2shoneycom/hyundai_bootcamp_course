<%@page import="java.sql.Timestamp" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.PreparedStatement" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- 사용자가 입력한 값을 전달받아서
	 db에 저장하고 게시글 목록으로 redirect 하는 페이지
	 사용자에게 표현을 보여주지는 않음 - 정적인 코드가 없음
 -->
<% try { 
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	String db_address = "jdbc:oracle:thin:@localhost:29889:xe";
	String db_username="C##SQL_USER";
	String db_pwd="1234";		
	Connection connection = DriverManager.getConnection(db_address, db_username, db_pwd);
	
	//페이지를 요청한 클라이언트 페이지에서 파라미터를 전달함(게시글 파라미터)
	request.setCharacterEncoding("UTF-8");
	//게시글 작성일 생성
	Timestamp today_date = new Timestamp(System.currentTimeMillis());
	
	String writer = request.getParameter("writer");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	int num = 0; //게시글 번호
	//db에 저장된 레코드의 num컬럼에서 가장 큰값을 select 해서 해당 값보다 1 큰값을 사용함	
	String qry = "select max(num) from pratice_board";	
	PreparedStatement pstmt = connection.prepareStatement(qry);	
	ResultSet result = pstmt.executeQuery();
	
	while(result.next()){
		num = result.getInt("max(num)");
	}
	num = num+1;
	
	String insertQuery = "INSERT INTO pratice_board(num, title, writer, content, regdate) VALUES(?,?,?,?,?)";
	pstmt = connection.prepareStatement(insertQuery);
	
	pstmt.setInt(1, num);
	pstmt.setString(2,title);
	pstmt.setString(3,writer);
	pstmt.setString(4,content);
	pstmt.setTimestamp(5, today_date);
	
	pstmt.executeUpdate();
	
	response.sendRedirect("post_list.jsp");
	
	} catch (Exception ex) { 
		out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
	}
%>









