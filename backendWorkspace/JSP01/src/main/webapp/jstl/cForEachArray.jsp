<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="bean.MemberVOEl" %>
<%
	// cForEachArray.jsp
	
	MemberVOEl vo1 = new MemberVOEl("kim", "1234", "김길동", "kim@abc.com");
	MemberVOEl vo2 = new MemberVOEl("lee", "1234", "이길동", "lee@abc.com");
	MemberVOEl vo3 = new MemberVOEl("park", "1234", "막길동", "park@abc.com");
	
	ArrayList<MemberVOEl> memList = new ArrayList<MemberVOEl>();
	memList.add(vo1);
	memList.add(vo2);
	memList.add(vo3);
	
	request.setAttribute("memList", memList);

%>
<jsp:forward page="07_cForEachArrayList.jsp" />