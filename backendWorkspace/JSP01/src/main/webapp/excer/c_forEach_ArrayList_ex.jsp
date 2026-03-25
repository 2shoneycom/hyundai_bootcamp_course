<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="bean.*" %>
<%
	ProductVO vo1 = new ProductVO("111", "tv", 100, "lg");
	ProductVO vo2 = new ProductVO("222", "phone", 200, "apple");
	ProductVO vo3 = new ProductVO("333", "laptop", 300, "samsung");
	
	ArrayList<ProductVO> prdList = new ArrayList<ProductVO>();
	prdList.add(vo1);
	prdList.add(vo2);
	prdList.add(vo3);
	
	request.setAttribute("prdList", prdList);
%>
<jsp:forward page="c_forEach_ArrayList_result_ex.jsp"></jsp:forward>
