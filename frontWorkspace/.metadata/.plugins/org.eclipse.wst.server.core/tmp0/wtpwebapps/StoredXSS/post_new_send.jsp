<%@page import="java.sql.Timestamp" %>
	<%@page import="java.sql.DriverManager" %>
		<%@page import="java.sql.Connection" %>
			<%@page import="java.sql.ResultSet" %>
				<%@page import="java.sql.PreparedStatement" %>
					<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

						<% try { } catch (Exception ex) { out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
}
%>